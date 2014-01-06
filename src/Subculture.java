package TESCAdventure;

import java.lang.reflect.Method;

public abstract class Subculture 
{
		public static final String[] SKILLS = null;
		public String imagePath;
	
		protected static Skills SkillObj = new Skills();
	
		abstract public String execute(String skill, Greener self, Greener op);
		
		abstract public String[] getSkills( );

		protected Method getSkill(String skill) 
		{
			try
			{
				return SkillObj.getClass().getMethod(skill, Greener.class, Greener.class);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
				return null;
			}
		}
		
		abstract String getImgPath();
}
