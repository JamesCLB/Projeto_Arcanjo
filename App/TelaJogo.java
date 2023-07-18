package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import javax.swing.border.*;
import javax.swing.JFrame;
import javax.swing.border.*;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;

public class TelaJogo extends JFrame {

	private JPanel contentPane;
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
	private JLabel lblAwdawdwda = new JLabel("Escolha o jogo esportivo");

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
	public TelaJogo(Double din) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(30, 34, 45));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelGames = new JPanel();
		panelGames.setBounds(0, 381, 1084, 225);
		contentPane.add(panelGames);
		panelGames.setBackground(new Color(22, 30, 33));
		panelGames.setLayout(null);
		
		dinn = din;
		
		
		JButton btnGame2 = new JButton("Azar é os guri");
		btnGame2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAwdawdwda.setVisible(false);
				valorLabell.setVisible(false);
				lblValor1.setVisible(false);
				lblValor2.setVisible(false);
				btnComeçar.setVisible(false);
				btnGirar.setVisible(false);
				
				
			}
		});
		btnGame2.setBounds(436, 35, 221, 179);
		panelGames.add(btnGame2);
		
		JButton btnGame3 = new JButton("Game3");
		btnGame3.setBounds(822, 35, 221, 179);
		panelGames.add(btnGame3);
		
		lblMoneyPlayer = new JLabel("00 R$");
		lblMoneyPlayer.setFont(new Font("Tahoma", Font.BOLD, 17));
		lblMoneyPlayer.setForeground(new Color(255, 255, 255));
		lblMoneyPlayer.setBounds(869, 22, 205, 26);
		contentPane.add(lblMoneyPlayer);
		double moneyPlayer = din;
		String moneyPlayerText = String.format("%.2f", moneyPlayer);
		lblMoneyPlayer.setText(moneyPlayerText + "R$");
		lblMoneyPlayer.setHorizontalAlignment(SwingConstants.CENTER);
		
		   
        //Game1 :
        

		valorLabel = new JLabel("0 - 0");
        valorLabel.setBounds(429, 150, 230, 30);
        valorLabel.setHorizontalAlignment(SwingConstants.CENTER);
        valorLabel.setFont(new Font("Arial", Font.BOLD, 20));
        valorLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        valorLabel.setVisible(false);
        contentPane.add(valorLabel);
        
        
        valorLabell = new JLabel("");
        valorLabell.setBounds(408, 191, 269, 59);
        valorLabell.setHorizontalAlignment(SwingConstants.CENTER);
        valorLabell.setFont(new Font("Arial", Font.BOLD, 20));
        valorLabell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        contentPane.add(valorLabell);
        valorLabell.setVisible(false);
		
		
		lblAwdawdwda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAwdawdwda.setForeground(Color.WHITE);
		lblAwdawdwda.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblAwdawdwda.setBounds(296, 138, 497, 160);
		contentPane.add(lblAwdawdwda);
		
		JButton btnGame1 = new JButton("Azar é os guri");
		btnGame1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblAwdawdwda.setVisible(false);
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
		
		lblValor1 = new JLabel("00%");
		lblValor1.setBounds(177, 138, 165, 160);
		contentPane.add(lblValor1);
		lblValor1.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor1.setForeground(Color.WHITE);
		lblValor1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblValor1.setVisible(false);
		
		lblValor2 = new JLabel("00%");
		lblValor2.setHorizontalAlignment(SwingConstants.CENTER);
		lblValor2.setForeground(Color.WHITE);
		lblValor2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblValor2.setBounds(737, 138, 165, 160);
		contentPane.add(lblValor2);
		lblValor2.setVisible(false);
		
		btnComeçar.setForeground(new Color(255, 255, 255));
		btnComeçar.setFont(new Font("Tahoma", Font.BOLD, 37));
		btnComeçar.setBorderPainted(false);
		btnComeçar.setContentAreaFilled(false);
		btnComeçar.setFocusPainted(false);
		btnComeçar.setPreferredSize(new Dimension(100, 50));
		btnComeçar.setBounds(446, 275, 198, 47);
		contentPane.add(btnComeçar);
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
		contentPane.add(btnGirar);
		btnGirar.setVisible(false);
		btnGirar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				girarNumeros();
			}
		});
		
		/*
		  DropShadowBorder shadow = new DropShadowBorder();
		  shadow.setShadowColor(Color.BLACK); shadow.setShowLeftShadow(true);
		  shadow.setShowRightShadow(true); shadow.setShowBottomShadow(true);
		  shadow.setShowTopShadow(true); this.setBorder(shadow);
		 */
		
		
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
            	dinn -=	valorEsquerda; // Diminui o dinheiro se a escolha for incorreta
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
}
