package App;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class TelaComoFun extends JFrame {
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
                    TelaComoFun frame = new TelaComoFun();
                    frame.setVisible(true);
                    frame.setLocationRelativeTo(null);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public TelaComoFun() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1100, 645);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(22, 30, 33));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        //textArea do texto de boas vindas
        JTextArea txtrBemvindoAoMaravilhoso = new JTextArea();
        txtrBemvindoAoMaravilhoso.setFont(new Font("Arial Black", Font.BOLD | Font.ITALIC, 21));
        txtrBemvindoAoMaravilhoso.setForeground(new Color(255, 255, 255));
        txtrBemvindoAoMaravilhoso.setText("Bem-vindo ao maravilhoso mundo da Blaze, o site de apostas que vai deixar você pobre enquanto enche os bolsos dos influencers! Prepare-se para embarcar em uma jornada emocionante de perder dinheiro e ver aqueles que já têm de sobra lucrando às suas custas. Mas não se preocupe, porque, afinal de contas, a lei é apenas uma sugestão para nós.\r\n\r\n\r\nNa Blaze, temos tudo planejado para que você aposte e perca cada centavo que tem. Nossos algoritmos avançados são programados para garantir que suas chances de ganhar caso siga nosso plano sejam praticamente nulas. Afinal, quem precisa de esperança quando se tem a certeza de que vai perder tudo?KKKKKK");
        txtrBemvindoAoMaravilhoso.setBounds(66, 115, 982, 378);
        Color backgroundColor = contentPane.getBackground();
        txtrBemvindoAoMaravilhoso.setBackground(backgroundColor);
        txtrBemvindoAoMaravilhoso.setEditable(false);
        txtrBemvindoAoMaravilhoso.setLineWrap(true);
        txtrBemvindoAoMaravilhoso.setWrapStyleWord(true);
        contentPane.add(txtrBemvindoAoMaravilhoso);

        //botão de avancar
        JButton btnAvancar = new JButton("Avançar");
        btnAvancar.setForeground(new Color(110, 0, 0));
        btnAvancar.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnAvancar.setBorderPainted(false);
        btnAvancar.setContentAreaFilled(false);
        btnAvancar.setFocusPainted(false);
        btnAvancar.setPreferredSize(new Dimension(100, 50));
        btnAvancar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaComoFun2 telaFun2 = new TelaComoFun2();
            	setVisible(false);
				telaFun2.setVisible(true); 
				if(reproduzir != null && reproduzir.isRunning()) {
					reproduzir.stop();
				}
            }  
        });
        btnAvancar.setBounds(377, 519, 228, 63);
        contentPane.add(btnAvancar);
        
        //icone da seta
        ImageIcon imgIcone = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\imgSetaa.png");
        Image img = imgIcone.getImage().getScaledInstance(77, 77, Image.SCALE_SMOOTH);
        JLabel imgSeta = new JLabel(new ImageIcon(img));
        imgSeta.setBounds(577, 519, 69, 69);
        contentPane.add(imgSeta);
        
        //função de acionar o botão quando clicar no icone da seta
        imgSeta.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                btnAvancar.doClick();
            }
        });
        
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
        
        //botão voltar
        JButton btnVoltar = new JButton("Avançar");
        btnVoltar.setForeground(new Color(110, 0, 0));
        btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 37));
        btnVoltar.setBorderPainted(false);
        btnVoltar.setContentAreaFilled(false);
        btnVoltar.setFocusPainted(false);
        btnVoltar.setPreferredSize(new Dimension(100, 50));
        btnVoltar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	TelaInicial telaini = new TelaInicial();
            	setVisible(false);
				telaini.setVisible(true);
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
//FUNÇÕES
    //função de reprodução de audio WAV junto com a parada forçada do audio em reprodução
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
}}
