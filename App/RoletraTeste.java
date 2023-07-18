package App;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;

public class RoletraTeste extends JFrame {

    private JLabel saldoLabel;
    private JLabel resultadoLabel;
    private String iText;
    private Timer timer;
    private int count = 0;
    private int saldo = 1000; // Saldo inicial fictício do jogador

    public RoletraTeste() {
        super("RoletraTeste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        saldoLabel = new JLabel("Saldo: R$ " + saldo);
        add(saldoLabel, BorderLayout.NORTH);

        JPanel roletaPanel = new JPanel();
        roletaPanel.setPreferredSize(new Dimension(300, 300));
        roletaPanel.setLayout(new BorderLayout());
        roletaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));

        resultadoLabel = new JLabel("Gire a roleta!");
        resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultadoLabel.setVerticalAlignment(SwingConstants.CENTER);
        resultadoLabel.setFont(new Font("Arial", Font.BOLD, 24));
        roletaPanel.add(resultadoLabel, BorderLayout.CENTER);

        add(roletaPanel, BorderLayout.CENTER);

        JPanel botoesPanel = new JPanel();
        botoesPanel.setLayout(new GridLayout(1, 3));

        JButton botaoImpar = new JButton("Ímpar");
        JButton botaoZero = new JButton("0");
        JButton botaoPar = new JButton("Par");

        botaoImpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogar(1); // 1 representa a opção "Ímpar"
            }
        });

        botaoZero.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogar(0); // 0 representa a opção "0"
            }
        });

        botaoPar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jogar(2); // 2 representa a opção "Par"
            }
        });

        botoesPanel.add(botaoImpar);
        botoesPanel.add(botaoZero);
        botoesPanel.add(botaoPar);

        add(botoesPanel, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void jogar(int opcao) {
        int valorApostado = 100; // Valor fictício da aposta
        Random random = new Random();
        int resultado = random.nextInt(37); // Gera um número aleatório entre 0 e 36

        // Simulação da animação da roleta girando
        count = 0;
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (count < 36) {
                    count++;
                    Random randoms = new Random();
                    int resultados = random.nextInt(37);
                    resultadoLabel.setText(String.valueOf(resultados));
                } else {
                    ((Timer) e.getSource()).stop();
                    resultadoLabel.setText(String.valueOf(resultado));
                    if (opcao == 0 && resultado == 0) {
                        saldo += valorApostado * 36;
                        JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 36));
                    } else if (opcao == 1 && resultado % 2 == 1 && resultado != 0) {
                        saldo += valorApostado * 2;
                        JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 2));
                    } else if (opcao == 2 && resultado % 2 == 0 && resultado != 0) {
                        saldo += valorApostado * 2;
                        JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 2));
                    } else {
                        saldo -= valorApostado;
                        JOptionPane.showMessageDialog(null, "Você perdeu!");
                    }

                    saldoLabel.setText("Saldo: R$ " + saldo);

                    if (saldo <= 0) {
                        JOptionPane.showMessageDialog(null, "Você ficou sem saldo. O jogo acabou!");
                        System.exit(0);
                    }
                }
            }
        });

        timer.start(); // Inicia o timer para animação da roleta
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new RoletraTeste();
            }
        });
    }
}
