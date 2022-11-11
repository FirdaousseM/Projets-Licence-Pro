package miniRpg;

import java.util.Scanner;

import miniRpg.armes.Magasin;
import miniRpg.mobs.Destructible;
import miniRpg.mobs.Joueur;
import miniRpg.mobs.Monstre;

public class GestionnaireChoix {

	public static final Scanner ENTREE = new Scanner(System.in);

	private Magasin magasin;
	private Joueur joueur;
	Spawner spawner;

	public GestionnaireChoix(Magasin magasin, Joueur joueur, Spawner spawner) {
		this.magasin = magasin;
		this.joueur = joueur;
		this.spawner = spawner;

	}


	/*************************************/
	/************** ACTIONS **************/
	/*************************************/

	public void achatArme(int numeroArme) {
		this.joueur.acheterArme(this.magasin.armeAchetee(numeroArme));
	}

	private void rencontreMob(int[] coordonnees) {

		for (Destructible mob : spawner.getListeMobs()) {
			if (mob.checkPosition(coordonnees[0], coordonnees[1])) {

				this.joueur.rencontre(mob);
				if (mob instanceof Monstre) {
					this.choixRencontre();
				}
				else {
					this.joueur.combat();
				}
			}
		}

	}

	/*************************************/
	/*************** CHOIX ***************/
	/*************************************/

	public void choixPrincipal() {
		System.out.println(
				"(1) : Déplacement | "
						+ "(2) : Magasin "
						+ "\n(3) : Inventaire");

		String choix = ENTREE.nextLine();

		switch(choix) {
		case "1" : choixDeplacement();
		break;
		case "2" : choixMagasinGeneral();
		break;
		case "3" : choixInventaire();
		break;
		}
	}

	private void choixDeplacement() {
		System.out.println(
				"(1) : Haut | "
						+ "(2) : Droite "
						+ "\n(3) : Bas  | "
						+ "(4) : Gauche");

		String choix = ENTREE.nextLine();

		this.rencontreMob(this.joueur.deplacement(choix));

	}

	private void choixRencontre() {

		System.out.println(
				"(1) : Affrontement | "
						+ "(2) : Fuite ");

		String choix = ENTREE.nextLine();

		switch(choix) {
		case "1" : this.joueur.combat();
		break;
		case "2" : this.joueur.fuite();
		break;
		default: System.out.println("S'il vous plaît, taper '1' ou '2'");
		break;
		}
	}

	private void choixMagasinVente() {

		this.joueur.voirInventaire();

		String choix = ENTREE.nextLine();

		int numeroArme = Integer.valueOf(choix);

		if (numeroArme > joueur.tailleInventaire() || numeroArme <= 0) {
			System.out.println("S'il vous plaît, choisir une arme de l'inventaire");
		}
		else {
			this.magasin.recupereArme(this.joueur.armeVendue(numeroArme));
		}

	}

	private void choixMagasinAchat() {

		this.magasin.voirListeArticles();

		String choix = ENTREE.nextLine();

		int numeroArme = Integer.valueOf(choix);

		if (magasin.nbArticle() < numeroArme) {
			System.out.println("S'il vous plaît, choisir une arme disponible");
		}
		else {
			this.joueur.acheterArme(this.magasin.armeAchetee(numeroArme-1));
		}

	}

	private void choixMagasinGeneral() {

		System.out.println(
				"(1) : Achat | "
						+ "(2) : Vente");

		String choix = ENTREE.nextLine();

		switch (choix) {
		case "1": choixMagasinAchat();
		break;
		case "2": choixMagasinVente();
		break;
		}

	}

	private void choixInventaire() {

		System.out.println("CHOISIR UNE ARME :\n");

		this.joueur.voirInventaire();

		String choix = ENTREE.nextLine();

		int numeroArme = Integer.valueOf(choix);
		this.joueur.choixArme(numeroArme);

	}

}
