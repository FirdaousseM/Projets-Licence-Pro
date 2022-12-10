package miniRpgGraphique;


import miniRpgGraphique.armes.Magasin;
import miniRpgGraphique.mobs.Joueur;
import miniRpgGraphique.vue.Fenetre;

public class Lancement {
	public static void main(String[] args) {
		
		Fenetre fenetre = new Fenetre();


		Magasin magasin = new Magasin(fenetre);
		
		Carte carte = new Carte(fenetre);
		Spawner spawner = new Spawner(carte, fenetre);
		
		int xPos = 0;
		int yPos = Carte.TAILLE-1;
		
		Joueur joueur = new Joueur("Jonathan", carte, xPos, yPos, fenetre);
		
		GestionnaireChoix gestion = new GestionnaireChoix(magasin, joueur, spawner);
		/*
		// TOUR DE JEU
		do {
			carte.affichageCarte();
			gestion.choixPrincipal();
		}
		while (!joueur.win() && !joueur.lose());
		
*/
		
		fenetre.window.setVisible(true);
		
	}
}
