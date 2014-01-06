package TESCAdventure;


public class Statistics {
	
	private int privilege;
	private int wealth;
	private int hygene;
	private int health;
	private int cred;
	private int indignation;
	private int quirk;

	public Statistics( ) 
	{
		this.privilege = 100;
		this.wealth = 100;
		this.hygene = 100;
		this.health = 100;
		this.cred = 100;
		this.indignation = 0;
		this.quirk = 0;
	}
	
	public Statistics(int privilege, int wealth, int hygene, 
					  int health, int cred, int indignation, 
					  int quirk) 
	{
		this.privilege = privilege;
		this.wealth = wealth;
		this.hygene = hygene;
		this.health = health;
		this.cred = cred;
		this.indignation = indignation;
		this.quirk = quirk;
	}


	public int getPrivilege()
		{ return privilege; }
	public int getWealth()
		{ return wealth; }
	public int getHygene()
		{ return hygene; }
	public int getHealth()
		{ return health; }
	public int getCred()
		{ return cred; }
	public int getIndignation()
		{ return indignation; }
	public int getQuirk()
		{ return quirk; }

	public void setPrivilege(int privilege)
		{ this.privilege = privilege; }
	public void setWealth(int wealth)
		{ this.wealth = wealth; }
	public void setHygene(int hygene)
		{ this.hygene = hygene; }
	public void setHealth(int health)
		{ this.health = health; }
	public void setCred(int cred)
		{ this.cred = cred; }
	public void setIndignation(int indignation)
		{ this.indignation = indignation; }
	public void setQuirk(int quirk)
		{ this.quirk = quirk; }
}
