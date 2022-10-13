package lecteursDeFichiers.texte;

import java.io.File;
import java.io.IOException;

public class LecteurPalindrome extends LecteurTexte{
	private LecteurInverse inverse;
	
	public LecteurPalindrome() {
		this.inverse = new LecteurInverse();
	}
	
	public String contenuFichier(File fichier) throws IOException {
		
		return super.contenuFichier(fichier) + inverse.contenuFichier((fichier));
	}
}
