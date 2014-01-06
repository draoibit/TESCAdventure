package TESCAdventure;

public class Hipster extends Subculture
{	
	public final static String[] SKILLS = 
	{
		"elitestQuip", "checkYourPrivledge", "playLanaDelRey", "ironicSweater", "experimentalIndieTibetanDubstep",
		"freerangeGrassfedSmallbatchCraftobrewedFroisgrasAndTruffleMead", "anAttackYouProbablyHaventEverHeardOf" 
	};
	
	public String imagePath = "/Users/MalcolmRoss/Programs/eclipse/workspace/TESCAdventure/src/TESCAdventure/pics/hip.jpg";
	

	@Override
	public String execute(String skill, Greener self, Greener op)
	{
		try
		{
			return (String) this.getSkill(skill).invoke(SkillObj, self, op);
		}
		catch (Exception e) 
		{
			e.printStackTrace();
			return null;
		}
	}


	@Override
	public String[] getSkills()
	{
		return SKILLS;
	}


	@Override
	String getImgPath()
	{
		// TODO Auto-generated method stub
		return imagePath;
	}

}
