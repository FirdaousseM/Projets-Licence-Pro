package miniRpg;

import miniRpg.armes.Magasin;
import miniRpg.mobs.Joueur;

public class Lancement {
	public static void main(String[] args) {
		
		

		Magasin magasin = new Magasin();
		Carte carte = new Carte();
		Spawner spawner = new Spawner(carte);
		
		int xPos = 0;
		int yPos = Carte.TAILLE-1;
		
		Joueur joueur = new Joueur("Jonathan", carte, xPos, yPos);
		
		GestionnaireChoix gestion = new GestionnaireChoix(magasin, joueur, spawner);
		
		// TOUR DE JEU
		do {
			carte.affichageCarte();
			gestion.choixPrincipal();
		}
		while (!joueur.win() && !joueur.lose());
	
	}
}
