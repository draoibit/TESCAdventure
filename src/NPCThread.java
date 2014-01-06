package TESCAdventure;

import java.lang.Thread;
import java.util.Random;


public class ThreadNPC extends Thread {
	/* Controlling Constants */
	private static final int ATK_PROB = 40;
	private static final int SLEEP_TIME = 30000; 	// Seconds
	
	private static Random rand = new Random();

	private NPC npc;
	private GameState gameState;
	private boolean isActivating;
	
	public ThreadNPC (NPC npc, GameState game) {
		this.npc = npc;
		this.gameState = game;
		this.isActivating = true;
	}


	public void run() {
		ListNode<Integer> battleSync = null;

		while (isActivating) {
			if (gameState.getCurrentGameMode() == MainService.GameMode.EXPLORATION) {
				/* Attack Probability */
				if (atkProb()) {
					if(gameState.acquireLock()) {
						battleSync = gameState.startBattle();
					}
				} else {
					Thread.sleep(SLEEP_TIME);
				}

			} else {
				if(battleSync.mVal == 1) {
					/* NPC turn */
					npc.execute(skill, npc, gameState.getCurrentPlayer());

					if (npc.isDeath() || gameState.getCurrentPlayer().isDeath())
						gameState.startExploration();

					battleSync.mVal = 2;
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
