package TESCAdventure;

public class Skills 
{

//MULTI-SUBCULTURE SKILLS
	
	//Does damage or heals depending on who is more privaleged
	public String elitistQuiq(Greener self, Greener op) 
	{
		int damage = self.getStats().getPrivilege() - op.getStats().getPrivilege(); 
		op.getStats().setHealth( op.getStats().getHealth() - damage );
		
		if( damage >= 0 )
		{ return "\n" + self.getName() + " used ELITIST QUIP and did " + damage + " damage.\n\n" + self.getName() + ": \"That coffee probably isn't even fair trade!\"";}
		else
		{ return "\n" + self.getName() + " used ELITIST QUIP and healed " + op.getName() + " " + damage + " points.\n\n" + op.getName() + ": \"I bet you've never even been to Europe before.\"";}
	}
	//Does damage to opponents equal to their privladge
	public String checkYourPrivledge(Greener self, Greener op)
	{
		int damage = ( op.getStats().getPrivilege() / 2 );
		
		if( op.getGender() == MainEngine.Gender.CISMALE )
			{ damage++; }
		if( op.getEthnicity() == MainEngine.Ethnicity.WHITE )
			{ damage++; }
		if( op.getSexualOrientation() == MainEngine.SexualOrientation.STRAIGHT )
			{ damage++; }
		
		op.getStats().setHealth( op.getStats().getHealth() - damage  );
		op.getStats().setCred( op.getStats().getCred() - 1 );
		
		return "\n" + self.getName() +  "used CHECK YOUR PRIVILEGE and did " + damage + " damage and 1 cred.\n\n" + self.getName() + ": \"You need to check your privladge bro.\"";
	}	
	//Heals three damage but lowers hygene
	public String puffPuffPass(Greener self, Greener op)
	{
		int heal =  3;
		self.getStats().setHealth( self.getStats().getHealth() + heal );
		self.getStats().setHygene( self.getStats().getHygene() - 1 );
		
		return "\n" + self.getName() + " used PUFF PUFF PASS and healed " + heal + " points, lowering their hygene 1 point.\n\n" + self.getName() + ": \"It's medicinal bro.\"";
	}
	//Does 3 damage
	public String kombuchaAssault(Greener self, Greener op)
	{
		op.getStats().setHealth( op.getStats().getHealth() - 3 );
		
		return "\n" + self.getName() + " used KOMBUCHA ASSAULT and did 3 damage.\n\n" + self.getName() + ": \"It's probiotic man.\"";
	}
	//Does damage/heals based on indignation
	public String terriblePotluckFood( Greener self, Greener op)
	{
		int damage = ( (self.getStats().getIndignation() - 15) / 2 );
		op.getStats().setHealth( op.getStats().getHealth() - damage );
		self.getStats().setHealth( self.getStats().getHealth() - (damage / 2) );
		
		return "\n" + self.getName() + " used TERRIBLE POTLUCK FOOD and did " + damage + " damage and healed " + (damage / 2) + " points.\n\n" + self.getName() + ": \"Everyone loves my vegan, gluten-free, soy-free, nut-free, quinoa scramble.\"";
	}

//HIPSTER SKILLS
	
	//Does 3 damage with a bonus for cred
	public String playLanaDelRey(Greener self, Greener op)
	{
		int bonus = 0;
		if( self.getStats().getCred() > 15 )
			bonus += self.getStats().getCred() - 15;
		
		op.getStats().setHealth( op.getStats().getHealth() - (4 + bonus) );
		
		return "\n" + self.getName() + " used PLAY LANA DEL REY and did " + (4 + bonus) + " damage.\n\n" + self.getName() + ": \"It's not suppose to sound good. Man are you mainstream.\"";
	}
	//Raises your cred and health based on your wealth and cred 
	public String ironicSweater(Greener self, Greener op)
	{
		int smug = ( op.getStats().getWealth() / 10 );
		self.getStats().setCred( self.getStats().getCred() + smug );
		self.getStats().setWealth( self.getStats().getWealth() - smug );
		
		return "\n" + self.getName() + " used IRONIC SWEATER, raised cred and lost wealth by " + smug + " points.\n\n" + self.getName() + ": \"They're not reindeer, they're carribou.\"";
	}
	//Raises your health and lowers oponents cred based on your cred
	public String experimentalIndieTibetanDubstep(Greener self, Greener op)
	{
		int smug = ( op.getStats().getCred() / 2 );
		op.getStats().setCred( self.getStats().getCred() - smug );
		self.getStats().setHealth( self.getStats().getHealth() + smug );
		
		return "\n" + self.getName() + " used EXPERIMENTAL INDIE TIBETAN DUBSTEP, raised cred and lowered" + op.getName() + "'s cred " + smug + " points.\n\n" + self.getName() + ": \"They're older albums were better, before they sold out.\"";
	}
	//Lowers opponents wealth and increases your cred
	public String freerangeGrassfedSmallbatchCraftobrewedFroisgrasAndTruffleMead(Greener self, Greener op)
	{
		int smug = ( op.getStats().getCred() / 2 );
		op.getStats().setWealth( self.getStats().getWealth() - smug );
		self.getStats().setCred( self.getStats().getCred() + smug );
		
		return "\n" + self.getName() + " used FREE-RANGE, GRASS-FED, SMALL-BATCH, CRAFT-BREWED FROIS GRAS AND TRUFFLE MEAD, gained " + smug + " cred and " + op.getName() + " lost " + smug + " wealth.\n\n" + self.getName() + ": \"I only eat at experimental gastopubs.\"";
	}
	//Does nine damage to your opponent and three to you
	public String anAttackYouProbablyHaventEverHeardOf(Greener self, Greener op)
	{
		if( op.getStats().getCred() > 17 )
		{
			int smug = ( op.getStats().getCred() - 15 * 3 );
			op.getStats().setHealth( self.getStats().getHealth() - smug );
			self.getStats().setCred( self.getStats().getCred() - (smug / 6) );
		
			return "\n" + self.getName() + " used AN ATTACK YOU PROBABLY HAVEN'T EVEN HEARD OF and did " + (smug * 3) + " damage to " + op.getName() + " and lost " + (smug / 6)+ " cred.\n\n" + self.getName() + ": \"It's pretty obscure; you've probably never heard of it.\"";
		}
		else
		{
			self.getStats().setCred( self.getStats().getCred() - 5 );
			return "\n" + self.getName() + " isn't cool enough for AN ATTACK YOU PROBABLY HAVEN'T EVEN HEARD OF and lost " + 5 + " cred.\n\n" + op.getName() + ": \"Poser.\"";
		}
	}

//VEGAN SKILLS
	
	//Does damage/increases indignation based on indignation
	public String meatIsMurder(Greener self, Greener op)
	{
		if( op.getCulture() == self.getCulture() )
		{
			return "MEAT IS MURDER failed.\n\n" + op.getName() + ": \"I'm a level 5 vegan; I don't eat anything that casts a shadow. Punk.\"";
		}
		else
		{
			int damage = ( (self.getStats().getIndignation() - 15) / 2 );
			op.getStats().setHealth( op.getStats().getHealth() - damage );
			self.getStats().setIndignation( self.getStats().getIndignation() - (damage / 2) );

			return "\n" + self.getName() + " used MEAT IS MURDER and did " + damage + " damage.\n\n" + self.getName() + ": \"There's a genocide going on, and it is an genocide!\"";
		}
	}
	//Raises your indignation and health based on your opponents indignation 
	public String selfRighetousness(Greener self, Greener op)
	{
		int smug = ( (op.getStats().getIndignation() - 10) / 2);
		self.getStats().setIndignation( self.getStats().getIndignation() + smug );
		self.getStats().setHealth( self.getStats().getHealth() + smug );
		
		return "\n" + self.getName() + " used SELF-RIGHETOUSNESS, raised indignation and healed " + smug + " points.\n\n" + self.getName() + ": \"You can't be a moral person if you eat meat.\"";
	}
	//Does ten damage to opponent and two to self
	public String veganPsychicBlast(Greener self, Greener op)
	{
		op.getStats().setHealth( op.getStats().getHealth() - 10 );
		self.getStats().setHealth( self.getStats().getHealth() - 2 );
		
		return "\n" + self.getName() + " used VEGAN PSYCHIC BLAST and did 7 damage to " + op.getName() + " and 2 to self.\n\n" + self.getName() + ": \"It's a scientific fact: vegans are just better than other people.\"";
	}

//TRUSTAFARIAN SKILLS
	
	//Lowers your wealth by one to increase your privilege and health by one
	public String mommyDaddysCreditCard(Greener self, Greener op)
	{
		if( self.getStats().getWealth() > 0 )
		{
			self.getStats().setWealth( self.getStats().getWealth() - 1 );
			self.getStats().setPrivilege( self.getStats().getPrivilege() + 1 );
			self.getStats().setHealth( self.getStats().getHealth() + 1 );
			return "\n" + self.getName() + " used MOMMY AND DADDY'S CREDIT CARD, healed, incread privilege and lowered their wealth by 1 point.\n\n" + self.getName() + ": \"They made me promise I wouldn't buy atrisanal olive oil or henna.\"";
		}
		else
			return "\nMOMMY AND DADDY'S CREDIT CARD was declined: mommy and daddy cut you off.\n\n" + self.getName() + ": \"My parents are the worst!!!\""; 
	}
	//Lowers an opponents wealth to increase your wealth while you lose cred
	public String busking(Greener self, Greener op)
	{
		if( op.getStats().getWealth() != 0 && self.getStats().getCred() > 5 )
		{
			int scratch = ( op.getStats().getWealth() / self.getStats().getCred() );
			self.getStats().setCred( self.getStats().getCred() - 1 );
			op.getStats().setWealth( op.getStats().getWealth() - scratch );
			op.getStats().setWealth( op.getStats().getWealth() - scratch );
			self.getStats().setHygene( self.getStats().getHygene() -1 );
	
			return "\n" + self.getName() + " used BUSKING, raised your wealth and lowered " + op.getName() + "'s wealth by " + scratch + " points and lost 1 cred.\n\n" + self.getName() + ": \"Dime bag for a song?\"";
		}
		else
		{
			self.getStats().setCred( self.getStats().getCred() - 1 );
			self.getStats().setHygene( self.getStats().getHygene() -1 );
			return "\nBUSKING failed, " + self.getName() + " sucks at the guitar.\n\n" + self.getName() + ": \"It's hard out there for a non-conformist.\"";
		}
	}
	//Basic 5 damage attack
	public String longBoardCollision(Greener self, Greener op)
	{
		op.getStats().setHealth( op.getStats().getHealth() - 5 );
		
		return "\n" + self.getName() + " used LONGBOARD COLLISION and did " + 5 + " damage.\n\n" + self.getName() + ": \"Skateboarding isn't a crime, man.\"";

	}
	//Does damage equal to half of 10 minus the Greeners hygene 
	public String bodyOdor(Greener self, Greener op)
	{
		int damage = ( ( 10 - self.getStats().getHygene() ) );
		op.getStats().setHealth( op.getStats().getHealth() - damage );
		
		return "\n" + self.getName() + " used BODY ODOR and did " + damage + " damage.\n\n" + self.getName() + ": \"Garlic is antibacterial dude.\"";
	}
	
//STONER SKILLS
	
	//Does 3 damage to opponents wealth and you gain that much wealth
	public String ifYoureACopYouGottaTellMe(Greener self, Greener op)
	{
		op.getStats().setWealth( op.getStats().getWealth() - 3 );
		self.getStats().setWealth( self.getStats().getWealth() +3 );
		
		return "\n" + self.getName() + " used IF YOU'RE A COP YOU GOTTA TELL ME and did " + 3 + " damage to " + op.getName() + "'s wealth and gained 3 wealth.\n\n" + self.getName() + ": \"Otherwise it's entrapment.\"";
	}
	//Does 3 damage to opponents cred
	public String paranoia(Greener self, Greener op)
		{
			op.getStats().setCred( op.getStats().getCred() - 3 );
			
			return "\n" + self.getName() + " used PARANOIA and did " + 3 + " damage to " + op.getName() + "'s cred.\n\n" + self.getName() + ": \"You sure you're not a cop?\"";
		}
	//Heals four damage
	public String medicalMarajuanaCard(Greener self, Greener op)
	{
		if( self.getStats().getWealth() > 0 )
		{
			int heal = 4;
			self.getStats().setHealth( self.getStats().getHealth() + heal );
		
			return "\n" + self.getName() + " used MEDICAL MARAJUANA CARD and healed " + heal + " damage.\n\n" + self.getName() + ": \"It's medicinal dude.\"";
		}
		else
		{
			return "\nMEDICAL MARAJUANA CARD failed; " + self.getName() + " is broke.\n\n" + self.getName() + ": \"I'm broke bro.\"";
		}
	}
	//Heals ten damage but lose three wealth
	public String munchies(Greener self, Greener op)
		{
		if( self.getStats().getWealth() > 0 )
		{
			self.getStats().setWealth( self.getStats().getWealth() - 3 );
			self.getStats().setHealth( self.getStats().getHealth() + 10 );
			return "\n" + self.getName() + " used MUNCHIES and healed " + 10 + " damage and lowered their wealth " + 3 + "point.\n\n" + self.getName() + ": \"This pizza is so good. I think it is my spirit animal.\"";
		}
		else
			return "\n" + self.getName() + "'s MUNCHIES shall go unsated, they already spent all their money on dorritos and gummy bears.\n\n" + self.getName() + ": \"That's harsh bro.\""; 
		}
	//Does nine damage to your opponent and three to you
	public String uncontrolableGiggling(Greener self, Greener op)
	{
		op.getStats().setHealth( op.getStats().getHealth() - 9 );
		self.getStats().setHealth( self.getStats().getHealth() - 3 );
		
		return "\n" + self.getName() + " used UNCONTROLABLE GIGGLING and did 9  damage to " + op.getName() + " and 3 to themselves.\n\n" + self.getName() + ": \" ROFL!\"";
	}

//PROFESSOR SKILLS
	
	//Heals three damage
	public String preclassYoga(Greener self, Greener op)
	{
		int heal =  3;
		self.getStats().setHealth( self.getStats().getHealth() + heal );
		
		return "\n" + self.getName() + " used PRECLASS YOGA and healed " + heal + " damage.\n\n" + self.getName() + ": \"Remember to breathe.\"";
	}
	//Does nine damage to your opponent and three to you
	public String inductiveProofs(Greener self, Greener op)
	{
		op.getStats().setHealth( op.getStats().getHealth() - 10 );
		self.getStats().setHealth( self.getStats().getHealth() - 3 );
		
		return "\n" + self.getName() + " used INDUCTIVE PROOFS and did  9 damage to " + op.getName() + " and 3 to themself.\n\n" + self.getName() + ": \"It's not that hard!\"";
	}
	//Lowers all stats a little
	public String confusingCompilerError( Greener self, Greener op )
	{
		int frustration = 3;
		op.getStats().setWealth( op.getStats().getWealth() - frustration );
		op.getStats().setCred( op.getStats().getCred() - frustration );
		op.getStats().setIndignation( op.getStats().getIndignation() + frustration );
		op.getStats().setHygene( op.getStats().getHygene() - frustration );
		op.getStats().setQuirk( op.getStats().getQuirk() + frustration );
		op.getStats().setHealth( op.getStats().getHealth() - frustration );
		
		return "\nGame.java:3: error: 'selfLoathing' expected\nGame.java:15: error: 'Why so serious?'\nGame.java:42: error: 'MissingDeclaration: lifeTheUniverseAndEverything' \nGame.java:102: error: 'inTheGardenOfEdenHoneyDontYouKnowThatILoveYou' expected\n";
	}
	//Does damage or heals depending on who is more privaleged
	public String narrativeEvaluation(Greener self, Greener op) 
	{
		int damage = self.getStats().getQuirk() - op.getStats().getCred(); 
		op.getStats().setHealth( op.getStats().getHealth() - damage );
		
		if( damage >= 0 )
		{ return "\n" + self.getName() + " used NARRATIVE EVALUATION and did " + damage + " damage.\n\n" + self.getName() + ": \"You tried really hard but you didn't seem to engage well with your cohort!\"";}
		else
		{ return "\n" + self.getName() + " used NARRATIVE EVALUATION and healed " + op.getName() + " " + damage + " damage.\n\n" + op.getName() + ": \"You grew alot in our Underwater Basket Weaving class.\"";}
	}
}
