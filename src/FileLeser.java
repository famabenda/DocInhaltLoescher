import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLeser {
	private FileReader reader;
	private static Scanner sc;
	private ArrayList<String> pfadListe;

	public FileLeser() {
		sc = new Scanner(System.in);
		pfadListe = new ArrayList<>();

		gebePfadListeAus();
	}

	public void leseDateiEin() {
		// reader = new FileReader()
	}

	public static String askForString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}

	public ArrayList<String> lesePfadeEin() {
		File file;
		file = new File(askForString("Geben Sie einen Ordnerpfad ein, in dem die die Dateien bearbeiten wollen: "));
		String[] pfadListe = file.list();
		ArrayList<String> pfadArrayList = new ArrayList<>();
		for (String pfad : pfadListe) {
			pfadArrayList.add(pfad);
		}
		return pfadArrayList;
	}

	public ArrayList<File> leseDateienEin() {
		pfadListe = lesePfadeEin();
		ArrayList<File> fileListe = new ArrayList();
		for (int i = 0; i < fileListe.size(); i++) {
			fileListe.add(new File(pfadListe.get(i)));
		}
		return fileListe;

	}

	public void gebePfadListeAus() {
		for (String text : pfadListe) {
			System.out.println(text);
		}
	}

	public ArrayList<String> getPfadListe() {
		return pfadListe;
	}

}
