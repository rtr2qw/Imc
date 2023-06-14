import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IMCCalculator extends JFrame {

    private JTextField pesoTextField;
    private JTextField alturaTextField;
    private JLabel resultadoLabel;

    public IMCCalculator() {
        setTitle("Calculadora de IMC");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        setLayout(new FlowLayout());

        JLabel pesoLabel = new JLabel("Peso (Kg):");
        pesoTextField = new JTextField(10);

        JLabel alturaLabel = new JLabel("Altura (Cm):");
        alturaTextField = new JTextField(10);

        JButton calcularButton = new JButton("Calcular");

        resultadoLabel = new JLabel();

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        add(pesoLabel);
        add(pesoTextField);
        add(alturaLabel);
        add(alturaTextField);
        add(calcularButton);
        add(resultadoLabel);

        setVisible(true);
    }

    private void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());
            double alturaMetros = altura / 100.0;
            double imc = peso / (alturaMetros * alturaMetros);

            String classificacao;
            if (imc < 18.5) {
                classificacao = "Abaixo do peso";
            } else if (imc < 25) {
                classificacao = "Peso normal";
            } else if (imc < 30) {
                classificacao = "Sobrepeso";
            } else if (imc < 35) {
                classificacao = "Obesidade Grau I";
            } else if (imc < 40) {
                classificacao = "Obesidade Grau II (severa)";
            } else {
                classificacao = "Obesidade Grau III (mórbida)";
            }

            resultadoLabel.setText("IMC: " + String.format("%.2f", imc) + ", Classificação: " + classificacao);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Digite valores válidos para peso e altura.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new IMCCalculator();
            }
        });
    }
}
