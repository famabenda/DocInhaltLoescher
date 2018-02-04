import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class Steuerung {
	private FileLeser fileLeser;
	private String[] filterElemente;
	private FileSchreiber schreiber;

	public Steuerung() throws IOException {
		fileLeser = new FileLeser();
		schreiber = new FileSchreiber(this);
		String filter = frageNutzerNachFilter();
		if (filter.contains(";")) {
			filterElemente = trenneFilterElemente(filter);

			schreiber.loescheFiles(getPfadListe());
			schreiber.schreibeFiles(filterLines(filterElemente));

		} else {

		}

	}

	private String frageNutzerNachFilter() {
		return FileLeser.askForString(
				"Geben Sie einen Filter ein. Falls Sie mehrere Filter eingeben möchten, geben Sie diese bitte mit Strichkomma (;) getrennt ein:  ");
	}

	// private boolean filterDateien(String filter) {
	//
	// }

	private String[] trenneFilterElemente(String filterElemente) {

		return filterElemente.split(";");
	}

	private ArrayList<File> filterLines(String[] filterElemente) throws IOException {
		ArrayList<File> fileListe = fileLeser.leseDateienEin();
		ArrayList<File> ergebnisListe = new ArrayList<>();
		FileWriter writer;
		BufferedReader reader;
		for (File file : fileListe) {
			reader = new BufferedReader(new FileReader(file));
			String zeile;
			File ergebnisFile = new File(file.getPath());
			writer = new FileWriter(ergebnisFile);

			if ((zeile = reader.readLine()) != null) {
				if (!pruefeZeileAufFilter(zeile)) {
					writer.write(zeile);
				}
			}
			ergebnisListe.add(ergebnisFile);

		}
		return ergebnisListe;

	}

	private boolean pruefeZeileAufFilter(String zeile) {
		for (String filter : filterElemente) {

			if (zeile.contains(filter)) {
				return true;
			}
		}
		return false;
	}

	public ArrayList<String> getPfadListe() {
		return fileLeser.getPfadListe();

	}

	// private boolean filterLines(String filterElement) {
	//
	// }

}
