package miniRpgGraphique;

import java.util.ArrayList;

import miniRpgGraphique.mobs.Destructible;
import miniRpgGraphique.mobs.Monstre;
import miniRpgGraphique.mobs.Obstacle;
import miniRpgGraphique.vue.Fenetre;

public class Spawner {
	
	private ArrayList<Destructible> listeMobs;
	private Carte carte;
	private Fenetre fenetre;
	
	public Spawner(Carte carte, Fenetre fenetre) {
		this.carte = carte;

		this.listeMobs = new ArrayList<Destructible>();
		this.debutPartie();
	}
	
	// Pour carte de taille 4
	private void debutPartie() {
		listeMobs.add(new Obstacle(this.carte, 0, 0, fenetre));
		listeMobs.add(new Obstacle(this.carte, 1, 3, fenetre));
		listeMobs.add(new Monstre(this.carte, 2, 2, fenetre));
		listeMobs.add(new Monstre(this.carte, 3, 1, fenetre));
		listeMobs.add(new Monstre(this.carte, 1, 1, fenetre));
	}
	
	
	/*************************************/
	/************* ALEATOIRE *************/
	/************ NON TERMINÉ ************/
	/*************************************/
	
	private void debutPartieAleatoire() {
		int nombreMob = Carte.TAILLE+Carte.TAILLE/2;
		for(int i = 0 ; i < nombreMob ; i++) {
			if (i < Carte.TAILLE/2) {
				placementMapAleatoire(new Obstacle(this.carte, randomNumber(), randomNumber(), fenetre));
			}
			else {
				placementMapAleatoire(new Monstre(this.carte, randomNumber(), randomNumber(), fenetre));
			}
		}
	}
	
	private int randomNumber() {
		return (int)(Math.random() * Carte.TAILLE);
	}
	
	/*
	 * Gère les cas d'erreurs de placement d'un mob sur la map
	 * (voir l'implémentation de horsLimite() dans la classe Destructible) 
	 */
	private void placementMapAleatoire(Destructible mob) {
		mob.seePosition();
		System.out.println(mob.horsLimite());
		listeMobs.add(mob);
		
		if (!mob.horsLimite()) {
			listeMobs.add(mob);
		}
		/*
		else {
			if (mob instanceof Obstacle)
				placementMapHasard(new Obstacle(this.carte, randomNumber(), randomNumber()));
			else if (mob instanceof Monstre)
				placementMapHasard(new Monstre(this.carte, randomNumber(), randomNumber()));

		}
		*/

	}

	public ArrayList<Destructible> getListeMobs(){
		return this.listeMobs;
	}
	
}
