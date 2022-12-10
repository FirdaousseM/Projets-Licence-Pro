package miniRpgGraphique.mobs;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

import miniRpgGraphique.Carte;
import miniRpgGraphique.armes.Arme;
import miniRpgGraphique.vue.Fenetre;

public class Joueur extends Personnage{

	private int monnaie, xp;
	private String nom;
	private String type;
	private ArrayList<Arme> inventaire;
	private Arme armeEnMain;
	private Destructible cible;
	private Fenetre fenetre;


	public Joueur(String nom, Carte carte, int xPos, int yPos, Fenetre fenetre) {
		super(40, 20, carte, xPos, yPos, 5, fenetre);
		this.nom = nom;

		this.inventaire = new ArrayList<Arme>();
		this.fenetre = fenetre;
	
	}

	/*************************************/
	/*************** COMBAT **************/
	/*************************************/

	/*
	 * Joueur inflige ses dégats à la cible, 
	 * et reçois des dégats de cette dernière si c'est un monstre.
	 */
	public void combat() {

		if (!this.estMort() && !cible.estMort(this)) {
			cible.subitDegat(this.puissance);

			if(cible instanceof Monstre) {
				this.subitDegat(((Monstre) cible).puissance);
				this.combat();
			}		
		}
		else if(cible.estMort(this)) {
			System.out.println("Cible éliminée.");	
		}
		System.out.println(cible.estMort(this));
	}

	/*
	 * Joueur fuit l'affrontement,
	 * et perds toute sa monnaie. 
	 */
	public void fuite() {
		System.out.println("Vous fuyez le combat, on vous dépouille de toute votre monnaie");
		System.out.println("-" + this.monnaie + "$");
		this.monnaie = 0;
	}

	/*
	 * Joueur fait d'un destructible qu'il rencontre sa cible,
	 * Cela lui permet d'agir sur cette cible.
	 */
	public void rencontre(Destructible mob) {
		this.cible = mob;		
	}


	/*************************************/
	/************* INVENTAIRE ************/
	/*************************************/

	/*
	 * Affiche chaque arme contenue dans l'inventaire.
	 */
	public void voirInventaire() {
		for(int i = 0 ; i < inventaire.size() ; i++) {
			if (this.inventaire.get(i).equals(armeEnMain)) {
				System.out.println("[Arme en main]");
			}

			System.out.println("Arme (" + (i+1) + ") :\n " + inventaire.get(i) + "\n");
		}	
	}

	/*
	 * Retourne la nombre d'arme dans l'inventaire.
	 */
	public int tailleInventaire() {
		return this.inventaire.size();
	}


	/*************************************/
	/**************** ARME ***************/
	/*************************************/

	/*
	 * Soustraie le prix de l'arme de la monnaie du Joueur.
	 * Ajoute l'arme dans l'inventaire.
	 */
	public void acheterArme(Arme arme) {
		this.monnaie -= arme.getPrix();
		this.inventaire.add(arme);
	}

	/*
	 * Ajoute le prix de l'arme à la monnaie du Joueur,
	 * Enlève l'arme de l'inventaire.
	 * Retourne l'arme en question.
	 */
	public Arme armeVendue(int numeroArme) {

		Arme armeVendue = this.inventaire.get(numeroArme-1);  

		this.monnaie += armeVendue.getPrix();
		this.inventaire.remove(armeVendue);

		return armeVendue;

	}

	/*
	 * Sélectionne l'arme dans l'inventaire à l'indice "numeroArme".
	 * Affecte la puissance de l'arme à la puissance du Joueur
	 */
	public void choixArme(int numeroArme) {
		this.armeEnMain = this.inventaire.get(numeroArme-1);
		this.puissance = this.armeEnMain.equipee(this.puissance);
	}

	/*************************************/
	/************** CHECKS ***************/
	/*************************************/

	/*
	 * Retourne vrai si la position du personnage est égale à celle de l'objectif.
	 */
	public boolean win() {
		if (this.xPos == Carte.TAILLE-1 && this.yPos == 0) {
			System.out.println("GAGNÉ");
			return true;
		}
		return false;
	}

	/*
	 * Retourne vrai si le personnage possède moins de 1 point de vie.
	 */
	public boolean lose() {
		if (this.estMort()) {
			System.out.println("PERDU, Votre personnage s'est fait éliminé.");
			return true;
		}
		return false;
	}
	/*
	 * Retourne vrai si le joueur n'est pas sur sa position de départ.
	 * Cette méthode n'est appelée sur le Joueur qu'au début de la partie.
	 */
	@Override
	public boolean horsLimite() {
		return this.xPos != 0 && this.yPos != Carte.TAILLE-1;
	}

	/*************************************/
	/************ RESSOURCES *************/
	/*************************************/

	/*
	 * Ajoute la monnaie en paramètre à la monnaie du Joueur.
	 */
	public void gagneMonnaie(int monnaieObtenue) {
		System.out.println("Vous gagnez " + monnaieObtenue + "$.");
		this.monnaie += monnaieObtenue;
	}

	/*
	 * Ajoute l'expérience en paramètre à l'expérience du Joueur.
	 */
	public void gagneEXP(int xpObtenue) {
		System.out.println("Vous gagnez " + xpObtenue + " XP.");
		this.xp += xpObtenue;
	}


	/*************************************/
	/*********** VUE GRAPHIQUE ***********/
	/*************************************/



}
