package Intro_Eclipse;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GeburtsdatumAuswaehlen {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Geburtsdatum auswählen");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());

        // Tage von 1 bis 31
        String[] tage = new String[31];
        for (int i = 1; i <= 31; i++) {
            tage[i - 1] = Integer.toString(i);
        }
        JComboBox<String> tagBox = new JComboBox<>(tage);

        // Monate von 1 bis 12
        String[] monate = {
                "Januar", "Februar", "März", "April", "Mai", "Juni",
                "Juli", "August", "September", "Oktober", "November", "Dezember"
        };
        JComboBox<String> monatBox = new JComboBox<>(monate);

        // Jahre von 1900 bis zum aktuellen Jahr
        int aktuellesJahr = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        String[] jahre = new String[aktuellesJahr - 1900 + 1];
        for (int i = 1900; i <= aktuellesJahr; i++) {
            jahre[i - 1900] = Integer.toString(i);
        }
        JComboBox<String> jahrBox = new JComboBox<>(jahre);

        // Button zum Anzeigen des ausgewählten Geburtsdatums
        JButton button = new JButton("Geburtsdatum anzeigen");

        // Label zur Anzeige des ausgewählten Geburtsdatums
        JLabel resultLabel = new JLabel("Dein Geburtsdatum: ");

        // ActionListener für den Button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String tag = (String) tagBox.getSelectedItem();
                String monat = (String) monatBox.getSelectedItem();
                String jahr = (String) jahrBox.getSelectedItem();
                resultLabel.setText("Dein Geburtsdatum: " + tag + ". " + monat + " " + jahr);
            }
        });

        // Füge die Komponenten zum Frame hinzu
        frame.add(new JLabel("Tag:"));
        frame.add(tagBox);
        frame.add(new JLabel("Monat:"));
        frame.add(monatBox);
        frame.add(new JLabel("Jahr:"));
        frame.add(jahrBox);
        frame.add(button);
        frame.add(resultLabel);

        frame.setVisible(true);
    }
}
