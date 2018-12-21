package Vue;
import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;
import javax.swing.*;
import java.awt.*;
import java.util.Observable;

public class GUI2 extends XSpaceVue{
    /**
     * Variables d instance pour afficher le GUI
     */
    public JFrame frame;
    public JLabel font = new JLabel();
    public JLabel[][] cases = new JLabel[15][10];
    public JPanel gamePanel = new JPanel();
    public GUI2(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
    }

    /**
     * Image pour chaque monstre ainsi que le vide
     * Image pour le vaisseau ainsi que son laser
     */
    private ImageIcon monst1 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\Monster.png");
    private ImageIcon monst2 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\monster2.png");
    private ImageIcon monst3 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Boss\\boss1.png");
    private ImageIcon vide = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\font.png");
    private ImageIcon vaiss = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\SpaceShip\\spaceship2.png");
    private ImageIcon laser = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\SpaceShip\\laser.png");

    /**
     * Creation du GUI
     * Creation d une grille pour tout le GUI
     */
    public void jeu(){
        frame = new JFrame("XSpace");
        frame.setTitle("XSpace");
        frame.setSize(700, 1100);
        for(int i=0; i<cases.length; i++) {
            for(int j=0; j<cases[i].length; j++ ) {
                cases[i][j] = new JLabel();
                cases[i][j].setMaximumSize(new Dimension(60, 60));
                gamePanel.add(cases[i][j]);
            }
        }
    }

    /**
     * Affichage du GUI par rapport a la grille de la console
     * @param cases
     */
    public void affiche(JLabel cases[][]){
        for(int i=0; i<cases.length; i++){
            for(int j=0; j<cases[i].length; j++){
                if(model.getGrille()[i][j] ==model.getVide()){
                    cases[i][j].setIcon(vide);
                }
                if(model.getGrille()[i][j] == model.getVaisseau()){
                    cases[i][j].setIcon(vaiss);
                }
                if(model.getGrille()[i][j] == model.getLaser()){
                    cases[i][j].setIcon(laser);
                }
                if(model.getGrille()[i][j] == model.monst(0)){
                    cases[i][j].setIcon(monst1);
                }
                if(model.getGrille()[i][j] == model.monst(1)){
                    cases[i][j].setIcon(monst2);
                }
                if(model.getGrille()[i][j] == model.monst(2)){
                    cases[i][j].setIcon(monst3);
                }
            }
        }
        frame.getContentPane().add(gamePanel);
        frame.setVisible(true);
    }

    /**
     * On lance le jeu qui est coordonne avec la console
     */
    public void playy(){
        jeu();
        affiche(cases);
        Thread play = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    affiche(cases);
                }
            }
        });play.start();
    }

    public void update(Observable O, Object arg) {
        playy();
    }

}
