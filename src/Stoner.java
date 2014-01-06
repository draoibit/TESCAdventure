package TESCAdventure;

public class Stoner extends Subculture
{	
	public static final String[] SKILLS = 
	{
		"checkYourPrivledge", "uncontrolableGiggling","puffPuffPass", 
		"ifYoureACopYouGottaTellMe","medicalMarajuanaCard", "paranoia","munchies"
	};
	
	public String imagePath = "/Users/MalcolmRoss/Programs/eclipse/workspace/TESCAdventure/src/TESCAdventure/pics/stone.jpg";
	
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
