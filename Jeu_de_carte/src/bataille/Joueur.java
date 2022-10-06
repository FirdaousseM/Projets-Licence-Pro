package bataille;
import java.util.ArrayList;

public class Joueur {

	private ArrayList<Carte> laMain;
	private String nom;
	private int points;

	public Joueur(String nom) {
		this.nom = nom;

		this.points = 0;

		this.laMain = new ArrayList<>();

		for(int i = 0 ; i < 8; i++) {
			this.laMain.add(new Carte());
		}
	}

	public Carte jouerCarte() {
		Carte carteAleatoire = this.laMain.get((int) Math.random()*this.laMain.size());

		System.out.println(this.nom + " joue " + carteAleatoire);
		this.laMain.remove(carteAleatoire);

		return carteAleatoire;

	}

	public void piocherCarte() {
		this.laMain.add(new Carte());
	}

	public void gagneUnPoint() {
		this.points++;
	}

	public int compareTo(Joueur adversaire) {
		return this.points - adversaire.points;
	}

	public boolean aPerduContre(Joueur adversaire) {
		if (this.laMain.isEmpty() && this.points < adversaire.points) {
			System.out.println(adversaire + " a gagné contre " + this);
			return true;
		}
		if (this.laMain.isEmpty() && this.points == adversaire.points) {
			System.out.println("Egalité entre " + this + " et " + adversaire);
			return true;
		}
		return false;
	}

	@Override
	public String toString() {
		return this.nom;

	}

	public int getPoints() {
		return this.points;
	}
}
