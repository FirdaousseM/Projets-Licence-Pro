package miniRpg.mobs;

import miniRpg.Carte;

public class Monstre extends Personnage{
	private static int VIE = 5;
	private static int PUISSANCE = 10;
	private static int MONNAIE = 10;
	private static int XP = 10;
	
	public Monstre(Carte carte, int xPos, int yPos) {
		super(VIE, PUISSANCE, carte, xPos, yPos, MONNAIE);
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
