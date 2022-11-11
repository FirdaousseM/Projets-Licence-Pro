package miniRpg.armes;
public class Epee extends Arme{
	static int DEGAT = 10;
	static int PRIX = 5;

	public Epee() {
		super(DEGAT, PRIX);
	}

	@Override
	public String ascii_art() {
		return
		"\n 	/|________________ " +
		"\n  O|===| *________________>" +
	    "\n 	\\|                "; 
	}
	
	@Override
	public String details() {
		return "ÉPÉE :"
				+ "\nPrix : 10$"
				+ "\nDégat : 5\n";
		
	}

}
