package App;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Container;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import java.awt.event.ActionListener;

import java.awt.event.ActionEvent;
import javax.swing.Timer;
import javax.swing.border.LineBorder;

public class TelaInicial {
	private ImageIcon iconMutado;
    private ImageIcon iconNaoMutado;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial window = new TelaInicial();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws LineUnavailableException
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 */
	public TelaInicial() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws IOException
	 * @throws UnsupportedAudioFileException
	 * @throws LineUnavailableException
	 */
	private void initialize() throws UnsupportedAudioFileException, IOException, LineUnavailableException {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(22, 30, 33));
		frame.setBounds(100, 100, 1100, 645);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		// acionar musiquinha
		Clip reproduzir;
		File arquivo = new File("C:\\Users\\james\\Desktop\\BlazeSemIronia\\Sons\\David Luong - Memoir Of Summer.wav");
		AudioInputStream audioArq = AudioSystem.getAudioInputStream(arquivo);
		reproduzir = AudioSystem.getClip();
		reproduzir.open(audioArq);
		// diminuir o som da musiquinha
		float volume = 0.3f;
		FloatControl obterControleMusica = (FloatControl) reproduzir.getControl(FloatControl.Type.MASTER_GAIN);
		float dB = (float) (Math.log(volume) / Math.log(10.0) * 20.0);
		obterControleMusica.setValue(dB);
		reproduzir.start();
		reproduzir.loop(Clip.LOOP_CONTINUOUSLY);

		JLabel blazeText = new JLabel("Blaze");
		blazeText.setForeground(Color.WHITE);
		blazeText.setFont(new Font("Tahoma", Font.BOLD, 55));
		blazeText.setBounds(446, 27, 203, 109);
		blazeText.setHorizontalAlignment(SwingConstants.CENTER);
		frame.getContentPane().add(blazeText);

		JButton comoFun = new JButton("Como funciona");
		comoFun.setForeground(new Color(110, 0, 0));
		comoFun.setFont(new Font("Tahoma", Font.BOLD, 28));
		comoFun.setBorderPainted(false);
		comoFun.setContentAreaFilled(false);
		comoFun.setFocusPainted(false);
		comoFun.setPreferredSize(new Dimension(100, 50));
		comoFun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaComoFun telaFun = new TelaComoFun();
				frame.setVisible(false);
				telaFun.setVisible(true);
				telaFun.setBounds(100, 100, 1100, 645);
				telaFun.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				telaFun.getContentPane().setLayout(null);
				telaFun.setLocationRelativeTo(null);
			}
		});
		comoFun.setBounds(357, 249, 381, 55);
		frame.getContentPane().add(comoFun);
		
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
		labelSom.setBounds(1036, 562, 38, 33);
		frame.getContentPane().add(labelSom);

				
		JButton btnMutar = new JButton();
		btnMutar.setOpaque(false);
		btnMutar.setContentAreaFilled(false);
		btnMutar.setBorderPainted(false);		
		btnMutar.addActionListener(new ActionListener() {
		    private boolean somMutado = false;

		    public void actionPerformed(ActionEvent e) {
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

		btnMutar.setBounds(1036, 560, 38, 35);
		btnMutar.setVisible(true);
		frame.getContentPane().add(btnMutar);
		
		
		ImageIcon wallIcone = new ImageIcon("C:\\Users\\james\\Desktop\\BlazeSemIronia\\CaminhosImagens\\Design sem nome (7).png");
		JLabel wallpaper = new JLabel("");
		wallpaper.setBounds(0, 0, 1084, 606);
		frame.getContentPane().add(wallpaper);
	}
}
