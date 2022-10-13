package lecteursDeFichiers;

import java.io.File;
import java.io.IOException;

public interface LecteurFichier {

	public void lit(File fichier) throws IOException;
}
