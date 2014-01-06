package TESCAdventure;

import java.util.Random;


public class Location
{
	NPC[] NPC;
	ThreadNPC[] threadNPCs;
	
	String name;
	String imagePath;
	
	public Location(String s, String path)
	{
		name = s;
		imagePath = MainEngine.IMAGE_PATH + path;
		NPC = Generate();
	}
	
	public NPC[] Generate() 
	{
		Random rand = new Random();
		
	    int randomNum = rand.nextInt(10);
	    NPC[] retNPC = new NPC[randomNum];
	    
	    for(int i = 0; i < randomNum; i++)
	    {
	    	retNPC[i] = new NPC();
	    }
	    return retNPC;
	}
	
	
}
