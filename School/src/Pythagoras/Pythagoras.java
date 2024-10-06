package Pythagoras;


import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

public class Pythagoras extends JFrame {

    private static final long serialVersionUID = 1L;
    public JPanel contentPane;

    public JLabel HilfenLBL;
    public JLabel Pythagoras_TitleLBL;

    public Graphics g = getGraphics();
    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Pythagoras frame = new Pythagoras();
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
    public Pythagoras() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 560, 393);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);



        Pythagoras_TitleLBL = new JLabel("Pythagoras-Rechner");
        Pythagoras_TitleLBL.setFont(new Font("Arial", Font.PLAIN, 24));
        Pythagoras_TitleLBL.setBounds(10, 11, 305, 47);
        contentPane.add(Pythagoras_TitleLBL);

        HilfenLBL = new JLabel("Klicken Sie auf die Buttons, deren Wert sie kennen");
        HilfenLBL.setFont(new Font("Arial", Font.PLAIN, 12));
        HilfenLBL.setBounds(10, 50, 305, 30);
        contentPane.add(HilfenLBL);

        Eingabe eingabe = new Eingabe(this);
        eingabe.setVisible(true);

        Canvis canvis = new Canvis(this);
        canvis.setVisible(true);

    }


}
