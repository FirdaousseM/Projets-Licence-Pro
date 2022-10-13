package lecteursDeFichiers.texte;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import lecteursDeFichiers.LecteurFichier;

public class LecteurTexte implements LecteurFichier{

	public LecteurTexte() {

	}

	public void lit(File fichier) throws IOException {
		System.out.println(this.contenuFichier(fichier));
	}
	
	protected String contenuFichier(File fichier) throws IOException {
		
		FileInputStream in = null;
		String contenuFichier = "";
		try {
			in = new FileInputStream(fichier);
			int caractere = in.read();
			
			while(caractere != -1) {
				contenuFichier += (char) caractere;
				caractere = in.read();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				in.close();
			}
		}
		return contenuFichier;
	}
}
