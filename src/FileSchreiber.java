import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileSchreiber {
	Steuerung steuerung;

	public FileSchreiber(Steuerung steuerung) {
		this.steuerung = steuerung;
	}

	public void schreibeFiles(ArrayList<File> fileListe) throws IOException {
		ArrayList<String> pfadListe = steuerung.getPfadListe();
		for (int i = 0; i < pfadListe.size(); i++) {
			fileListe.get(i).;
		}
	}

	public void loescheFiles(ArrayList<String> pfadListe) {
		for (String pfad : pfadListe) {
			File f = new File(pfad);
			f.deleteOnExit();
		}
	}
}
