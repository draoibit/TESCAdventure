package TESCAdventure;

public class Professor extends Subculture
{	
	public static final String[] SKILLS = 
	{
		"elitestQuip", "checkYourPrivledge","terriblePotluckFood", "kombuchaAssault",
		"preclassYoga", "inductiveProofs",  "narrativeEvaluation", "confusingCompilerError"
	};
	
	public String imagePath = "/Users/MalcolmRoss/Programs/eclipse/workspace/TESCAdventure/src/TESCAdventure/pics/prof.jpg";


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
