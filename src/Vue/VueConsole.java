package Vue;
import Modele.*;
import Controlleur.*;
public class VueConsole {

    public static void main(String[] args){
        Movement move = new Movement();
        Grille gri = new Grille();
        gri.getGrille()[9][4] = 1;

        do {
            gri.affiche(gri.getGrille());
            move.move();
        } while(true);
    }
}
