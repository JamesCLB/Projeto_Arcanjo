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

public class TelaSalas extends JFrame {
	private final Action action = new SwingAction();

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
		lblNewLabel_1.setBounds(505, 0, 180, 69);
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 40));
		getContentPane().add(lblNewLabel_1);
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_2 = new JLabel("     Salas :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(88, 115, 207, 30);
		getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_5 = new JLabel("Pacientes utilizando a sala :");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(562, 115, 295, 30);
		getContentPane().add(lblNewLabel_5);
		
		JButton btnNewButton = new JButton("<-");
		btnNewButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaInicial TI = new TelaInicial();
				TI.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Pictures\\VOltare.png"));
		btnNewButton.setBounds(10, 11, 57, 40);
		getContentPane().add(btnNewButton);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setForeground(new Color(0, 0, 0));
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5"}));
		comboBox.setToolTipText("");
		comboBox.setBounds(121, 145, 63, 40);
		getContentPane().add(comboBox);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(new Color(25, 25, 112));
		textArea.setSelectedTextColor(new Color(25, 25, 112));
		textArea.setBounds(337, 145, 817, 524);
		getContentPane().add(textArea);
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
