package miniRpg.armes;

public abstract class Arme {

	private int degat;
	private int prix;

	public Arme(int degat, int prix) {
		this.degat = degat;
		this.prix = prix;
	}

	public String toString() {
		return this.ascii_art();
	}
					  
	public int equipee(int puissance) {
		return puissance + this.degat;
	}
	
	public int getPrix() {
		return this.prix;
	}
	
	public abstract String ascii_art();
	
	public abstract String details();
	

}
