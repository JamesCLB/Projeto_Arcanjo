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
import java.awt.event.ActionEvent;

public class TelaSeis extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSeis frame = new TelaSeis();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 */
	public TelaSeis() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\davi.zanotta\\Pictures\\Saved Pictures\\LogoMini.png"));
		lblNewLabel_1.setBounds(20, 132, 115, 115);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicos.setForeground(new Color(25, 25, 112));
		lblMedicos.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMedicos.setBackground(new Color(25, 25, 112));
		lblMedicos.setBounds(438, 31, 371, 60);
		contentPane.add(lblMedicos);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(443, 113, 354, 45);
		contentPane.add(textField);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setSelectedIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (3).png"));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (3).png"));
		btnNewButton.setBounds(807, 113, 46, 45);
		contentPane.add(btnNewButton);
		
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
		btnNewButton_1.setBounds(20, 11, 57, 40);
		contentPane.add(btnNewButton_1);
	}

}