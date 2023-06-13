package Hospital;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaInicial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
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
	public TelaInicial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1280, 720);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 255));
		contentPane.setOpaque(false);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\health-removebg-preview.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Seja bem vindo (a)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 50));
		lblNewLabel_1.setForeground(new Color(25, 25, 112));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(25, 25, 112));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(142)
							.addComponent(lblNewLabel_1))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(124)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 424, GroupLayout.PREFERRED_SIZE)))
					.addPreferredGap(ComponentPlacement.RELATED, 204, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 429, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 492, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 96, GroupLayout.PREFERRED_SIZE)
					.addGap(83))
				.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.DEFAULT_SIZE, 681, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(null);
		
		JButton btnNewButton_1_1 = new JButton("Salas");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSalas Sala = new TelaSalas();
				Sala.setVisible(true);
				dispose();
				
						
			}
		});
		btnNewButton_1_1.setBorderPainted(false);
		btnNewButton_1_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1_1.setOpaque(false);
		btnNewButton_1_1.setBounds(87, 157, 298, 30);
		panel.add(btnNewButton_1_1);
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1_1.setBackground(new Color(0, 0, 128));
		
		JButton btnPacientes = new JButton("Pacientes");
		btnPacientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaPacientes tpaci = new TelaPacientes();
				tpaci.setVisible(true);
				dispose();
			}
		});
		btnPacientes.setBorderPainted(false);
		btnPacientes.setForeground(new Color(255, 255, 255));
		btnPacientes.setBounds(87, 226, 298, 30);
		panel.add(btnPacientes);
		btnPacientes.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnPacientes.setBackground(new Color(25, 25, 112));
		
		JButton btnNewButton_1_2 = new JButton("Medicos");
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSeis ts = new TelaSeis();
				ts.setVisible(true);
				dispose();
				
			}
		});
		btnNewButton_1_2.setForeground(new Color(255, 255, 255));
		btnNewButton_1_2.setBorderPainted(false);
		btnNewButton_1_2.setBounds(87, 298, 298, 30);
		panel.add(btnNewButton_1_2);
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1_2.setBackground(new Color(25, 25, 112));
		
		JButton btnNewButton_1_3 = new JButton("Adicionar medico");
		btnNewButton_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdcMedico tam = new TelaAdcMedico();
				tam.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_3.setBorderPainted(false);
		btnNewButton_1_3.setForeground(new Color(255, 255, 255));
		btnNewButton_1_3.setBounds(87, 374, 298, 30);
		panel.add(btnNewButton_1_3);
		btnNewButton_1_3.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1_3.setBackground(new Color(25, 25, 112));
		
		JButton btnNewButton_1_4 = new JButton("Adicionar paciente");
		btnNewButton_1_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAdcPaciente TAP = new TelaAdcPaciente();
				TAP.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1_4.setBorderPainted(false);
		btnNewButton_1_4.setForeground(new Color(255, 255, 255));
		btnNewButton_1_4.setBounds(76, 442, 309, 30);
		panel.add(btnNewButton_1_4);
		btnNewButton_1_4.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton_1_4.setBackground(new Color(25, 25, 112));
		contentPane.setLayout(gl_contentPane);
	}
}
