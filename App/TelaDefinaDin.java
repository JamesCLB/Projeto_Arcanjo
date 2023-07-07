package App;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class TelaDefinaDin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaDefinaDin frame = new TelaDefinaDin();
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
	public TelaDefinaDin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(22, 30, 33));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);

		JTextArea textAreaFic = new JTextArea();
		textAreaFic.setBounds(275, 78, 574, 22);
		contentPane.add(textAreaFic);
		
		JTextArea textAreaDin = new JTextArea();
		textAreaDin.setBounds(275, 136, 574, 22);
		contentPane.add(textAreaDin);
		
		textField = new JTextField();
		textField.setBounds(476, 274, 174, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(910, 474, 174, 132);
		contentPane.add(lblNewLabel);
		
		
	}
}
