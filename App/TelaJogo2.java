package App;

import java.awt.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.border.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import java.awt.Font;
import java.awt.GridLayout;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TelaJogo2 extends JFrame {

	private JPanel contentPanee;
	private JLabel lblValor1;
	private JLabel lblValor2;
	private JLabel valorLabel;
	private boolean escolhaDireita;
	private double dinn;
	private JLabel valorLabell;
	private JLabel lblMoneyPlayer;
	private String dinnText;
	private String labelStringWin;
	private String labelStringLose;
	private JButton btnComeçar = new JButton("Começar");
	private JButton btnGirar = new JButton("Girar");
	private JLabel saldoLabel;
	private JLabel resultadoLabel;
	private String iText;
	private Timer timer;
	private int count = 0;
	private int saldo = 1000; // Saldo inicial fictício do jogador
	private JTextField textFieldAposta;
	private double moneyPlayer;
	private Clip reproduzir;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaJogo2(Double din) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPanee = new JPanel();
		contentPanee.setBackground(new Color(30, 34, 45));
		contentPanee.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPanee);
		contentPanee.setLayout(null);
		setBounds(100, 100, 1100, 645);

		JPanel panelGames = new JPanel();
		panelGames.setBounds(0, 381, 1084, 225);
		contentPanee.add(panelGames);
		panelGames.setBackground(new Color(22, 30, 33));
		panelGames.setLayout(null);

		dinn = din;

		JButton btnGame2 = new JButton("Roletra");
		btnGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valorLabell.setVisible(false);
				lblValor1.setVisible(false);
				lblValor2.setVisible(false);
				btnComeçar.setVisible(false);
				btnGirar.setVisible(false);
				TelaJogo telaGame = new TelaJogo(din);
				setVisible(false);
				telaGame.setVisible(true);

			}
		});
		btnGame2.setBounds(436, 35, 221, 179);
		panelGames.add(btnGame2);

		JButton btnGame3 = new JButton("Game3");
		btnGame3.setBounds(822, 35, 221, 179);
		panelGames.add(btnGame3);

		JButton btnGame1 = new JButton("Azar é os guri");
		btnGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJogo(0, 100);
				valorLabell.setVisible(true);
				lblValor1.setVisible(true);
				lblValor2.setVisible(true);
				btnComeçar.setVisible(true);
				btnGirar.setVisible(true);

			}
		});
		btnGame1.setBounds(41, 35, 221, 179);
		panelGames.add(btnGame1);

		// GAME2 {

		JPanel roletaPanel = new JPanel();
		roletaPanel.setPreferredSize(new Dimension(300, 300));
		roletaPanel.setLayout(new BorderLayout());
		roletaPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
		roletaPanel.setBounds(381, 54, 330, 193);

		resultadoLabel = new JLabel("Gire a roleta!");
		resultadoLabel.setMinimumSize(new Dimension(0, 0));
		resultadoLabel.setBackground(new Color(128, 128, 255));
		resultadoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		resultadoLabel.setVerticalAlignment(SwingConstants.CENTER);
		resultadoLabel.setFont(new Font("Arial", Font.BOLD, 24));
		roletaPanel.add(resultadoLabel, BorderLayout.CENTER);

		getContentPane().add(roletaPanel, BorderLayout.CENTER);

		JPanel botoesPanel = new JPanel();
		botoesPanel.setLayout(new GridLayout(1, 3));
		botoesPanel.setBounds(362, 268, 367, 39);

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

		getContentPane().add(botoesPanel, BorderLayout.SOUTH);

		lblMoneyPlayer = new JLabel("00 R$");
		lblMoneyPlayer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMoneyPlayer.setForeground(new Color(255, 255, 255));
		lblMoneyPlayer.setBounds(869, 22, 205, 26);
		getContentPane().add(lblMoneyPlayer);
		moneyPlayer = din;
		String moneyPlayerText = String.format("%.2f", moneyPlayer);
		lblMoneyPlayer.setText(moneyPlayerText + "R$");
		lblMoneyPlayer.setHorizontalAlignment(SwingConstants.CENTER);

		textFieldAposta = new JTextField();
		textFieldAposta.setBounds(502, 319, 86, 39);
		contentPanee.add(textFieldAposta);
		textFieldAposta.setColumns(10);

		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void jogar(int opcao) {
		try {
			String valorText = textFieldAposta.getText();
			double valorApostado = Double.parseDouble(valorText);
			if (moneyPlayer < valorApostado) {
				JOptionPane.showMessageDialog(null, "Ta querendo apostar oque não tem? por isso que é pobre");
			} else {
				String audioRoleta = "C:\\Users\\james\\Desktop\\BlazeSemIronia\\Sons\\somRoleta.wav";
				String audioWin = "C:\\Users\\james\\Desktop\\BlazeSemIronia\\Sons\\ticGanhou.wav";
				String audioLose = "C:\\Users\\james\\Desktop\\BlazeSemIronia\\Sons\\tucPerdeu.wav";
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
							int resultados = randoms.nextInt(37);
							resultadoLabel.setText(String.valueOf(resultados));
							reproduzirAudio(audioRoleta);
						} else {
							((Timer) e.getSource()).stop();
							resultadoLabel.setText(String.valueOf(resultado));
							if (opcao == 0 && resultado == 0) {
								moneyPlayer += valorApostado * 36;
								reproduzirAudio(audioWin);
								JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 36));
							} else if (opcao == 1 && resultado % 2 == 1 && resultado != 0) {
								moneyPlayer += valorApostado * 2;
								reproduzirAudio(audioWin);
								JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 2));
							} else if (opcao == 2 && resultado % 2 == 0 && resultado != 0) {
								moneyPlayer += valorApostado * 2;
								reproduzirAudio(audioWin);
								JOptionPane.showMessageDialog(null, "Você ganhou! Prêmio: R$ " + (valorApostado * 2));
							} else {
								moneyPlayer -= valorApostado;
								reproduzirAudio(audioLose);
								JOptionPane.showMessageDialog(null, "Você perdeu!");								
							}

							String moneyPlayerText = String.format("%.2f", moneyPlayer);
							lblMoneyPlayer.setText(moneyPlayerText + "R$");

							if (saldo <= 0) {
								reproduzirAudio(audioLose);
								JOptionPane.showMessageDialog(null, "Você ficou sem saldo. POBRE FUDIDO!");
								System.exit(0);
							}
						}
					}
				});

				timer.start(); // Inicia o timer para animação da roleta
			}
		} catch (java.lang.NumberFormatException e) {
			JOptionPane.showMessageDialog(null, "Nenhum valor apostado!");
		}

		// GAME2}

		// Game1 :

		valorLabel = new JLabel("0 - 0");
		valorLabel.setBounds(429, 150, 230, 30);
		valorLabel.setHorizontalAlignment(SwingConstants.CENTER);
		valorLabel.setFont(new Font("Arial", Font.BOLD, 20));
		valorLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		valorLabel.setVisible(false);
		getContentPane().add(valorLabel);

		valorLabell = new JLabel("");
		valorLabell.setBounds(408, 191, 269, 59);
		valorLabell.setHorizontalAlignment(SwingConstants.CENTER);
		valorLabell.setFont(new Font("Arial", Font.BOLD, 20));
		valorLabell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
		getContentPane().add(valorLabell);
		valorLabell.setVisible(false);

		JButton btnGame1 = new JButton("Azar é os guri");
		btnGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				iniciarJogo(0, 100);
				valorLabell.setVisible(true);
				lblValor1.setVisible(true);
				lblValor2.setVisible(true);
				btnComeçar.setVisible(true);
				btnGirar.setVisible(true);

			}
		});
		btnGame1.setBounds(41, 35, 221, 179);
		getContentPane().add(btnGame1);

		lblValor1 = new JLabel("00%");
		lblValor1.setBounds(177, 138, 165, 160);
		getContentPane().add(lblValor1);
		lblValor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor1.setForeground(Color.WHITE);
		lblValor1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblValor1.setVisible(false);

		lblValor2 = new JLabel("00%");
		lblValor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor2.setForeground(Color.WHITE);
		lblValor2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblValor2.setBounds(737, 138, 165, 160);
		getContentPane().add(lblValor2);
		lblValor2.setVisible(false);

		btnComeçar.setForeground(new Color(255, 255, 255));
		btnComeçar.setFont(new Font("Tahoma", Font.BOLD, 37));
		btnComeçar.setBorderPainted(false);
		btnComeçar.setContentAreaFilled(false);
		btnComeçar.setFocusPainted(false);
		btnComeçar.setPreferredSize(new Dimension(100, 50));
		btnComeçar.setBounds(446, 275, 198, 47);
		getContentPane().add(btnComeçar);
		btnComeçar.setVisible(false);

		btnComeçar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				calcularResultado();
			}
		});

		btnGirar.setPreferredSize(new Dimension(100, 50));
		btnGirar.setForeground(Color.WHITE);
		btnGirar.setFont(new Font("Tahoma", Font.BOLD, 37));
		btnGirar.setFocusPainted(false);
		btnGirar.setContentAreaFilled(false);
		btnGirar.setBorderPainted(false);
		btnGirar.setBounds(446, 71, 198, 47);
		getContentPane().add(btnGirar);
		btnGirar.setVisible(false);
		btnGirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girarNumeros();
			}
		});

		lblValor1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				escolhaDireita = false;
			}
		});
		lblValor2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				escolhaDireita = true;
			}
		});

		setLocationRelativeTo(null);

	}

	private void iniciarJogo(int min, int max) {
		escolhaDireita = false;
		atualizarValor(min, max);
	}

	private void atualizarValor(int min, int max) {
		min = 0;
		max = 100;
		int valorEsquerda = (int) (Math.random() * (max - min + 1) + min);
		int valorDireita = 100 - valorEsquerda;

		String valorTexto1 = valorDireita + "%";
		String valorTexto2 = valorEsquerda + "%";
		lblValor1.setText(valorTexto2);
		lblValor2.setText(valorTexto1);
		String valorTexto = valorEsquerda + " - " + valorDireita;
		String valorTextor = "Azar é os guri";
		valorLabel.setText(valorTexto);
		valorLabell.setText(valorTextor);
		min = 0;
		max = 0;
	}

	private void girarNumeros() {
		int valorEsquerda = Integer.parseInt(valorLabel.getText().split(" - ")[0]);
		int valorDireita = Integer.parseInt(valorLabel.getText().split(" - ")[1]);

		atualizarValor(valorEsquerda, valorDireita);
	}

	private void calcularResultado() {
		int valorEsquerda = Integer.parseInt(valorLabel.getText().split(" - ")[0]);
		int valorDireita = Integer.parseInt(valorLabel.getText().split(" - ")[1]);

		double probabilidadeDireita = (double) valorDireita / (valorEsquerda + valorDireita);

		if (escolhaDireita) {
			if (Math.random() < probabilidadeDireita) {
				dinn += valorEsquerda; // Aumenta o dinheiro se a escolha for correta
				dinnText = String.format("%.2fR$", dinn);
				lblMoneyPlayer.setText(dinnText);
				labelStringWin = String.format("Venceu! Ganhou  %dR$", valorEsquerda);
				valorLabell.setText(labelStringWin);
			} else {
				dinn -= valorDireita; // Diminui o dinheiro se a escolha for incorreta
				dinnText = String.format("%.2fR$", dinn);
				lblMoneyPlayer.setText(dinnText);
				labelStringLose = String.format("Perdeu	 %dR$", valorDireita);
				valorLabell.setText(labelStringLose);
			}
		} else {
			if (Math.random() < probabilidadeDireita) {
				dinn -= valorEsquerda; // Diminui o dinheiro se a escolha for incorreta
				dinnText = String.format("%.2fR$", dinn);
				lblMoneyPlayer.setText(dinnText);
				labelStringLose = String.format("Perdeu  %dR$", valorEsquerda);
				valorLabell.setText(labelStringLose);
			} else {
				dinn += valorDireita; // Aumenta o dinheiro se a escolha for correta
				dinnText = String.format("%.2fR$", dinn);
				lblMoneyPlayer.setText(dinnText);
				labelStringWin = String.format("Venceu! Ganhou  %dR$", valorDireita);
				valorLabell.setText(labelStringWin);
			}
		}

		System.out.println("Dinheiro: R$" + dinn);
	}

	private void reproduzirAudio(String caminhoArq) {
		try {
			File arquivo = new File(caminhoArq);
			AudioInputStream audioArq = AudioSystem.getAudioInputStream(arquivo);

			if (reproduzir != null && reproduzir.isRunning()) {
				reproduzir.stop();
			}

			reproduzir = AudioSystem.getClip();
			reproduzir.open(audioArq);
			reproduzir.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}
}
