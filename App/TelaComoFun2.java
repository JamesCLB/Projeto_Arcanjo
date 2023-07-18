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
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TelaComoFun2 extends JFrame {

	private JPanel contentPane;
    private Clip reproduzir;
    private ImageIcon iconMutado;
    private ImageIcon iconNaoMutado;
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

        //botão burro
        JButton btnLer = new JButton("Sou burro e não sei ler");
        btnLer.setForeground(new Color(110, 0, 0));
        btnLer.setFont(new Font("Microsoft Tai Le", Font.BOLD, 16));
        btnLer.setBorderPainted(false);
        btnLer.setContentAreaFilled(false);
        btnLer.setFocusPainted(false);
        btnLer.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		reproduzirAudio("C:\\Users\\james\\Desktop\\BlazeSemIronia\\Sons\\4ea7b727-9a62-4866-bd5a-0ac6700a03c1-byVC.wav"); //aciona a função reproduzir audio
        	}
        });
        btnLer.setBounds(823, 24, 204, 33);
        contentPane.add(btnLer);
        //icone som
        
        iconNaoMutado = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\imgSom.png");
		iconMutado = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\Mutado.png");

		Image imgSom = iconNaoMutado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		ImageIcon imgSomRedimensionado = new ImageIcon(imgSom);
		
		iconNaoMutado = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\imgSom.png");
		iconMutado = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\Mutado.png");
		
		Image imgSomNaoMutado = iconNaoMutado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		Image imgSomMutado = iconMutado.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH);
		
		ImageIcon iconSomNaoMutadoRedimensionado = new ImageIcon(imgSomNaoMutado);
		ImageIcon iconSomMutadoRedimensionado = new ImageIcon(imgSomMutado);
		
		JLabel labelSom = new JLabel(iconSomNaoMutadoRedimensionado);
		labelSom.setBounds(1024, 24, 30, 33);
		contentPane.add(labelSom);
		
        //mutar Burro
        
        labelSom.addMouseListener(new MouseAdapter() {
            private boolean somMutado = false;
            public void mouseClicked(MouseEvent e) {
    		    
            	if (somMutado) {
		            labelSom.setIcon(iconSomNaoMutadoRedimensionado);
		            reproduzir.start();
		            somMutado = false;
		        } else {
		            labelSom.setIcon(iconSomMutadoRedimensionado);
		            reproduzir.stop();
		            somMutado = true;
		        }
            }
            
        });
        
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
				telaDin.setVisible(true);            
			}
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
        JButton btnVoltar = new JButton("Avançar");
        btnVoltar.setForeground(new Color(110, 0, 0));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setPreferredSize(new Dimension(100, 50));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaComoFun telaFun2 = new TelaComoFun();
            	setVisible(false);
            	telaFun2.setVisible(true);
            	telaFun2.setLocationRelativeTo(null);
            }  
        });
        //icone da setaVoltar
        ImageIcon imgIconeVoltar = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\setaVoltar.png");
        Image imgVoltar = imgIconeVoltar.getImage().getScaledInstance(77, 77, Image.SCALE_SMOOTH);
        JLabel imgSetaVoltar = new JLabel(new ImageIcon(imgVoltar));
        imgSetaVoltar.setBounds(27, 11, 69, 69);
        contentPane.add(imgSetaVoltar);
        //mouse listener de voltar quando clicar na seta
        imgSetaVoltar.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnVoltar.doClick();
            }
        });
	}
	private void reproduzirAudio(String caminhoArq) {
		try {
			File arquivo = new File(caminhoArq);
			AudioInputStream audioArq = AudioSystem.getAudioInputStream(arquivo);
			
			if(reproduzir != null && reproduzir.isRunning()) {
				reproduzir.stop();
			}
			
			reproduzir = AudioSystem.getClip();
			reproduzir.open(audioArq);
			reproduzir.start();
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
		}
	}    
}
