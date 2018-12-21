package Vue;
import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

public class GUI2 extends XSpaceVue{
    /**
     * Variables d instance pour afficher le GUI
     */
    private JFrame frame;
    private JLabel[][] cases = new JLabel[15][10];
    private JPanel gamePanel = new JPanel();
    private JLabel points = new JLabel();


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
    public void gameWindow(){
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
        //points.setText(Integer.toString(controllerVaiss.points()));
        gamePanel.add(points);
    }

    /**
     * Affichage du GUI par rapport a la grille de la console
     * @param cases
     */
    public void displayGame(JLabel cases[][]){
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

    public void move() {
                frame.addKeyListener(new KeyListener() {
                    @Override
                    public void keyTyped(KeyEvent e) {

                    }

                    @Override
                    public void keyPressed(KeyEvent e) {
                        int key = e.getKeyCode();
                        switch (key) {
                            case KeyEvent.VK_Q:
                                controllerVaiss.left();
                                controllerMonst.monsterDown();
                                controllerVaiss.attack();
                                controllerVaiss.points();
                                controllerMonst.waves();
                                model.affiche(model.getGrille());
                                displayGame(cases);
                                break;
                            case KeyEvent.VK_D:
                                controllerVaiss.right();
                                controllerMonst.monsterDown();
                                controllerVaiss.attack();
                                controllerVaiss.points();
                                controllerMonst.waves();
                                model.affiche(model.getGrille());
                                displayGame(cases);
                                break;
                            case KeyEvent.VK_A :
                                controllerVaiss.obLeftSide();
                                controllerMonst.monsterDown();
                                controllerVaiss.attack();
                                controllerVaiss.points();
                                controllerMonst.waves();
                                model.affiche(model.getGrille());
                                displayGame(cases);
                                break;
                            case KeyEvent.VK_E :
                                controllerVaiss.obRightSide();
                                controllerMonst.monsterDown();
                                controllerVaiss.attack();
                                controllerVaiss.points();
                                controllerMonst.waves();
                                model.affiche(model.getGrille());
                                displayGame(cases);
                                break;
                        }
                    }

                    @Override
                    public void keyReleased(KeyEvent e) {
                    }
                });

    }
    /**
     * On lance le jeu qui est coordonne avec la console
     */
    public void playy(){
        gameWindow();
        displayGame(cases);
        move();
    }

    public void update(Observable O, Object arg) {
        playy();
    }

}
