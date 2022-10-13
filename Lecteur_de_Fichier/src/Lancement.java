import java.io.File;
import java.io.IOException;

import lecteursDeFichiers.LecteurFichier;
import lecteursDeFichiers.texte.LecteurInverse;
import lecteursDeFichiers.texte.LecteurPalindrome;
import lecteursDeFichiers.texte.LecteurTexte;

public class Lancement {

	public static void main(String[] args) {

		// Remplacer en paramètre le chemin absolue vers le fichier à lire.
		File fileToRead = new File("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Lecteur_de_Fichier/file.txt");

		
		LecteurTexte lecteurTxt = new LecteurTexte();
		LecteurTexte lecteurInv = new LecteurInverse();
		LecteurTexte lecteurPal = new LecteurPalindrome();

		try {
			System.out.println("LECTEUR FICHIER TEXTE :\n");
			lecteurTxt.lit(fileToRead);
			
			System.out.println("\nLECTEUR FICHIER TEXTE INVERSÉ :\n");
			lecteurInv.lit(fileToRead);
			
			System.out.println("\nLECTEUR FICHIER TEXTE PALINDROME :\n");
			lecteurPal.lit(fileToRead);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
