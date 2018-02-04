import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FileLeser {
	private FileReader reader;
	private File file;
	private Scanner sc;
	private String[] pfadListe;

	public FileLeser() {
		sc = new Scanner(System.in);
		pfadListe=lesePfadeEin();
		gebePfadListeAus();
	}

	public void leseDateiEin() {
//		reader = new FileReader()
	}

	public String askForString(String text) {
		System.out.print(text);
		return sc.nextLine();
	}
	public String[] lesePfadeEin() {
		file = new File(askForString("Geben Sie einen Ordnerpfad ein, in dem die die Dateien bearbeiten wollen: "));
		return file.list();
	}
	public void gebePfadListeAus() {
		for(String text : pfadListe) {
			System.out.println(text);
		}
	}

}
