package Intro_Eclipse;

import java.awt.*;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Calendar;
import javax.imageio.ImageIO;

public class HundePanson extends JFrame {

    private static final long serialVersionUID = 1L;

    public JPanel contentPane;
    public JPanel contentPane2;

    private JTextField NameTF;
    private JTextField RasseTF;
    private JButton GassiBTN;
    private JButton FütternBTN;
    private JLabel RuckgabeTF;
    private JLabel TagTF;
    private JLabel DatenTF;

    public int Kilogramm = 0;
    public String name;
    public String rasse;
    public int tag = 0;

    private Thread update;

    public JComboBox<String> tagBox;
    public JComboBox<String> monatBox;
    public JComboBox<String> jahrBox;



    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HundePanson frame = new HundePanson();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */

    public void startGameLoop() {
        if (update == null) {
            update = new Thread(this::updateLoop);
            update.start();
        }

    }


    public void updateLoop() {
        try {

            // Hauptschleife
            while (true) {
                tag++;
                TagTF.setText("  Tag: " + tag);
                System.out.println("hi");
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }



    public HundePanson() throws IOException {
        setIconImage(Toolkit.getDefaultToolkit().getImage(HundePanson.class.getResource("/Intro_Eclipse/Hund_Dackel.png")));
        setTitle("DUHunde");
        setForeground(new Color(0, 0, 0));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setLocationRelativeTo(null); // Platziert das Fenster in der Mitte des Bildschirms
        contentPane = new JPanel();
        contentPane.setBackground(new Color(115, 170, 200));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane2 = new JPanel();
        contentPane2.setBackground(new Color(115, 170, 200));
        contentPane2.setBorder(new EmptyBorder(5, 5, 5, 5));

        contentPane2.setLayout(null);


        contentPane2.setVisible(false);

        setContentPane(contentPane);
        contentPane.setLayout(null);

        NameTF = new JTextField();
        NameTF.setBounds(175, 90, 150, 25);
        // 250 - 75
        contentPane.add(NameTF);
        NameTF.setColumns(10);

        RasseTF = new JTextField();
        RasseTF.setBounds(175, 140, 150, 25);
        contentPane.add(RasseTF);
        RasseTF.setColumns(10);

        JLabel TextLB = new JLabel("", JLabel.CENTER);
        TextLB.setBounds(0, 250, 500, 70);
        contentPane.add(TextLB);


        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(HundePanson.class.getResource("/Intro_Eclipse/Hund_Dackel.png")));
        lblNewLabel.setBounds(328, 89, 111, 100);
        contentPane.add(lblNewLabel);

        JLabel imageLabel = new JLabel();
        imageLabel.setBounds(350, 50, 500, 500); // Positioniere das Bild rechts
        imageLabel.setFont(new Font("",Font.PLAIN, 1));
        contentPane2.add(imageLabel);

        JButton StartBTN = new JButton("START");
        StartBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("Hi: " + Kilogramm);
                rasse = RasseTF.getText();
                name = NameTF.getText();
                if (rasse.length() < 1 || name.length() < 1) {
                    TextLB.setText("Bitte geben Sie die Werte ein");
                } else {
                    TextLB.setText(name + " wiegt: " + Kilogramm + " kg. Wollen Sie Ihren " + rasse + " weiter füttern oder Gassie gehen?");
                    RuckgabeTF.setText("Ihr " + name + " wiegt: " + Kilogramm + " kg. Wollen Sie Ihren " + rasse + " weiter füttern oder Gassie gehen?");
                    contentPane.setVisible(false);
                    setContentPane(contentPane2);
                    contentPane2.setVisible(true);
                    startGameLoop();
                }


            }
        });
        StartBTN.setBounds(180, 320, 140, 40);
        // 70  250 -70 = 180
        contentPane.add(StartBTN);

        JLabel RuckgabeLB = new JLabel("", JLabel.CENTER);
        RuckgabeLB.setBounds(37, 230, 398, 46);
        contentPane2.add(RuckgabeLB);


        GassiBTN = new JButton("GASSI");
        GassiBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RuckgabeTF.setText("Ihr " + name + " wiegt: " + Kilogramm + " kg. Wollen Sie Ihren " + rasse + " weiter füttern oder Gassie gehen?");
                Kilogramm--;
                if (Kilogramm <= 4) {
                    GassiBTN.setEnabled(false);
                }
                if (Kilogramm <= 30 && !FütternBTN.isEnabled()) {
                    FütternBTN.setEnabled(true);
                }
            }
        });
        GassiBTN.setBounds(47, 287, 107, 42);
        contentPane2.add(GassiBTN);

        FütternBTN = new JButton("FÜTTERN");
        FütternBTN.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Kilogramm++;
                if (Kilogramm >= 30) {
                    FütternBTN.setEnabled(false);
                }
                if (Kilogramm >= 4 && !GassiBTN.isEnabled()) {
                    GassiBTN.setEnabled(true);
                }
                RuckgabeTF.setText("Ihr " + name + " wiegt: " + Kilogramm + " kg. Wollen Sie Ihren " + rasse + " weiter füttern oder Gassie gehen?");
            }
        });
        FütternBTN.setBounds(328, 287, 107, 42);
        contentPane2.add(FütternBTN);

        JLabel NameLB = new JLabel("Wie heißt ihr Hund?");
        NameLB.setFont(new Font("", Font.HANGING_BASELINE, 15));
        NameLB.setBackground(new Color(0, 0, 0));
        NameLB.setBounds(10, 90, 187, 20);
        contentPane.add(NameLB);

        RasseTF.setBounds(175, 140, 150, 25);

        JLabel RasseLB = new JLabel("Welche Rasse?");
        RasseLB.setFont(new Font("", Font.HANGING_BASELINE, 15));
        RasseLB.setBackground(new Color(0, 0, 0));
        RasseLB.setBounds(10, 140, 187, 25);
        contentPane.add(RasseLB);

        JLabel GewichtLB = new JLabel("Was wiegt ihr Hund?");
        GewichtLB.setFont(new Font("", Font.HANGING_BASELINE, 15));
        GewichtLB.setBackground(new Color(0, 0, 0));
        GewichtLB.setBounds(10, 190, 187, 25);
        contentPane.add(GewichtLB);

        JLabel lbkg = new JLabel("kg");
        lbkg.setFont(new Font("", Font.HANGING_BASELINE, 15));
        lbkg.setBounds(350, 190, 69, 20);
        contentPane.add(lbkg);


        JLabel GeburtstagLS = new JLabel("Geburstag: ");
        GeburtstagLS.setFont(new Font("", Font.HANGING_BASELINE, 15));
        GeburtstagLS.setBackground(new Color(0, 0, 0));
        GeburtstagLS.setBounds(10, 230, 187, 25);
        contentPane.add(GeburtstagLS);

        JLabel ÜberschriftLB = new JLabel("Willkommen in unserer kleinen Hundepension");
        ÜberschriftLB.setFont(new Font("Comic Sans MS", Font.ITALIC, 20));
        ÜberschriftLB.setBounds(37, 35, 464, 25);
        ÜberschriftLB.setForeground(Color.BLUE);
        contentPane.add(ÜberschriftLB);
        //TODO: hihihi


        JSlider slider = new JSlider();
        slider.setToolTipText("Gewicht");
        slider.setPaintLabels(true);
        slider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                System.out.println(slider.getValue());
                Kilogramm = slider.getValue();
                lbkg.setText(Kilogramm + "Kg");
            }
        });
        slider.setValue(17);
        slider.setMinimum(4);
        slider.setMaximum(30);
        slider.setBackground(new Color(115, 170, 200));
        slider.setBounds(175, 190, 150, 25);
        contentPane.add(slider);

        RuckgabeTF = new JLabel("", JLabel.CENTER);
        RuckgabeTF.setFont(new Font("Tahoma", Font.PLAIN, 10));
        RuckgabeTF.setBounds(37, 71, 398, 205);
   //     contentPane2.add(RuckgabeTF);

        TagTF = new JLabel("Hallo");
        TagTF.setFont(new Font("Comic Sans MS", Font.PLAIN, 20));
        TagTF.setBounds(0, 50, 500, 80);
        contentPane2.add(TagTF);

        DatenTF = new JLabel("Daten", JLabel.CENTER);
        DatenTF.setFont(new Font("Comic Sans MS", Font.CENTER_BASELINE, 40));
        DatenTF.setBounds(0, 15, 500, 80);
        contentPane2.add(DatenTF);

        /*
        JLabel RuckgabeAlterTF = new JLabel("Alter: " + (monatBox.getSelectedIndex()+((tagBox.getSelectedIndex()+tag)%30)) + " Monate, " + (jahrBox.getSelectedIndex() + (monatBox.getSelectedIndex()%12)), JLabel.CENTER);
        RuckgabeAlterTF.setFont(new Font("Tahoma", Font.PLAIN, 10));
        RuckgabeAlterTF.setBounds(20, 70, 400, 200);
        contentPane2.add(RuckgabeAlterTF);

         */
        // Todo: Alter anzeigen(Manate,Jahre)
        // Todo: Gewicht anzeigen
        // Todo: Warnung Untergewicht (wenn 40% vom OriginalGewicht)
        // Todo: Stirb wenn 5 tage nichts zu essen
        // Todo: An Chinesischen Server Daten Schicken



// Tage von 1 bis 31
        String[] tage = new String[31];
        for (int i = 1; i <= 31; i++) {
            tage[i - 1] = Integer.toString(i);
        }

        tagBox = new JComboBox<>(tage);
        tagBox.setBounds(175, 230, 60, 25); // Beispielposition

// Monate von 1 bis 12
        String[] monate = {
                "Januar", "Februar", "März", "April", "Mai", "Juni",
                "Juli", "August", "September", "Oktober", "November", "Dezember"
        };

        monatBox = new JComboBox<>(monate);
        monatBox.setBounds(245, 230, 100, 25); // Beispielposition

// Jahre von 1900 bis zum aktuellen Jahr
        int aktuellesJahr = Calendar.getInstance().get(Calendar.YEAR);
        String[] jahre = new String[aktuellesJahr - 1900 + 1];
        for (int i = 1900; i <= aktuellesJahr; i++) {
            jahre[i - 1900] = Integer.toString(i);
        }

        jahrBox = new JComboBox<>(jahre);
        jahrBox.setBounds(355, 230, 80, 25); // Beispielposition

// Füge die JComboBoxen zu contentPane hinzu
        contentPane.add(tagBox);
        contentPane.add(monatBox);
        contentPane.add(jahrBox);


    }
}
