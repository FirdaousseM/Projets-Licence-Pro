package miniRpgGraphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import miniRpgGraphique.armes.Arme;
import miniRpgGraphique.mobs.Destructible;
import miniRpgGraphique.mobs.Joueur;
import miniRpgGraphique.mobs.Monstre;
import miniRpgGraphique.vue.Fenetre;

public class Carte {
	
	public static final int TAILLE = 4;
	
	private int[][] carteVirtuelle;
	private JPanel panelMap;
	private Fenetre fenetre;
	private ImageIcon tileImage;

	/* Guide des valeurs :
	 * Joueur = 1;
	 * Monstre = 2;
	 * Obstacle = 3; 
	 */
	
 	public Carte(Fenetre fenetre) {
		this.carteVirtuelle = initMatrice();

 		this.fenetre = fenetre;
 		this.panelMap = new JPanel();
 		
		tileImage = new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/bg_tiles.png");

		this.afficheMap();
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
	 * Affichage de la carte en console : 
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

	/*
	public void updateMatriceMap() {
		
		this.carteVirtuelle;
		JPanel[][] panelHolder = new JPanel[i][j];    
		setLayout(new GridLayout(i,j));

		for(int m = 0; m < i; m++) {
		   for(int n = 0; n < j; n++) {
		      panelHolder[m][n] = new JPanel();
		      add(panelHolder[m][n]);
		   }
		}
	}
	*/
	
	/***** VUE GRAPHIQUE *****/
	public void afficheMap() {
		Rectangle window = fenetre.window.getBounds();
		
		panelMap.setLayout(new GridLayout(TAILLE,TAILLE));
		panelMap.setBackground(Color.white);
		
		for(int i = 0 ; i < TAILLE*TAILLE ; i++) {
			tileImage.setImage(Fenetre.redimensionnement(tileImage.getImage(), window.width/5, window.height/6));
			panelMap.add(new JLabel(tileImage));
		}
		
		fenetre.mainPanel.add(panelMap, BorderLayout.CENTER);
		System.out.println(panelMap);
		
		
	}

}
