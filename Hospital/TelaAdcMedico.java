package Hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Cursor;

public class TelaAdcMedico extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	static final String DB_URL = "jdbc:mysql://localhost/arcanjo";
	static final String USER = "root";
	static final String PASS = "root";
	   
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdcMedico frame = new TelaAdcMedico();
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
	public TelaAdcMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel = new JLabel("Adicionar Médico");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBackground(new Color(25, 25, 112));
		lblNewLabel.setBounds(460, 44, 371, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Insira as informações requeridas :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(460, 127, 362, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nome : ");
		lblNewLabel_3.setForeground(new Color(25, 25, 112));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(460, 211, 93, 54);
		contentPane.add(lblNewLabel_3);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(563, 226, 206, 33);
		contentPane.add(textField);
		
		JLabel lblNewLabel_3_1 = new JLabel("Senha : ");
		lblNewLabel_3_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1.setBounds(460, 283, 93, 54);
		contentPane.add(lblNewLabel_3_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(563, 293, 206, 33);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("CPF : ");
		lblNewLabel_3_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1.setBounds(460, 348, 93, 54);
		contentPane.add(lblNewLabel_3_1_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(563, 358, 206, 33);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(563, 418, 206, 33);
		contentPane.add(textField_3);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("CRM :");
		lblNewLabel_3_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1_1.setBounds(460, 413, 93, 54);
		contentPane.add(lblNewLabel_3_1_1_1);
		
		JLabel lblNewLabel_3_1_1_1_1 = new JLabel("Especialidade Medica : ");
		lblNewLabel_3_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_3_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3_1_1_1_1.setBounds(303, 478, 258, 54);
		contentPane.add(lblNewLabel_3_1_1_1_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(563, 493, 206, 33);
		contentPane.add(textField_4);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nomeMedico = textField.getText();
				String senha = textField_1.getText();
				String cpf = textField_2.getText(); 
				String crm = textField_3.getText();
				String especialidade = textField_4.getText();
							
				DatabaseConnection novaConexao = new DatabaseConnection();
				Connection conn = novaConexao.myDatabaseConnection();
				
				MedicoDAO novoMedico = new MedicoDAO();
				
				novoMedico.insereMedico(conn, nomeMedico, senha, cpf, crm, especialidade  );
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
//				// Open a connection
//			      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
//			         Statement stmt = conn.createStatement();
//			      ) {		      
//			         // Execute a query
//			         System.out.println("Inserindo dados em tabela");
////			         insert into estudantes values ("9","Carla","10","5");
//			         
//			         System.out.println("INSERT INTO medicos VALUES ('"+nomeMedico+"', '" + senha + "', '"+ cpf +"', '" + crm + "', '" + especialidade + "')");
//			         String sql = "INSERT INTO medicos VALUES ('"+nomeMedico+"', '" + senha + "', '"+ cpf +"', '" + crm + "', '" + especialidade + "')";
//			         
//			         stmt.executeUpdate(sql);  	  
//			      } catch (SQLException ee) {
//			         ee.printStackTrace();
//			      } 
			      
			      
			}
		});
		
		textField_4.addKeyListener(new KeyListener(){

            public void keyPressed(KeyEvent e){

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                    btnNewButton.doClick();

                }
            }
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
		
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.setBounds(1058, 572, 146, 60);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("<-");
		btnNewButton_1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial TI = new TelaInicial();
				TI.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Pictures\\VOltare.png"));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(10, 11, 57, 40);
		contentPane.add(btnNewButton_1);
	}

}