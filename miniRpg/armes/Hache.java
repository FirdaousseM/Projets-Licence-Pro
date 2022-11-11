package miniRpg.armes;
public class Hache extends Arme{
	static int DEGAT = 30;
	static int PRIX = 10;
	
	public Hache() {
		super(DEGAT, PRIX);
	}

	@Override
	public String ascii_art() {
		return 
				 "\n  _,-," +
				 "\n T_  |" +
				 "\n ||`-'" +
				 "\n ||   " +
				 "\n ||   " +
				 "\n ~~";
	}

	@Override
	public String details() {
		return "HACHE :"
				+ "\nPrix : 30$"
				+ "\nDégat : 25\n";
		
	}
}
