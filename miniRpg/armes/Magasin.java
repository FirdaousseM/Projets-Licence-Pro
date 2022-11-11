package miniRpg.armes;

import java.util.ArrayList;

public class Magasin {
	private ArrayList<Arme> listeArticles;
	
	public Magasin() {
		this.listeArticles = new ArrayList<Arme>();
		this.listeArticles.add(new Epee());
		this.listeArticles.add(new Arc());
		this.listeArticles.add(new Hache());
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
	
}
