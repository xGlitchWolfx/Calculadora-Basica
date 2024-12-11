package org.example;

public class Main {
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(() -> {
            CalculadoraFrame frame = new CalculadoraFrame();
            frame.setVisible(true);
        });
    }
}
