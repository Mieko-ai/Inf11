package ok;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class hehe {

    public static void main(String[] args) {
        // Pfad zum Quellbild (inklusive Dateiname)
        // Pfad zum Zielordner
        String zielOrdnerPfad = "/home/mieko/Documents/IntelliJ/School/src/ok/";
        String bildPfad = zielOrdnerPfad + "img.png";









































        // Quelle und Ziel-Ordner
        File quellBild = new File(bildPfad);
        File zielOrdner = new File(zielOrdnerPfad);

        // Sicherstellen, dass der Zielordner existiert
        if (!zielOrdner.exists()) {
            zielOrdner.mkdirs();
        }

        // Erstellen von 20 Kopien
        for (int i = 1; i <= 1000; i++) {
            // Neue Datei für die Kopie
            File zielBild = new File(zielOrdnerPfad + "bild_kopie_" + i + ".jpg");

            try {
                // Kopieren der Datei
                Files.copy(quellBild.toPath(), zielBild.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Kopie " + i + " erstellt: " + zielBild.getAbsolutePath());
            } catch (IOException e) {
                System.err.println("Fehler beim Kopieren der Datei: " + e.getMessage());
            }
        }
    }
}
