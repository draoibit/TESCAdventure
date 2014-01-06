package TESCAdventure;
import TESCAdventure.MainEngine.*;

public class Greener
{
//FIELDS
	protected String name;
	protected int age;
	protected Gender gender;
	protected SexualOrientation sexualOrientation;
	protected Ethnicity ethnicity;
	protected Subculture culture;
	protected Statistics stats;
	
//CONSTRUCTORS
	public Greener(  )
	{
		name = "Motoko Kusanagi";
		age = 35;
		gender = Gender.ROBOT;
		sexualOrientation = SexualOrientation.OTAKU;
		ethnicity = Ethnicity.ASIAN;
		culture = new Hipster();
		stats = new Statistics();
	}
	public Greener( String n, int a)
	{
		this();
		name = n;
		age = a;
	}
	

//GETTERS
    public String toString() 
    {
        return this.getName() + " -> HEALTH: " + this.getStats().getHealth() + " HYGENE: " + this.getStats().getHygene() + " WEALTH: "   
        	 + this.getStats().getWealth() + " PRIVILEGE: " + this.getStats().getPrivilege() + " CRED: " + this.getStats().getCred() + " QUIRK: "
        	 + this.getStats().getQuirk() + " INDIGNATION: " + this.getStats().getIndignation();
    }                                 
	public String getName()
	{ return name; }
	public int getAge()
	{ return age;}
	public Gender getGender()
	{ return gender; }
	public SexualOrientation getSexualOrientation()
	{ return sexualOrientation; }
	public Ethnicity getEthnicity()
	{ return ethnicity; }
	public Subculture getCulture()
	{ return culture; }
	public Statistics getStats()
	{ return stats; }
//SETTERS
	public void setName(String name)
	{ this.name = name;	}
	public void setAge(int age)
	{ this.age = age; }
	public void setGender(Gender gender)
	{ this.gender = gender; }
	public void setSexualOrientation(SexualOrientation sexualOrientation)
	{ this.sexualOrientation = sexualOrientation; }
	public void setEthnicity(Ethnicity ethnicity)
	{ this.ethnicity = ethnicity; }
	public void setCulture(Subculture culture)
	{ this.culture = culture; }
	public void setStats(Statistics stats)
	{ this.stats = stats;}
	public boolean isDead( )
	{
		if( this.getStats().getHealth() > 0 )
			return false;
		else
			return true;
	}
}
