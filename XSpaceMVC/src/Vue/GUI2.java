package Vue;
import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.util.Observable;

public class GUI2 extends XSpaceVue{
    public JFrame frame;
   public JLabel game;

    public GUI2(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
    }

    private ImageIcon monst1 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\Monster.png");
    private ImageIcon monst2 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\monster2.png");
    private ImageIcon monst3 = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Monster\\monster3.png");
    private ImageIcon vaiss = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\SpaceShip\\spaceship2.png");
    private ImageIcon img = new ImageIcon("C:\\Users\\DOMINIK-PC\\Downloads\\GUI\\Background\\background.png");
    public void solo() {
        frame = new JFrame("XSpace");
        game = new JLabel(img);
        frame.add(game);
        frame.pack();
        frame.setVisible(true);

    }

    public void jeu(){
        /*for(int i = 0; i< ;i++ ){
            for(int j =0; j<img.getIconWidth(); j++){

            }
        }*/
    }
    public void update(Observable O, Object arg) {
    }

}
