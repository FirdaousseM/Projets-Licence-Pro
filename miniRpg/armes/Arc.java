package miniRpg.armes;
public class Arc extends Arme{
	static int DEGAT = 20;
	static int PRIX = 15;
	
	public Arc() {
		super(DEGAT, PRIX);
	}

	@Override
	public String ascii_art() {
		return  "\n	   (		" +
				"\n	    \\		" +
				"\n	     )		" +
				"\n	##--------> " +
				"\n	     )		" +
				"\n	    /		" +
				"\n	   (		";
	}
	
	@Override
	public String details() {
		return "ARC :"
				+ "\nPrix : 15$"
				+ "\nDégat : 10\n";
		
	}

}
