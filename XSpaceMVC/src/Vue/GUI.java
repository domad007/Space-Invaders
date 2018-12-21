package Vue;

import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

public class GUI extends XSpaceVue{
	/**
	 * Variable d instance pour afficher le GUI
	 */
	private JFrame frame;
	/**
	 * On mets des constructeurs veneant du XSpaceVue
	 * Elle permet au controlleur et au modele de suivre ce qui ce passe dans le GUI
	 */
	public GUI(Grille model, Vaisseau controllerVaiss, Monster controllerMonst) {
		super(model, controllerVaiss, controllerMonst);
		initialize();
	}

	/**
	 * Le menu du GUI se trouve ici
	 * On reprend la classe GUI2 qui va servir du jeu
	 * On peut jouer en multijoueur avec des sockets
	 * On as la possibilite de quitter le jeu
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton soloBtn = new JButton("Solo");
		soloBtn.setForeground(new Color(51, 51, 255));
		soloBtn.setBackground(new Color(51, 51, 255));
		soloBtn.setIcon(new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Acceuil\\solo.png"));
		soloBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		///////////////
				new GUI2(model,controllerVaiss,controllerMonst).playy(); //Sur ce boutton la on affiche le jeu
			}
		});
		soloBtn.setBounds(275, 246, 249, 86);
		frame.getContentPane().add(soloBtn);
		
		JButton multiBtn = new JButton("Multi");
		multiBtn.setIcon(new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Acceuil\\multi.png"));
		multiBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		/////////////
																//Activation du socket sur ce boutton ci et lancement du jeu a 2
			}
		});
		multiBtn.setBounds(275, 377, 256, 65);
		frame.getContentPane().add(multiBtn);
		
		JButton paramBtn = new JButton("param");
		paramBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	////////////////
			}												//On peut quitter le jeu ici
		});
		paramBtn.setIcon(new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Acceuil\\param.png"));
		paramBtn.setBounds(757, 0, 39, 44);
		frame.getContentPane().add(paramBtn);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Acceuil\\acceuil.png"));
		lblBackground.setBounds(0, -109, 1248, 700);
		frame.getContentPane().add(lblBackground);

		frame.setVisible(true);
		
		}
		public void update(Observable arg0, Object arg1) {
			initialize();
		}

	}

