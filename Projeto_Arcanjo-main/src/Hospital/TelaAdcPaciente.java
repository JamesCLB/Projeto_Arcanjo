package Hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.DropMode;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Choice;

public class TelaAdcPaciente extends JFrame {

	protected static final String NovoPaciente = null;
	private JPanel contentPane;
	private JTextField txtNomeCompleto;
	private JTextField txtXxxxxxxx;
	private JTextField txtXxxxxxxxxxx;
	private JTextField txtxxXxxxxxxxx;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField txtMf;
	private JTextField textField_7;
	private JTextField textField_8;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAdcPaciente frame = new TelaAdcPaciente();
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
	public TelaAdcPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 250, 250));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("Adicionar Paciente");
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 45));
		lblNewLabel_1.setBounds(395, 11, 425, 115);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Insira as informações requeridas: ");
		lblNewLabel_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1_1.setBounds(355, 126, 508, 49);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nome completo:");
		lblNewLabel_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1.setBounds(78, 224, 169, 49);
		contentPane.add(lblNewLabel_1_1_1);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setText("\r\n");
		txtNomeCompleto.setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
		txtNomeCompleto.setBackground(new Color(255, 255, 255));
		txtNomeCompleto.setBounds(257, 234, 205, 36);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		txtXxxxxxxx = new JTextField();
		txtXxxxxxxx.setText("xxxx-xx-xx");
		txtXxxxxxxx.setForeground(new Color(0, 0, 0));
		txtXxxxxxxx.setColumns(10);
		txtXxxxxxxx.setBounds(257, 307, 205, 36);
		contentPane.add(txtXxxxxxxx);
		
		txtXxxxxxxxxxx = new JTextField();
		txtXxxxxxxxxxx.setText("xxx.xxx.xxx-xx");
		txtXxxxxxxxxxx.setColumns(10);
		txtXxxxxxxxxxx.setBounds(257, 380, 205, 36);
		contentPane.add(txtXxxxxxxxxxx);
		
		txtxxXxxxxxxxx = new JTextField();
		txtxxXxxxxxxxx.setText("(xx) xxxxx-xxxx");
		txtxxXxxxxxxxx.setColumns(10);
		txtxxXxxxxxxxx.setBounds(257, 453, 205, 36);
		contentPane.add(txtxxXxxxxxxxx);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(257, 525, 205, 36);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(257, 598, 205, 36);
		contentPane.add(textField_5);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Data de nascimento:");
		lblNewLabel_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1.setBounds(33, 297, 214, 49);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("CPF:");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1.setBounds(195, 376, 52, 36);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Numero de telefone:");
		lblNewLabel_1_1_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1.setBounds(33, 453, 214, 36);
		contentPane.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("Contato emergencial:");
		lblNewLabel_1_1_1_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(31, 525, 216, 36);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1_1 = new JLabel("Histórico médico:");
		lblNewLabel_1_1_1_1_1_1_1_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_1_1_1.setBounds(72, 598, 175, 36);
		contentPane.add(lblNewLabel_1_1_1_1_1_1_1_1);
		
		Choice choice = new Choice();
		choice.setBounds(934, 463, 205, 61);
		contentPane.add(choice);
		choice.add("1");
		choice.add("2");
		choice.add("3");
		choice.add("4");
		choice.add("5");
		
		txtMf = new JTextField();
		txtMf.setText("M/F");
		txtMf.setColumns(10);
		txtMf.setBackground(new Color(255, 255, 255));
		txtMf.setBounds(934, 234, 205, 36);
		contentPane.add(txtMf);
		
		textField_7 = new JTextField();
		textField_7.setForeground(Color.BLACK);
		textField_7.setColumns(10);
		textField_7.setBounds(934, 307, 205, 36);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(934, 380, 205, 36);
		contentPane.add(textField_8);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("Sintomas:");
		lblNewLabel_1_1_1_1_1_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_1_2.setBounds(817, 376, 107, 36);
		contentPane.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Peso:");
		lblNewLabel_1_1_1_1_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_1_2.setBounds(862, 297, 62, 49);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_2 = new JLabel("Sexo:");
		lblNewLabel_1_1_1_2.setForeground(new Color(25, 25, 112));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_1_1_1_2.setBounds(862, 224, 62, 49);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		JButton btnNewButton = new JButton("Adicionar");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(25, 25, 112));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NomePaciente = txtNomeCompleto.getText();
				String NascimentoPaciente = txtXxxxxxxx.getText();
				String CpfPaciente = txtXxxxxxxxxxx.getText();
				String NumeroPaciente = txtxxXxxxxxxxx.getText();
				String ContatoPaciente = textField_4.getText();
				String HistoricoPaciente = textField_5.getText();
				String SexoPaciente = txtMf.getText();
				String PesoPaciente = textField_7.getText();
				String SintomasPaciente = textField_8.getText();
				String id_salas =  choice.getSelectedItem();
				
				DatabaseConnection novaConexaoo = new DatabaseConnection();
				Connection connn = novaConexaoo.myDatabaseConnection();
				
				PacientesDAO novoPaciente = new PacientesDAO();
				
				novoPaciente.inserePaciente(connn ,NomePaciente, NascimentoPaciente
						, CpfPaciente , NumeroPaciente , ContatoPaciente,  HistoricoPaciente,  SexoPaciente,  PesoPaciente,  SintomasPaciente, id_salas  );
				try {
					connn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setBorder(new LineBorder(new Color(255, 255, 255), 2, true));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\james.xavier\\Desktop\\Projeto_Integrador-removebg-preview (1)2.png"));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(952, 551, 169, 56);
		contentPane.add(btnNewButton);
		
		textField_8.addKeyListener(new KeyListener(){
            public void keyPressed(KeyEvent e){

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnNewButton.doClick();
                }
            }
            
            @Override
            public void keyTyped(KeyEvent e) {
            	
            }

			@Override
			public void keyReleased(KeyEvent e){
				// TODO Auto-generated method stub
				
			}
        });
		
		
		JButton btnNewButton_1 = new JButton("");
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
		
		JLabel lblNewLabel = new JLabel("Numero da Sala:");
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel.setBounds(744, 451, 169, 32);
		contentPane.add(lblNewLabel);
		
		
	}
}