package miniRpgGraphique.armes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Arc extends Arme{
	static int DEGAT = 20;
	static int PRIX = 15;
	
	public Arc() {
		super(DEGAT, PRIX, new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/bow.png")));
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
