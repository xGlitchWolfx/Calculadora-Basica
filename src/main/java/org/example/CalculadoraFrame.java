package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraFrame extends JFrame {
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel lblResultado;

    public CalculadoraFrame() {
        super("Calculadora Básica");
        initComponents();
    }

    private void initComponents() {
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3, 1));

        JPanel panelNumeros = new JPanel(new FlowLayout());
        txtNumero1 = new JTextField(5);
        txtNumero2 = new JTextField(5);
        panelNumeros.add(new JLabel("Num 1:"));
        panelNumeros.add(txtNumero1);
        panelNumeros.add(new JLabel("Num 2:"));
        panelNumeros.add(txtNumero2);

        JPanel panelBotones = new JPanel(new FlowLayout());
        JButton btnSuma = new JButton("+");
        JButton btnResta = new JButton("-");
        JButton btnMultiplicacion = new JButton("*");
        JButton btnDivision = new JButton("%");

        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularOperacion(e.getActionCommand());
            }
        };

        btnSuma.addActionListener(listener);
        btnResta.addActionListener(listener);
        btnMultiplicacion.addActionListener(listener);
        btnDivision.addActionListener(listener);

        panelBotones.add(btnSuma);
        panelBotones.add(btnResta);
        panelBotones.add(btnMultiplicacion);
        panelBotones.add(btnDivision);

        // Panel para mostrar resultado
        JPanel panelResultado = new JPanel(new FlowLayout());
        lblResultado = new JLabel("Resultado: ");
        panelResultado.add(lblResultado);

        panel.add(panelNumeros);
        panel.add(panelBotones);
        panel.add(panelResultado);

        add(panel);
    }

    private void calcularOperacion(String operacion) {
        try {
            double num1 = Double.parseDouble(txtNumero1.getText());
            double num2 = Double.parseDouble(txtNumero2.getText());
            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = num1 + num2;
                    break;
                case "-":
                    resultado = num1 - num2;
                    break;
                case "*":
                    resultado = num1 * num2;
                    break;
                case "%":
                    if (num2 == 0) {
                        JOptionPane.showMessageDialog(this, "No se puede dividir entre 0");
                        return;
                    }
                    resultado = num1 / num2;
                    break;
            }

            lblResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Por favor, ingresa números válidos.");
        }
    }
}

