package Pythagoras;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Canvis extends JFrame {


    CustomCanvas Canvas_ExapleCV = new CustomCanvas();
    CancisZeichnen Canvas_VorschauCV = new CancisZeichnen();

    public Canvis(Pythagoras pyth) {

        Canvas_VorschauCV.setBounds(200, 120, 350, 200);
        pyth.contentPane.add(Canvas_VorschauCV);

        Canvas_ExapleCV.setBounds(353, 28, 180, 100);
        pyth.contentPane.add(Canvas_ExapleCV);
    }

    // Eine benutzerdefinierte Canvas-Klasse, die das Bild zeichnet
    class CustomCanvas extends Canvas {
        private Image image;

        public CustomCanvas() {
            try {
                // Bild laden
                image = ImageIO.read(new File("/home/mieko/Documents/IntelliJ/School/src/Pythagoras/Pythagoras.png"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (image != null) {
                // Bild auf die Canvas zeichnen
                g.drawImage(image, 0, 0, getWidth(), getHeight()-10, this);
            }
        }
    }
    public CancisZeichnen getCanvas() {
        return Canvas_VorschauCV; // Getter für die Canvas
    }
    class CancisZeichnen extends Canvas {

        public CancisZeichnen() {

        }

        @Override
        public void paint(Graphics g) {
            super.paint(g);
            if (Eingabe.draw == true) {

                try {
                    double paintC = getWidth();
                    double paintA = (Eingabe.a * paintC) / Eingabe.c;
                    double paintB = (Eingabe.b * paintC) / Eingabe.c;
                    double paintH = (paintA*paintB)/paintC;

                    double pos_a_X = 0;
                    double pos_a_Y = getHeight()-1;

                    double pos_b_X = getWidth();
                    double pos_b_Y = getHeight()-1;

                    double pos_c_X = pos_a_X + Math.sqrt(Math.pow(paintA,2) - Math.pow(paintH,2));
                    double pos_c_Y = pos_a_Y - paintH;
                    g.setColor(Color.ORANGE);
                    g.drawLine((int) pos_b_X, (int) pos_b_Y, (int) pos_c_X, (int) pos_c_Y);
                    g.setColor(Color.BLUE);
                    g.drawLine((int) pos_a_X, (int) pos_a_Y, (int) pos_c_X, (int) pos_c_Y);
                    g.setColor(Color.RED);
                    g.drawLine((int) pos_a_X, (int) pos_a_Y, (int) pos_b_X, (int) pos_b_Y);

                } catch (NumberFormatException e) {
                    System.out.println(e);
                }
            }
        }
    }
}
