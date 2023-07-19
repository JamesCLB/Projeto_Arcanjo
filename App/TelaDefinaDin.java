package App;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.event.KeyEvent;

public class TelaDefinaDin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private Double moneyPlayer;
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
		
		JButton btnVoltar2 = new JButton("Avançar");
        btnVoltar2.setForeground(new Color(110, 0, 0));
        btnVoltar2.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnVoltar2.setBorderPainted(false);
        btnVoltar2.setContentAreaFilled(false);
        btnVoltar2.setFocusPainted(false);
        btnVoltar2.setPreferredSize(new Dimension(100, 50));
        btnVoltar2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaComoFun2 telaFun2 = new TelaComoFun2();
            	setVisible(false);
            	telaFun2.setVisible(true);
            	telaFun2.setLocationRelativeTo(null);
            }  
        });
		
        ImageIcon imgIconeVoltar = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\setaVoltar.png");
        Image imgVoltar = imgIconeVoltar.getImage().getScaledInstance(77, 77, Image.SCALE_SMOOTH);
        JLabel imgSetaVoltar = new JLabel(new ImageIcon(imgVoltar));
        imgSetaVoltar.setBounds(27, 11, 69, 69);
        contentPane.add(imgSetaVoltar);
        //mouse listener de voltar quando clicar na seta
        imgSetaVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnVoltar2.doClick();
            }
        });
        
		JTextArea textAreaDin = new JTextArea();
		textAreaDin.setBounds(302, 87, 516, 35);
		textAreaDin.setFont(new Font("Arial Black", Font.BOLD, 21));
		textAreaDin.setForeground(new Color(100, 0, 0));
		textAreaDin.setText("Adicione a quantia do seu dinheiro inicial.");        Color backgroundColor = contentPane.getBackground();
        textAreaDin.setBackground(backgroundColor);
        textAreaDin.setEditable(false);
        textAreaDin.setLineWrap(true);
        textAreaDin.setWrapStyleWord(true);
        contentPane.add(textAreaDin);
		
		JTextArea textAreaFic = new JTextArea();
		textAreaFic.setBounds(432, 133, 516, 35);
		textAreaFic.setFont(new Font("Arial Black", Font.PLAIN, 14));
		textAreaFic.setForeground(new Color(100, 0, 0));
		textAreaFic.setText("(Isso é ficção, nada CANONICO)");
        textAreaFic.setBackground(backgroundColor);
        textAreaFic.setEditable(false);
        textAreaFic.setLineWrap(true);
        textAreaFic.setWrapStyleWord(true);
		contentPane.add(textAreaFic);
         		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 21));
		textField.setBounds(442, 278, 228, 56);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setHorizontalAlignment (SwingConstants.CENTER);
		
		JButton btnAvancar = new JButton("Começar");
        btnAvancar.setForeground(new Color(110, 0, 0));
        btnAvancar.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnAvancar.setBorderPainted(false);
        btnAvancar.setContentAreaFilled(false);
        btnAvancar.setFocusPainted(false);
        btnAvancar.setPreferredSize(new Dimension(100, 50));
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
        		String dinText = textField.getText();
            	try {
            		double valorDinheiro = Double.parseDouble(dinText);
            		TelaJogo telaGame = new TelaJogo(valorDinheiro);
                	setVisible(false);
                	telaGame.setVisible(true); 
				} catch (java.lang.NumberFormatException e2) {
					System.out.println("ERRO: Valor de dinheiro insuportavel.");
					System.out.println("ERR:" + e2);
					
				}					
			}
        });
        btnAvancar.setBounds(450, 423, 209, 63);
        contentPane.add(btnAvancar);
        
        textField.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            
            @Override
            public void keyReleased(KeyEvent e) {
            }
            
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    btnAvancar.doClick();
                }
            }
        });
		
		ImageIcon iconeMiles = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\shockedMiles2.png");
		Image imgMiles = iconeMiles.getImage().getScaledInstance(175, 175, Image.SCALE_SMOOTH);
		JLabel lblMiles = new JLabel(new ImageIcon(imgMiles));
		/*
		 * JLabel lblMiles = new JLabel(new ImageIcon(imgMiles)) {
		 * 
		 * @Override protected void paintComponent(Graphics g) {
		 * super.paintComponent(g); Graphics2D g2d = (Graphics2D) g.create(); int width
		 * = imgMiles.getWidth(null); int height = imgMiles.getHeight(null);
		 * AffineTransform transformar = new AffineTransform();
		 * transformar.rotate(Math.toRadians(-45), width / 2, height / 2); // Rotação da
		 * imagem g2d.drawImage(imgMiles, transformar, null); g2d.dispose(); } };
		 */
		lblMiles.setBounds(892, 445, 228, 174); // Posição do componente
		contentPane.add(lblMiles);
		
		JLabel lblR$ = new JLabel("R$");
		lblR$.setForeground(Color.WHITE);
		lblR$.setFont(new Font("Tahoma", Font.BOLD, 34));
		lblR$.setBounds(680, 279, 70, 43);
		contentPane.add(lblR$);
	
	}

}
