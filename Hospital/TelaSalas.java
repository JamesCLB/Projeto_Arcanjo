package Hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.border.LineBorder;
import java.awt.Cursor;
import javax.swing.JTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Choice;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TelaSalas extends JFrame {
	private final Action action = new SwingAction();
	private Choice choice;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSalas frame = new TelaSalas();
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
	public TelaSalas() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1200, 720);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Salas");
		lblNewLabel_1.setBounds(518, 11, 125, 69);
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		getContentPane().add(lblNewLabel_1);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_5 = new JLabel("Pacientes utilizando a sala :");
		lblNewLabel_5.setBounds(435, 166, 295, 30);
		lblNewLabel_5.setForeground(new Color(25, 25, 112));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		getContentPane().add(lblNewLabel_5);
		
		JTextArea textArea = new JTextArea();
		textArea.setForeground(new Color(255, 255, 255));
		textArea.setFont(new Font("Tahoma", Font.BOLD, 14)); //criando o text area
		
		this.choice = new Choice();
		textArea.setBackground(new Color(25, 25, 112));
		textArea.setBounds(265, 207, 648, 380);
		getContentPane().add(textArea);
		this.choice.add("1");
		this.choice.add("2");
		this.choice.add("3");
		this.choice.add("4");
		this.choice.add("5");

		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setBounds(10, 11, 57, 40);
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial TI = new TelaInicial();
				TI.setVisible(true);
				dispose();
			}
		});
		
		this.choice.setBounds(382, 86, 371, 20);
		getContentPane().add(this.choice);		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String salaSelecionada = choice.getSelectedItem();
				    System.out.println(salaSelecionada);
				    
				    String DB_URL = "jdbc:mysql://localhost/arcanjo";
				    String USER = "root";
				    String PASS = "root";
				    String QUERY = "SELECT p.nome FROM pacientes p "+ 
				    		"JOIN salas s ON p.id_salas = s.id_salas "+
				    		"WHERE s.id_salas = ?;";
				    
				    try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
				         PreparedStatement stmt = conn.prepareStatement(QUERY)) {
				        stmt.setString(1, salaSelecionada);
				        ResultSet rs = stmt.executeQuery();

				        String resultado = "";
				        while (rs.next()) {
				        	resultado = resultado + rs.getString("nome") + "\n";
				        }
				        
				        textArea.setText(resultado);

				    } catch (SQLException ex) {
				        ex.printStackTrace();
				    }
				
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Pictures\\VOltare.png"));
		getContentPane().add(btnNewButton);
		
//		JTextArea pacientestextArea = new JTextArea();
//		pacientesTextArea.setBounds(x, y, 10, altura); // Defina as coordenadas e o tamanho adequados para o componente
//		getContentPane().add(pacientesTextArea);
//		scrollPane.setViewportView(textArea);
//		textArea.setBackground(new Color(25, 25, 112));
//		textArea.setSelectedTextColor(new Color(25, 25, 112));
		
	
		btnPesquisa.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (4).png"));
		btnPesquisa.setBackground(Color.WHITE);
		btnPesquisa.setBounds(776, 75, 46, 45);
		getContentPane().add(btnPesquisa);
		
		
	}
	
	
	


	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}












