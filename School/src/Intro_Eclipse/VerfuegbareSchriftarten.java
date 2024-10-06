package Intro_Eclipse;

import java.awt.GraphicsEnvironment;

public class VerfuegbareSchriftarten {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] schriftarten = ge.getAvailableFontFamilyNames();

        System.out.println("Verfügbare Schriftarten:");
        for (String schrift : schriftarten) {
            System.out.println(schrift);
        }
    }
}
