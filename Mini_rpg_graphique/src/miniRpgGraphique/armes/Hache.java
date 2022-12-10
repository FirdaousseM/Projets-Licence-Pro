package miniRpgGraphique.armes;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Hache extends Arme{
	static int DEGAT = 30;
	static int PRIX = 10;
	
	public Hache() {
		super(DEGAT, PRIX, new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/hache.png")));
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
