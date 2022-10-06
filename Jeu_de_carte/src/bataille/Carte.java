package bataille;

public class Carte {
	public static int[] listeValeurs = {2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};

	// 13 est l'as
	public static String[] listeCouleurs = {"COEUR", "PIQUE", "CARREAU", "TREFLE"};

	private int valeur;

	private String couleur;

	public Carte() {
		int randomizer = (int) (Math.random() * 12);
		this.valeur = listeValeurs[randomizer];
		
		randomizer = (int) (Math.random() * 4);
		this.couleur = listeCouleurs[randomizer];
	}

	public int compareTo(Carte autreCarte) {
		return this.valeur - autreCarte.valeur;
	}

	@Override
	public String toString() {

		String carteValeur;

		switch (this.valeur) {
		case 10: carteValeur = "Valet";
		break;
		case 11: carteValeur = "Reine";
		break;
		case 12: carteValeur = "Roi";
		break;
		case 13: carteValeur = "As";
		break;
		default: carteValeur = String.valueOf(this.valeur);
		break;
		}

		return "[" + carteValeur + " de " + this.couleur + "]";
	}


}
