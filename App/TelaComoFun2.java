package App;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TelaComoFun2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaComoFun2 frame = new TelaComoFun2();
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
	public TelaComoFun2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1100, 645);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(22, 30, 33));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setLocationRelativeTo(null);
		
		JTextArea txtrBemvindoAoMaravilhoso = new JTextArea();
        txtrBemvindoAoMaravilhoso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 21));
        txtrBemvindoAoMaravilhoso.setForeground(new Color(255, 255, 255));
        txtrBemvindoAoMaravilhoso.setText("E não se preocupe com as regulamentações e leis chatas que visam proteger os jogadores. Somos mestres em burlar qualquer obstáculo que nos impeça de explorar aqueles que estão desesperados por um golpe de sorte. \r\n\r\nEntão, não perca tempo! Venha fazer parte da família Blaze, onde os pobres ficam mais pobres e os influencers ficam mais ricos. Se você gosta de se sentir explorado, enganado e totalmente sem esperança, então você encontrou o lugar certo. Junte-se a nós e descubra como desperdiçar seu dinheiro nunca foi tão divertido!");
        txtrBemvindoAoMaravilhoso.setBounds(66, 115, 982, 378);
        Color backgroundColor = contentPane.getBackground();
        txtrBemvindoAoMaravilhoso.setBackground(backgroundColor);
        txtrBemvindoAoMaravilhoso.setEditable(false);
        txtrBemvindoAoMaravilhoso.setLineWrap(true);
        txtrBemvindoAoMaravilhoso.setWrapStyleWord(true);
        contentPane.add(txtrBemvindoAoMaravilhoso);

        JButton btnAvancar = new JButton("Avançar");
        btnAvancar.setForeground(new Color(110, 0, 0));
        btnAvancar.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnAvancar.setBorderPainted(false);
        btnAvancar.setContentAreaFilled(false);
        btnAvancar.setFocusPainted(false);
        btnAvancar.setPreferredSize(new Dimension(100, 50));
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaDefinaDin telaDin = new TelaDefinaDin();
            	setVisible(false);
				telaDin.setVisible(true);            }
        });
        btnAvancar.setBounds(377, 519, 228, 63);
        contentPane.add(btnAvancar);

        ImageIcon imgIcone = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\imgSetaa.png");
        Image img = imgIcone.getImage().getScaledInstance(77, 77, Image.SCALE_SMOOTH);
        JLabel imgSeta = new JLabel(new ImageIcon(img));
        imgSeta.setBounds(574, 519, 69, 69);
        contentPane.add(imgSeta);
        imgSeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAvancar.doClick();
            }
        });
	}

}
