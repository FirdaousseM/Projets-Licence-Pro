package miniRpg.mobs;

import miniRpg.Carte;

public abstract class Destructible {
	private int vie;
	protected int xPos, yPos;
	private Carte carte;
	private int monnaie;
	
	public Destructible(int vie, Carte carte, int x, int y, int monnaie) {
		this.vie = vie;
		this.carte = carte;
		this.xPos = x;
		this.yPos = y;
		this.monnaie = monnaie;

		//Placement début du jeu
		if (!this.horsLimite())
			this.carte.deplacement(this, xPos, yPos, xPos, yPos);
		else
			System.out.println("hors limite");
	}

	public void subitDegat(int degat) {
		this.vie -= degat;
	}
	
	public int[] deplacement(String direction) {
		
		int[] coordonnees = new int[2];
		switch(direction) {
		// HAUT
		case "1" : 
			this.carte.deplacement(this, xPos, yPos, xPos, yPos-1);
			this.yPos--;
		break;
		// DROITE
		case "2" : 
			this.carte.deplacement(this, xPos, yPos, xPos+1, yPos);
			this.xPos++;
		break;
		// BAS
		case "3" : 
			this.carte.deplacement(this, xPos, yPos, xPos, yPos+1);
			this.yPos++;
		break;
		// GAUCHE
		case "4" : 
			this.carte.deplacement(this, xPos, yPos, xPos-1, yPos);
			this.xPos--;
		break;
		}
		coordonnees[0] = xPos;
		coordonnees[1] = yPos;
		return coordonnees;
	}
	
	/*
	 * Si le Destructible n'est pas sur :
	 * - la position de départ du joueur
	 * - la position de l'objectif du jeu
	 * - Aucun Destructible n'est déjà présent sur la case
	 */
	public boolean horsLimite() {
		
		return (this.xPos == 0 && this.yPos == Carte.TAILLE-1);
		/*
		if ((this.xPos == 0 && this.yPos == Carte.TAILLE-1) ||
			(this.xPos == Carte.TAILLE-1 && this.yPos == 0) ||
			(this.carte.collision(this.xPos, this.yPos))) {
			return true;
		}
		return false;
		*/

	}
	
	public void seePosition() {
		System.out.println("\nxPos : " + xPos + "\nyPos :" + yPos + "\n");
	}
	
	public boolean estMort() {
		return this.vie <= 0;
	}

	// mort face au joueur
	public boolean estMort(Joueur j) {
		if (this.estMort()) {
			System.out.println("test");
			j.gagneMonnaie(monnaie);
			return true;
		}
		return false;
	}
	
	public boolean checkPosition(int x, int y) {
		return this.xPos == x && yPos == y;
	}


}
