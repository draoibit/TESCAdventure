package TESCAdventure;

import java.util.Random;

import TESCAdventure.MainEngine.*;

public class NPC extends Greener
{
	private static Random rand = new Random();
	
	public NPC() 
	{
		super();
		
		this.name = generateName() + " " + generateName();
		this.age = generateAge();
		this.gender = generateGender();
		this.sexualOrientation = generateSexualOrientation();
		this.culture = generateSubculture();
	}
	
	
	private String generateName() 
	{
		final String[] NAMES = {"Gregie", "Zephyr", "Kalex", "Sunshine", "Momoka", "Alder", "Sage", 
								"FM-2030", "Trogdor", "Pan", "Starbeam", "Rainbow", "Moon", "Ocean", 
								"Star", "Xochimilco", "Bender", "Lady Gaga", "Cher", "Ford", "Bulbasaur", 
								"Cloud", "Bread", "Monsoon", "Globe", "Shoe", "Mitt", "Dimentia", "Cupcake",
								"Tyranasaurus", "Frois-Gras", "Fromage", "Jetpack-Dinosaur", "Explosion",
								"Breltner", "Broseph", "Marie-Antoinette", "Sparkle-Magick", "Pope Pius II"};
		int x = rand.nextInt(NAMES.length);
		return NAMES[x];
	}
	
	
	private int generateAge() 
	{
		return rand.nextInt(70);
	}
	
	private Gender generateGender() 
	{
		Gender[] gen = Gender.values();
		
		return gen[rand.nextInt(gen.length)];
	}
	
	private SexualOrientation generateSexualOrientation() 
	{
		SexualOrientation[] ori = SexualOrientation.values();
		
		return ori[rand.nextInt(ori.length)];
	}
	
	private Ethnicity generateEthinicity() 
	{
		Ethnicity[] eth = Ethnicity.values();
		
		return eth[rand.nextInt(eth.length)];
	}
	
	private Subculture generateSubculture() 
	{
		int num = rand.nextInt(5);
		
		switch(num) {
			case 0:
				return new Hipster();
			case 1:
				return new Professor();
			case 2:
				return new Stoner();
			case 3:
				return new Trustafarian();
			case 4:
				return new Vegan();
		}
		
		return null;
	}
}
