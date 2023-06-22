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
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Point;
import javax.swing.border.LineBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.UIManager;
import javax.swing.JScrollPane;
import java.awt.Cursor;

public class TelaSeis extends JFrame {

	private JPanel contentPane;
	private JTextField cpftextField;

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
		
		setLocationRelativeTo(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\davi.zanotta\\Pictures\\Saved Pictures\\LogoMini.png"));
		lblNewLabel_1.setBounds(20, 132, 115, 115);
		contentPane.add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(130, 183, 976, 444);
		contentPane.add(scrollPane);
		
		JTextArea areaInfo = new JTextArea();
		scrollPane.setViewportView(areaInfo);
		areaInfo.setBorder(UIManager.getBorder("Tree.editorBorder"));
		areaInfo.setForeground(new Color(255, 255, 255));
		areaInfo.setBackground(new Color(25, 25, 112));
		areaInfo.setFont(new Font("Microsoft JhengHei", Font.BOLD, 25));
		areaInfo.setEditable(false);
		
		JLabel lblMedicos = new JLabel("Medicos");
		lblMedicos.setHorizontalAlignment(SwingConstants.CENTER);
		lblMedicos.setForeground(new Color(25, 25, 112));
		lblMedicos.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblMedicos.setBackground(new Color(25, 25, 112));
		lblMedicos.setBounds(438, 31, 371, 60);
		contentPane.add(lblMedicos);
		
		cpftextField = new JTextField();
		cpftextField.setColumns(10);
		cpftextField.setBounds(443, 113, 354, 45);
		contentPane.add(cpftextField);
		
		JButton btnPesquisa = new JButton("");
		btnPesquisa.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnPesquisa.setSelectedIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (3).png"));
		btnPesquisa.setIcon(new ImageIcon("C:\\Users\\joao.danielski\\Downloads\\MicrosoftTeams-image (3).png"));
		btnPesquisa.setBounds(807, 113, 46, 45);
		contentPane.add(btnPesquisa);
		
		cpftextField.addKeyListener(new KeyListener(){
			
            public void keyPressed(KeyEvent e){

                if(e.getKeyCode() == KeyEvent.VK_ENTER) {

                    btnPesquisa.doClick();

                }

            }

			@Override
			public void keyTyped(KeyEvent e) {
				
			}

			@Override
			public void keyReleased(KeyEvent e) {
				
			}
        });
		
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DatabaseConnection novaConexao = new DatabaseConnection();
				Connection conn = novaConexao.myDatabaseConnection();
				
				
				String cpfMedico = cpftextField.getText();
				MedicoDAO novoMedico = new MedicoDAO();
				try {
					areaInfo.setText("");
					novoMedico.procuraMedicoCPF(conn, cpfMedico, areaInfo);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
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
		btnNewButton_1.setBounds(20, 11, 57, 40);
		contentPane.add(btnNewButton_1);
	}
}