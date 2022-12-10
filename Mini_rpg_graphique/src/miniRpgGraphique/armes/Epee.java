package miniRpgGraphique.armes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Epee extends Arme{
	static int DEGAT = 10;
	static int PRIX = 5;

	public Epee() {
		super(DEGAT, PRIX, new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/epee.png")));
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
