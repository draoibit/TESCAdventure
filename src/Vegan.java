package TESCAdventure;

public class Vegan extends Subculture
{	
	public String imagePath = "/Users/MalcolmRoss/Programs/eclipse/workspace/TESCAdventure/src/TESCAdventure/pics/trust.jpg";
	
	public static final String[] SKILLS = 
	{
		"elitistQuip", "checkYourPrivledge", "kombuchaAssault", "terriblePotluckFood", 
		"meatIsMurder", "selfRighetousness","veganPsychicBlast"
	};
	
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
