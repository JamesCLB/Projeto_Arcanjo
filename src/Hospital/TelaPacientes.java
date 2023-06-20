package Hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import java.awt.Point;

import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class TelaPacientes extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPacientes frame = new TelaPacientes();
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
	public TelaPacientes() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
		
		JLabel lblPacientes = new JLabel("Pacientes");
		lblPacientes.setHorizontalAlignment(SwingConstants.CENTER);
		lblPacientes.setForeground(new Color(25, 25, 112));
		lblPacientes.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblPacientes.setBackground(new Color(25, 25, 112));
		lblPacientes.setBounds(462, 36, 371, 60);
		contentPane.add(lblPacientes);
		
		textField = new JTextField();
		textField.setBounds(464, 135, 354, 45);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JTextArea areaInfo = new JTextArea();
		areaInfo.setBorder(UIManager.getBorder("Tree.editorBorder"));
		areaInfo.setLocation(new Point(130, 215));
		areaInfo.setForeground(new Color(255, 255, 255));
		areaInfo.setBackground(new Color(25, 25, 112));
		areaInfo.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		areaInfo.setBounds(130, 215, 976, 425);
		contentPane.add(areaInfo);
		areaInfo.setEditable(false);
		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.setBackground(new Color(255, 255, 255));
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPesquisa.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (3).png"));
		btnPesquisa.setBounds(828, 135, 46, 45);
		contentPane.add(btnPesquisa);
		
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection novaConexao = new DatabaseConnection();
				Connection conn = novaConexao.myDatabaseConnection();
				
				
				String cpfPaciente = textField.getText();
				PacientesDAO novoPaciente = new PacientesDAO();
				try {
					areaInfo.setText("");
					novoPaciente.procuraPacienteCPF(conn, cpfPaciente, areaInfo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1 = new JButton("<-");
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