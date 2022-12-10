package miniRpgGraphique.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ComponentAdapter;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ComponentEvent; 



public class Fenetre {

	public JFrame window;
	public JPanel mainPanel;
	private JTextArea texte;
	static int TAILLE_X = 1000;
	static int TAILLE_Y = 800;
	
	public Fenetre() {
		window = new JFrame("Jeu RPG");
		window.setLocation(500, 180);
		window.setSize(1000, 800);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setBackground(Color.black);
		TextePrincipal();
		
		window.add(mainPanel);
		


	}
	
	public void TextePrincipal() {
		texte = new JTextArea("Texte d'affichage principal");
		texte.setBackground(Color.white);
		texte.setForeground(Color.black);
		
		texte.setEditable(false);
		texte.setLineWrap(true);
		texte.setFont(new Font("Book Antiqua", Font.PLAIN, 26));
		
		mainPanel.add(texte, BorderLayout.SOUTH);
	}
	
	public static Image redimensionnement(Image srcImg, int w, int h){
	    BufferedImage resizedImg = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
	    Graphics2D g2 = resizedImg.createGraphics();

	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(srcImg, 0, 0, w, h, null);
	    g2.dispose();

	    return resizedImg;
	}

	

	
}
