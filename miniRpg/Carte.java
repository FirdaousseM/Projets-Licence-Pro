package miniRpg;

import miniRpg.mobs.Destructible;
import miniRpg.mobs.Joueur;
import miniRpg.mobs.Monstre;
import miniRpg.mobs.Personnage;

public class Carte {
	
	public static final int TAILLE = 4;
	
	private int[][] carteVirtuelle;

	/* Guide des valeurs :
	 * Joueur = 1;
	 * Monstre = 2;
	 * Obstacle = 3; 
	 */
	
 	public Carte() {
		this.carteVirtuelle = initMatrice();
	}
 	
	/*************************************/
	/*************** Matrice *************/
	/*************************************/
 	
 	/*
 	 * Initialise la matrice 2D qui va nous servir de carte avec des cases vide et l'objectif 
 	 */
	private int[][] initMatrice(){
		this.carteVirtuelle = new int [TAILLE][TAILLE];
		for (int i = 0 ; i < this.carteVirtuelle.length ; i++) {
			for (int j = 0 ; j < this.carteVirtuelle[i].length ; j++) {

					carteVirtuelle[i][j] = 0;
			}
		}
		carteVirtuelle[0][TAILLE-1] = -1;
		return carteVirtuelle;
	}

	/*
	 * Déplace la valeur du Destructible en question sur la matrice 2D
	 */
	public void deplacement(Destructible destructible, int oldX, int oldY, int newX, int newY) {
		
		this.carteVirtuelle[oldY][oldX] = 0;
		if (destructible instanceof Joueur) {		
			this.carteVirtuelle[newY][newX] = 1;
		} else if(destructible instanceof Monstre){
			this.carteVirtuelle[newY][newX] = 2;
		} else {
			this.carteVirtuelle[newY][newX] = 3;
		}
	}
	
	/*
	 * Renvoie true si un Monstre ou Obstacle se trouve sur la case vérifiée
	 */
	public boolean collision(int newX, int newY) {
		return this.carteVirtuelle[newY][newX] > 1;
	}
	
	/*
	 * Affichage de la carte : 
	 * selon valeur des destructible
	 * voir guide des valeurs en haut de la classe
	 * */
	public void affichageCarte() {
		System.out.println();
		for(int x = 0 ; x < TAILLE ; x++) {
			System.out.print("----");
		}
		System.out.println();
		for (int i = 0 ; i < TAILLE ; i++) {
			for (int j = 0 ; j < TAILLE ; j++) {

				switch(this.carteVirtuelle[i][j]) {
				case -1 : System.out.print(" * |");
				break;
				case 0 : System.out.print("   |");
				break;
				case 1 : System.out.print(" J |");
				break;
				case 2 : System.out.print(" M |");
				break;
				case 3 : System.out.print(" O |");
				break;
				}
			}
			System.out.println();
			for(int x = 0 ; x < carteVirtuelle.length ; x++) {
				System.out.print("----");
			}
			System.out.println("");
		}
		System.out.println();
	}



}
