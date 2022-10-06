package bataille;

public class Bataille {

	public static void main(String[] args) {

		Joueur joueur1 = new Joueur("Jonathan");

		Joueur joueur2 = new Joueur("Joseph");

		int i = 1;
		
		while (!joueur1.aPerduContre(joueur2) && !joueur2.aPerduContre(joueur1)) {
			
			Carte carteJ1 = joueur1.jouerCarte();
			Carte carteJ2 = joueur2.jouerCarte();

			if (carteJ1.compareTo(carteJ2) > 0) {
				joueur1.gagneUnPoint();
				System.out.println(i + " - " + joueur1 + " bat " + joueur2);
			} else if (carteJ1.compareTo(carteJ2) < 0){
				joueur2.gagneUnPoint();
				System.out.println(i + " - " + joueur2 + " bat " + joueur1);
			} else {
				System.out.println(i + " - Egalité");
			}
			System.out.println(
					joueur1 + " a " + joueur1.getPoints() + " pts | " +
					joueur2 + " a " + joueur2.getPoints() + " pts \n");
			i++;
		}
	}

}
