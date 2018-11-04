package Vue;
import Modele.*;
import Controlleur.*;
public class VueConsole {

    public static void main(String[] args){
        Movement move = new Movement();
        Grille gri = new Grille();
        gri.initialise(gri.getGrille());
        gri.getGrille()[8][5] = 1;
        gri.affiche(gri.getGrille());
         move.move();
        move.left();
        gri.affiche(gri.getGrille());
    }
}
