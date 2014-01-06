package TESCAdventure;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;

import TESCAdventure.MainEngine.GameMode;

public class GUIWindow extends JFrame {
	public static GameState gameState;
	
	
	/* Panels */
	JPanel InputSubPane;
	JPanelText OutputSubPane;
	JPanel NPCGridSubPane;
	JPanelImg PlayerSubPane;
	
	
	/* Split Panels */
	JSplitPane DisplaySplitPane;
	JSplitPane IOSplitPane;
	

	public GUIWindow(GameState gameState) {			
		InputSubPane = new JPanelNav(Map.map.get(gameState.getCurrentLocation()), gameState, this);
		OutputSubPane = new JPanelText(gameState.getCurrentPlayer().toString() 
				+ "\n--------------------------------------------------------");
		NPCGridSubPane = new JPanelGrid(gameState.getCurrentLocation().NPC);
		PlayerSubPane = new JPanelImg(gameState.getCurrentLocation().imagePath);
		
		// Create Top DisplayPane w/ splits
		DisplaySplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				PlayerSubPane, NPCGridSubPane); 
		
		DisplaySplitPane.setDividerLocation(512);
		this.setContentPane(DisplaySplitPane);
		
				
		// Create Bottom IOPane w/ splits
		IOSplitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, 
				InputSubPane, OutputSubPane);	
		
		IOSplitPane.setDividerLocation(512);
		this.setContentPane(IOSplitPane);
		
		// Create main frame that contains IO and display panes
		JSplitPane MainSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
	            DisplaySplitPane, IOSplitPane);
		
		MainSplitPane.setDividerLocation(512);
		
		this.setContentPane(MainSplitPane);
		this.setSize(1024, 1024);
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void adjust() {
		if(gameState.getCurrentGameMode() == MainEngine.GameMode.EXPLORATION) {
			Location loc = gameState.getCurrentLocation();
			
			this.InputSubPane = new JPanelNav(Map.map.get(loc), gameState, this);
			this.NPCGridSubPane = new JPanelGrid(loc.NPC);
		} else {
			Greener npc = gameState.nonplayerCharacter;
			
			this.InputSubPane = new JPanelBat(gameState.getCurrentPlayer().culture.SKILLS, gameState, this);
			this.NPCGridSubPane = new JPanelImg(npc.culture.imagePath);
		
			this.IOSplitPane.removeAll();
			this.IOSplitPane.updateUI();
		}
	}
	

	public static void main(String[] args) {
		gameState = new GameState(new Greener(), Map.en);
	}
	
	/* JPanel with Image */
	public static class JPanelImg extends JPanel {
		BufferedImage image;
		
		public JPanelImg(String path) {
			super();
			
			try {
				image = ImageIO.read(new FileInputStream(new File(path)));
				
				JLabel picLabel = new JLabel(new ImageIcon(image));
				picLabel.setSize(this.getWidth(), this.getHeight());
				
				this.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
		
		public void update(String path) {
			this.removeAll();
			
			try {
				image = ImageIO.read(new FileInputStream(new File(path)));
				
				JLabel picLabel = new JLabel(new ImageIcon(image));
				picLabel.setSize(this.getWidth(), this.getHeight());
				
				this.add(picLabel);
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			this.updateUI();
		}
	}
	
	// JPanel Navigation 
	public static class JPanelNav extends JPanel {
		private LinkedList<Location> locs;
		public Button[] buttons;
		
		GameState gameState;
		GUIWindow gui;
		
		public  JPanelNav(LinkedList<Location> locs, GameState gameState, GUIWindow gui) {
			super();
			
			this.locs = locs;			
			this.gameState = gameState;
			this.gui = gui;
			
			this.setLayout(new GridLayout(locs.size(), 1));
			
			buttons = new ButtonNav[locs.size()];
			
			for (int i = 0; i < locs.size(); i++) {
				buttons[i] = new ButtonNav(locs.get(i).name, locs.get(i));
				buttons[i].addActionListener(new ClickListener(gameState, gui));
				this.add(buttons[i]);
			}
		}
		
		public void update(LinkedList<Location> locs) {
			this.locs = locs;			
				
			this.removeAll();
			
			buttons = new ButtonNav[locs.size()];
			
			for (int i = 0; i < locs.size(); i++) {
				buttons[i] = new ButtonNav(locs.get(i).name, locs.get(i));
				buttons[i].addActionListener(new ClickListener(gameState, gui));
				this.add(buttons[i]);
			}
			
			this.updateUI();
		}
		
		
		
		public static class ClickListener implements ActionListener {
			GameState gameState;
			GUIWindow gui;
			
			public ClickListener(GameState gameState, GUIWindow gui) {
				this.gameState = gameState;
				this.gui = gui;
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				GameMode mode = gameState.getCurrentGameMode();
				if (mode == MainEngine.GameMode.EXPLORATION) {
					gameState.setCurrentLocation(((ButtonNav) e.getSource()).loc);
					
					/* Update GUI */
					((JPanelNav) gui.InputSubPane).update(Map.map.get(gameState.getCurrentLocation()));
					((JPanelImg) gui.PlayerSubPane).update(gameState.getCurrentLocation().imagePath);
					((JPanelGrid) gui.NPCGridSubPane).update(gameState.getCurrentLocation().NPC);
				}
			}
		}
	}
	
	/* JPanel Battle */
	public static class JPanelBat extends JPanel {
		private String[] skills;
		public ButtonBat[] buttons;

		private GameState gameState;
		private GUIWindow gui;
		
		public JPanelBat(String[] skills, GameState gameState, GUIWindow gui) {
			super();
			
			this.skills = skills;
			this.gameState = gameState;
			this.gui = gui;
			this.setLayout(new GridLayout(skills.length, 1));
			
			buttons = new ButtonBat[skills.length];
			
			for(int i = 0; i<skills.length; i++) {
				buttons[i] = new ButtonBat(skills[i], skills[i]);
				buttons[i].addActionListener(new ClickListener(gameState, gui));
				this.add(buttons[i]);
			}
		}

		/* Listener Class */
		public static class ClickListener implements ActionListener {
			GameState gameState;
			GUIWindow gui;
			
			public ClickListener(GameState gameState, GUIWindow gui) {
				this.gameState = gameState;
				this.gui = gui;
			}
			
			
			@Override
			public void actionPerformed(ActionEvent e)
			{
				if (gameState.getCurrentGameMode() == MainEngine.GameMode.BATTLE) {
					if (gameState.battleSync.mVal == 2) {
						/* Player's Action */
						gameState.getCurrentPlayer().culture.execute(((ButtonBat) e.getSource()).skill, 
								gameState.getCurrentPlayer(), gameState.nonplayerCharacter);
	
						if (gameState.getCurrentPlayer().isDead() || gameState.nonplayerCharacter.isDead())
							gameState.startExploration();
						
						gameState.battleSync.mVal = 1;
						
						/* Update GUI */
					}
				}
			}
		}
	}
	
	public static class JPanelText extends JPanel {
		
		public JPanelText(String str) {
			this.setSize(new Dimension(512, 512));
			
			JTextArea output = new JTextArea(str );
			output.setLineWrap(true);
			output.setEditable(false);
			output.setSize(new Dimension(this.getWidth(), this.getHeight()));
			this.add(output);
			
		}
	}
	
	public static class JPanelGrid extends JPanel {
		public Button[] buttons;
		public boolean[] occupiedGrids = new boolean[25];
		public int x, y, flag;
		public int[] gridArr = new int[3];
		
		/*get random coords for npc grid */
		public int[] getRandCoords() {
			int[] gridPos = new int[3];
			
			gridPos[0] = (int) Math.random() * 5;
			gridPos[1] = (int) Math.random() * 5;
			// flag location
			gridPos[2] = ((gridPos[0]*5) + gridPos[1]);
			
			return gridPos;
		}
		
		// needs to take array of NPCS
		public JPanelGrid(NPC[] npcs) {
			super();
			buttons = new Button[npcs.length];			
			
			this.setSize(new Dimension(512, 512));
			this.setLayout(new GridLayout(5,5));
			
			for(int i = 0; i < npcs.length; i++) {
					gridArr = getRandCoords();
					while(occupiedGrids[flag] != true) {
						gridArr = getRandCoords();
						occupiedGrids[gridArr[2]] = true;
				}
				buttons[i] = new Button(npcs[i].getName());
				this.add(buttons[i]);
				
				occupiedGrids[flag] = true;
			}
		}
		
		public void update(NPC[] npcs) {
			this.removeAll();
			
			buttons = new Button[npcs.length];
			
			for(int i = 0; i < npcs.length; i++) {
				gridArr = getRandCoords();
				while(occupiedGrids[flag] != true) {
					gridArr = getRandCoords();
					occupiedGrids[gridArr[2]] = true;
				}
				buttons[i] = new Button(npcs[i].getName());
				this.add(buttons[i]);
				
				occupiedGrids[flag] = true;
			}
			
			this.updateUI();
		}
	}
	
	
	public static class ButtonBat extends Button {
		String skill;
		
		public ButtonBat(String text, String skill) {
			super(text);
			
			this.skill = skill;
		}
	}
	
	public static class ButtonNav extends Button {
		Location loc;
		
		public ButtonNav(String text, Location loc) {
			super(text);
			
			this.loc = loc;
		}
	}
}
