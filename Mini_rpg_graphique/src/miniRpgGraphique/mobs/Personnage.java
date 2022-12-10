package miniRpgGraphique.mobs;

import miniRpgGraphique.Carte;
import miniRpgGraphique.vue.Fenetre;

public class Personnage extends Destructible{

	protected int puissance;
	
	public Personnage(int vie, int puissance, Carte carte, int xPos, int yPos, int monnaie, Fenetre fenetre) {
		super(vie, carte, xPos, yPos, monnaie, fenetre);
		this.puissance = puissance;
		
	}
	
}
