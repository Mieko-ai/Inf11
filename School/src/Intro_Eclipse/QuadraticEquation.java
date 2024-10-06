package Intro_Eclipse;
import javax.swing.JOptionPane;

public class QuadraticEquation {
    public static void main(String[] args) {
        double a = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie a ein:"));
        double b = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie b ein:"));
        double c = Double.parseDouble(JOptionPane.showInputDialog("Geben Sie c ein:"));

        double discriminant = b * b - 4 * a * c;
        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            JOptionPane.showMessageDialog(null, "Die Nullstellen sind: " + root1 + " und " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            JOptionPane.showMessageDialog(null, "Die Nullstelle ist: " + root);
        } else {
            JOptionPane.showMessageDialog(null, "Es gibt keine reale Lösung.");
        }
    }
}
