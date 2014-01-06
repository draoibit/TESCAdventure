package TESCAdventure;

public class Trustafarian extends Subculture
{	
	public static final String[] SKILLS = 
	{
		"elitestQuip", "checkYourPrivledge","mommyAndDaddysCreditCard", 
		"puffPuffPass", "busking", "longBoardCollision", "bodyOdor"
	};
	
	public String imagePath = "/Users/MalcolmRoss/Programs/eclipse/workspace/TESCAdventure/src/TESCAdventure/pics/trust.jpg";

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
