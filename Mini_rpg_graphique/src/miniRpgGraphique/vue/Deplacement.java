package miniRpgGraphique.vue;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import miniRpgGraphique.mobs.Joueur;

public class Deplacement {

	private Fenetre fenetre;
	private Joueur joueur;

	public Deplacement(Fenetre fenetre, Joueur j) {
		this.fenetre = fenetre;
		this.joueur = j;
	}

	public void initBoutonDeplacement() {

		JPanel panelControls = new JPanel();

		panelControls.setLayout(new GridLayout(4, 1));

				
		JLabel arrowUp = new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/arrow-up.png"));
		JLabel arrowDown = new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/arrow-down.png"));
		JLabel arrowRight = new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/arrow-right.png"));
		JLabel arrowLeft = new JLabel(new ImageIcon("/home/firda/Projets_scolaire/INFO/Prog/licence_pro/Mini_rpg_graphique/src/miniRpgGraphique/ressources/arrow-left.png"));
		
		arrowUp.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				joueur.deplacement("1");
			}
		});
		
		arrowRight.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				joueur.deplacement("2");
			}
		});
		
		arrowDown.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				joueur.deplacement("3");
			}
		});
		
		arrowLeft.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent e) {
				joueur.deplacement("4");
			}
		});

		//fenetre.mainPanel.add();
	}

	public void boutonDeplacement() {

	}

}
