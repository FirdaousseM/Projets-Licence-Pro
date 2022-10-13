package lecteursDeFichiers.texte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class LecteurInverse extends LecteurTexte{
	
	public LecteurInverse() {
		
	}
	
	public String contenuFichier(File fichier) throws IOException {
		
		String contenuFichier = super.contenuFichier(fichier);
		String contenuInverse = "";
		
		for (int i = contenuFichier.length()-1 ; i >= 0 ; i--) {
			contenuInverse += contenuFichier.charAt(i);
		}
		return contenuInverse.substring(1);
	}
}
