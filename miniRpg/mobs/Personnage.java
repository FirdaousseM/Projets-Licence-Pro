package miniRpg.mobs;

import miniRpg.Carte;

public class Personnage extends Destructible{

	protected int puissance;
	
	public Personnage(int vie, int puissance, Carte carte, int xPos, int yPos, int monnaie) {
		super(vie, carte, xPos, yPos, monnaie);
		this.puissance = puissance;
		
	}
	
}
