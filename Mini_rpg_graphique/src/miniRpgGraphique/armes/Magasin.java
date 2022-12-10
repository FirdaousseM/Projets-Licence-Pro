package miniRpgGraphique.armes;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import miniRpgGraphique.vue.Fenetre;

public class Magasin {
	private ArrayList<Arme> listeArticles;
	private JPanel panelMagasin;
	private Fenetre fenetre;
	
	public Magasin(Fenetre fenetre) {
		this.listeArticles = new ArrayList<Arme>();
		this.listeArticles.add(new Epee());
		this.listeArticles.add(new Arc());
		this.listeArticles.add(new Hache());
		
		panelMagasin = new JPanel();
		this.fenetre = fenetre;
		initPanel();
	}
	
	public void voirListeArticles() {
		for (int i = 0 ; i < this.listeArticles.size() ; i++) {
			System.out.println("\n[" + (i+1) + "]" + this.listeArticles.get(i).details());
		}
	}
	
	public Arme armeAchetee(int numeroArticle) {
		
		Arme article = this.listeArticles.get(numeroArticle);
		this.listeArticles.remove(article);
		
		return article;
	}
	
	public void recupereArme(Arme arme) {
		
		this.listeArticles.add(arme);
	}
	
	public int nbArticle() {
		return this.listeArticles.size();
	}

	
	/***** VUE GRAPHIQUE ******/
	
	private void initPanel() {
		panelMagasin.setLayout(new GridLayout(2, listeArticles.size()));
		panelMagasin.setBackground(Color.white);
		
		for(Arme arme : listeArticles) {
			panelMagasin.add(arme.affichage_img());
		}
		
		for(Arme arme : listeArticles) {
			panelMagasin.add(new JLabel(arme.getPrix() + " $ ", SwingConstants.CENTER));
		}
		
		
		fenetre.mainPanel.add(panelMagasin, BorderLayout.NORTH);
		System.out.println(panelMagasin);
	}
	
}
