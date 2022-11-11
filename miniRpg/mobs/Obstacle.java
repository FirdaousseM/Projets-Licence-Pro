package miniRpg.mobs;

import miniRpg.Carte;

public class Obstacle extends Destructible{
	private static int VIE = 5;
	private static int MONNAIE_CONTENUE = 10;
	
	public Obstacle(Carte carte, int xPos, int yPos) {
		super(VIE, carte, xPos, yPos, MONNAIE_CONTENUE);
	}
	
}
