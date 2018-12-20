package Vue;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;

public class GUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 812, 509);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton soloBtn = new JButton("Solo");
		soloBtn.setForeground(new Color(51, 51, 255));
		soloBtn.setBackground(new Color(51, 51, 255));
		soloBtn.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\X-Space-master\\GUI\\Ecran D'accueil\\Calque 2.png"));
		soloBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		soloBtn.setBounds(258, 241, 287, 98);
		frame.getContentPane().add(soloBtn);
		
		JButton multiBtn = new JButton("Multi");
		multiBtn.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\X-Space-master\\GUI\\Ecran D'accueil\\Calque 3.png"));
		multiBtn.setBounds(229, 361, 316, 98);
		frame.getContentPane().add(multiBtn);
		
		JButton paramBtn = new JButton("param");
		paramBtn.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\X-Space-master\\GUI\\Ecran D'accueil\\Calque 4.png"));
		paramBtn.setBounds(743, 0, 53, 52);
		frame.getContentPane().add(paramBtn);
		
		JLabel lblBackground = new JLabel("background");
		lblBackground.setIcon(new ImageIcon("C:\\Users\\user\\Downloads\\X-Space-master\\GUI\\Ecran D'accueil\\Calque 1.png"));
		lblBackground.setBounds(0, -109, 1248, 700);
		frame.getContentPane().add(lblBackground);
		
		}
	}

