package Pythagoras;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Eingabe extends JFrame {
    public static boolean draw = false;
    Button A_BTN = new Button("A");
    Button B_BTN = new Button("B");
    Button C_BTN = new Button("C");
    public static double a;
    public static double b;
    public static double c;
    public String gesucht;
    JTextField Textfield_firstTF = new JTextField();
    JTextField Textfield_secondTF = new JTextField();

    JLabel ausgabeA = new JLabel("a:");
    JLabel ausgabeB = new JLabel("b:");
    JLabel ausgabeC = new JLabel("c:");
    JLabel Ausgabe = new JLabel("Ausgabe");

    public Eingabe(Pythagoras pyth) {
        // Button A Baustein
        A_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Textfield_firstTF.getText().trim();
                if (input.equals("b")) {
                    Textfield_secondTF.setText(Textfield_firstTF.getText());
                    Textfield_firstTF.setText("a");
                    C_BTN.setEnabled(false);
                    gesucht = "c";
                    pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und b ein");
                    Textfield_firstTF.setEnabled(true);
                    Textfield_secondTF.setEnabled(true);
                } else if (input.equals("c")) {
                    Textfield_secondTF.setText(Textfield_firstTF.getText());
                    Textfield_firstTF.setText("a");
                    B_BTN.setEnabled(false);
                    gesucht = "b";
                    pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und c ein");
                    Textfield_firstTF.setEnabled(true);
                    Textfield_secondTF.setEnabled(true);
                }if(input.isEmpty()){
                    Textfield_firstTF.setText("a");
                }

            }
        });
        A_BTN.setBounds(10, 81, 101, 47);
        pyth.contentPane.add(A_BTN);


        // Button B Baustein
        B_BTN.setBounds(117, 81, 110, 47);
        B_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Textfield_firstTF.getText().trim();
                String input2 = Textfield_secondTF.getText().trim();
                if (input.isEmpty()) {
                    Textfield_firstTF.setText("b");
                } else if (input2.isEmpty()) {
                    if (input.equals("c")) {
                        Textfield_secondTF.setText(Textfield_firstTF.getText());
                        Textfield_firstTF.setText("b");
                        pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und c ein");
                        A_BTN.setEnabled(false);
                        gesucht = "a";
                        pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder b und c ein");
                        Textfield_firstTF.setEnabled(true);
                        Textfield_secondTF.setEnabled(true);
                    } else {
                        Textfield_secondTF.setText("b");
                        C_BTN.setEnabled(false);
                        gesucht = "c";
                        pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und b ein");
                        Textfield_firstTF.setEnabled(true);
                        Textfield_secondTF.setEnabled(true);
                    }
                }
            }
        });
        pyth.contentPane.add(B_BTN);

        // Button C Baustein
        C_BTN.setBounds(233, 81, 110, 47);
        C_BTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = Textfield_firstTF.getText().trim();
                String input2 = Textfield_secondTF.getText().trim();
                if (input.isEmpty()) {
                    Textfield_firstTF.setText("c");
                } else if (input2.isEmpty()) {
                    Textfield_secondTF.setText("c");
                    if (input.equals("a")) {
                        B_BTN.setEnabled(false);
                        gesucht = "b";
                        pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und c ein");
                        Textfield_firstTF.setEnabled(true);
                        Textfield_secondTF.setEnabled(true);
                    } else if (input.equals("b")) {
                        A_BTN.setEnabled(false);
                        gesucht = "a";
                        pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder b und c ein");
                        Textfield_firstTF.setEnabled(true);
                        Textfield_secondTF.setEnabled(true);
                    }
                }
            }
        });
        pyth.contentPane.add(C_BTN);

        // DocumentListener für das TextField hinzufügen
        Textfield_firstTF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChanged(pyth);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChanged(pyth);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textChanged(pyth);
            }

            // Methode, die bei Änderungen aufgerufen wird

        });
        Textfield_firstTF.setBounds(10, 144, 180, 29);
        Textfield_firstTF.setEnabled(false);
        pyth.contentPane.add(Textfield_firstTF);
        Textfield_firstTF.setColumns(10);

        // DocumentListener für das TextField hinzufügen
        Textfield_secondTF.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                textChanged(pyth);
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                textChanged(pyth);
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                textChanged(pyth);
            }
            // Methode, die bei Änderungen aufgerufen wird

        });
        Textfield_secondTF.setBounds(10, 184, 179, 29);
        Textfield_secondTF.setEnabled(false);
        pyth.contentPane.add(Textfield_secondTF);
        Textfield_secondTF.setColumns(10);

        // AusgabeA Farbe: Cyan (Hab ich nicht hinbekommen)
        ausgabeA.setEnabled(false);
        ausgabeA.setBounds(10, 247, 180, 24);
        pyth.contentPane.add(ausgabeA);

        // AusgabeB Farbe: Orange (Hab ich nicht hinbekommen)
        ausgabeB.setEnabled(false);
        ausgabeB.setBounds(10, 275, 180, 22);
        pyth.contentPane.add(ausgabeB);

        // AusgabeC Farbe: Rot (Hab ich nicht hinbekommen)
        ausgabeC.setEnabled(false);
        ausgabeC.setBounds(10, 303, 180, 22);
        pyth.contentPane.add(ausgabeC);

        Ausgabe.setBounds(10, 219, 62, 22);
        pyth.contentPane.add(Ausgabe);
    }
    public void textChanged(Pythagoras pyth) {
        try {

            if((Integer.parseInt(Textfield_firstTF.getText())) < 0 || (Integer.parseInt(Textfield_secondTF.getText()))<0){
                pyth.HilfenLBL.setText("Bitte geben sie eine Positive Zahl ein");
            }else {
                if (gesucht.equals("a")) {
                    pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder b und c ein");
                    b = Integer.parseInt(Textfield_firstTF.getText());
                    c = Integer.parseInt(Textfield_secondTF.getText());
                    a = Math.sqrt(Math.pow(c, 2) - Math.pow(b, 2));


                }
                if (gesucht.equals("b")) {
                    pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und c ein");
                    a = Integer.parseInt(Textfield_firstTF.getText());
                    c = Integer.parseInt(Textfield_secondTF.getText());
                    b = Math.sqrt(Math.pow(c, 2) - Math.pow(a, 2));
                }
                if (gesucht.equals("c")) {
                    pyth.HilfenLBL.setText("Bitte geben Sie in den Textfelder a und b ein");
                    a = Integer.parseInt(Textfield_firstTF.getText());
                    b = Integer.parseInt(Textfield_secondTF.getText());
                    c =  Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));
                }
                ausgabeA.setText("a: " + a);
                ausgabeB.setText("b: " + b);
                ausgabeC.setText("c: " + c);
                draw = true;
                Canvis can = new Canvis(pyth);
                can.getCanvas().repaint();
            }
        } catch (NumberFormatException ex) {

        }

    }
}
