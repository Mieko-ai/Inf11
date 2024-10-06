package Intro_Eclipse;

import javax.swing.JOptionPane;

public class DogPension {
    public static void main(String[] args) {
        String name = JOptionPane.showInputDialog("Geben Sie den Namen des Hundes ein:");
        String breed = JOptionPane.showInputDialog("Geben Sie die Rasse des Hundes ein:");
        double weight = 8.0;

        String action = JOptionPane.showInputDialog("Möchten Sie den Hund füttern oder Gassi gehen? (geben Sie 'füttern' oder 'Gassi' ein)");
        if (action.equalsIgnoreCase("füttern")) {
            weight += 0.2;
        } else if (action.equalsIgnoreCase("Gassi")) {
            weight -= 0.1;
        }

        if (weight < 4 || weight > 30) {
            JOptionPane.showMessageDialog(null, "Das Gewicht ist nicht zulässig.");
        } else {
            JOptionPane.showMessageDialog(null, "Das aktuelle Gewicht des Hundes " + name + " ist: " + weight + " kg");
        }
    }
}
