package miniRpgGraphique.mobs;

import miniRpgGraphique.Carte;
import miniRpgGraphique.vue.Fenetre;

public class Monstre extends Personnage{
	private static int VIE = 5;
	private static int PUISSANCE = 10;
	private static int MONNAIE = 10;
	private static int XP = 10;
	
	public Monstre(Carte carte, int xPos, int yPos, Fenetre fenetre) {
		super(VIE, PUISSANCE, carte, xPos, yPos, MONNAIE, fenetre);
	}
	
	/*
	 * Ajoute de l'expérience au Joueur.
	 */
	public boolean estMort(Joueur j) {
		if (super.estMort(j)) {
			j.gagneEXP(XP);
			return true;
		}
		return false;
	}
}
