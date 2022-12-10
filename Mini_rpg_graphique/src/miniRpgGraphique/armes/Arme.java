package miniRpgGraphique.armes;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JLabel;

public abstract class Arme {

	private int degat;
	private int prix;
	private JLabel image;

	public Arme(int degat, int prix, JLabel img) {
		this.degat = degat;
		this.prix = prix;
		this.image = img;
		this.image.setMinimumSize(new Dimension(64, 64));
		this.image.setPreferredSize(new Dimension(64, 64));
		this.image.setMaximumSize(new Dimension(64, 64));
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
	
	public JLabel affichage_img() {
		return this.image;
	}

}
