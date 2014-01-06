package TESCAdventure;

import java.lang.Thread.*;
import java.util.Random;


public class ThreadNPC extends Thread {
	/* Controlling Constants */
	private static final int ATK_PROB = 40;
	private static final int SLEEP_TIME = 5000; 	// Seconds
	
	private static Random rand = new Random();

	private NPC npc;
	private GameState gameState;
	private boolean isActivating;
	private boolean getLock;
	
	public ThreadNPC (NPC npc, GameState game) {
		this.npc = npc;
		this.gameState = game;
		this.getLock = false;
		this.isActivating = true;
	}


	public void run() {
		ListNode<Integer> battleSync = null;

		while (isActivating) 
		{
			if (gameState.getCurrentGameMode() == MainEngine.GameMode.EXPLORATION) 
			{
				/* Attack Probability */
				if (atkProb()) 
				{
					if(gameState.getLock()) 
					{
						gameState.startBattle(npc);
						this.getLock = true;
					}
				} 
				else 
				{
					try
					{
						Thread.sleep(SLEEP_TIME);
					} catch (InterruptedException e)
					{
						e.printStackTrace();
					}
				}

			} 
			else {
				if(this.getLock && gameState.battleSync != null) 
				{
					if (gameState.battleSync.mVal == 1) {
						System.out.println("NPC turn");
						/* NPC turn */
						npc.culture.execute("elitistQuiq", npc, gameState.getCurrentPlayer());

						if (npc.isDead() || gameState.getCurrentPlayer().isDead())
						{
							gameState.unlockLock();
							this.getLock = false;
							gameState.startExploration();
						}

						gameState.battleSync.mVal = 2;
					}
				}
			}

		}
	}

	
	private boolean atkProb() {
		int num = rand.nextInt(100);
		return (num >= 0 && num < ATK_PROB) ? true : false;  
	} 

	public void toggle() {
		this.isActivating = !this.isActivating;
	}
}
