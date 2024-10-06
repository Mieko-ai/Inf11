package Intro_Eclipse;

import javax.swing.JOptionPane;

public class Pythagoras {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie die Länge der ersten Seite ein:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie die Länge der zweiten Seite ein:"));

        double c = Math.sqrt(a * a + b * b);
        JOptionPane.showMessageDialog(null, "Die Länge der dritten Seite ist: " + c);
    }
}
