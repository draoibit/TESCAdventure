package TESCAdventure;

import TESCAdventure.MainEngine.*;

import java.awt.Button;
import java.lang.Thread;
import java.util.concurrent.locks.*;

public class GameState
{
//FIELDS
	private Greener currentPlayer;
	private Location currentLocation;
	private GameMode currentGameMode;
	private ReentrantLock lock;
	public ListNode<Integer> battleSync;
	public Greener nonplayerCharacter;
	
	public ThreadNPC[] threadNPCs;
	
	public GUIWindow GUI;
		
	//CONSTRUCTORS
	public GameState( )
	{
		lock = new ReentrantLock();
		
		currentPlayer = new Greener( );
		this.setCurrentLocation(Map.en);
		currentGameMode = GameMode.EXPLORATION;
		battleSync = null;
		
		GUI = new GUIWindow(this);
	}
	
	
	public GameState( Greener g, Location l)
	{
		this( );
		this.setCurrentPlayer( g );
		this.setCurrentLocation( l );
	}
	
	public Greener getCurrentPlayer()
	{ return currentPlayer; }
	public Location getCurrentLocation()
	{ return currentLocation; }
	public GameMode getCurrentGameMode()
	{ return this.currentGameMode; }
	public void setCurrentPlayer(Greener currentPlayer)
	{ this.currentPlayer = currentPlayer; }
	public void setCurrentLocation(Location currentLocation)
	{ 
		if (this.currentGameMode == GameMode.BATTLE)
			return;
		
		/* Clear Previous ThreadNPCs */
		if(threadNPCs != null)
			for (int i = 0; i < this.currentLocation.NPC.length; i++)
				threadNPCs[i].toggle();
		
		this.currentLocation = currentLocation; 
		this.threadNPCs = new ThreadNPC[this.currentLocation.NPC.length];
		
		/* Create ThreadNPCs */
		for (int i = 0; i < this.currentLocation.NPC.length; i++) {
			this.threadNPCs[i] = new ThreadNPC(this.currentLocation.NPC[i], this);
			this.threadNPCs[i].start();
		}
		
	}
	public void startBattle( Greener npc )
	{
		this.battleSync = new ListNode<Integer>(1);
		this.battleSync.mNext = new ListNode<Integer>(2);
		this.battleSync.mNext.mNext = this.battleSync;
		
		this.currentGameMode = GameMode.BATTLE;
		this.nonplayerCharacter = npc;
		
		/* Clear All InputPanel */
		this.GUI.IOSplitPane.remove(GUI.IOSplitPane.getLeftComponent());
		GUIWindow.JPanelBat panelBat = new GUIWindow.JPanelBat(this.getCurrentPlayer().culture.getSkills(), this, GUI);
		this.GUI.IOSplitPane.setLeftComponent(panelBat);
		this.GUI.IOSplitPane.updateUI();
		
		
		this.GUI.DisplaySplitPane.remove(GUI.DisplaySplitPane.getRightComponent());
		GUIWindow.JPanelImg panelNPC = new GUIWindow.JPanelImg(this.nonplayerCharacter.culture.getImgPath());
		this.GUI.DisplaySplitPane.setRightComponent(panelNPC);
		this.GUI.DisplaySplitPane.updateUI();
	}
	public void startExploration( )
	{
		this.currentGameMode = GameMode.EXPLORATION;
	}
	public boolean getLock()
	{ 
		return lock.tryLock();
	}
	public void unlockLock()
	{ 
		lock.unlock(); 
	}
}
