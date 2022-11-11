package miniRpg;

import java.util.ArrayList;

import miniRpg.mobs.Destructible;
import miniRpg.mobs.Monstre;
import miniRpg.mobs.Obstacle;

public class Spawner {
	
	private ArrayList<Destructible> listeMobs;
	private Carte carte;
	
	public Spawner(Carte carte) {
		this.carte = carte;

		this.listeMobs = new ArrayList<Destructible>();
		this.debutPartie();
	}
	
	// Pour carte de taille 4
	private void debutPartie() {
		listeMobs.add(new Obstacle(this.carte, 0, 0));
		listeMobs.add(new Obstacle(this.carte, 1, 3));
		listeMobs.add(new Monstre(this.carte, 2, 2));
		listeMobs.add(new Monstre(this.carte, 3, 1));
		listeMobs.add(new Monstre(this.carte, 1, 1));
	}
	
	
	/*************************************/
	/************* ALEATOIRE *************/
	/************ NON TERMINÉ ************/
	/*************************************/
	
	private void debutPartieAleatoire() {
		int nombreMob = Carte.TAILLE+Carte.TAILLE/2;
		for(int i = 0 ; i < nombreMob ; i++) {
			if (i < Carte.TAILLE/2) {
				placementMapAleatoire(new Obstacle(this.carte, randomNumber(), randomNumber()));
			}
			else {
				placementMapAleatoire(new Monstre(this.carte, randomNumber(), randomNumber()));
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
