package Vue;
import Modele.*;
import Controlleur.*;

import java.util.Scanner;
public class VueConsole {

    /*
        Affichage de la grille ainsi que le X de départ
    */

    public static void main(String[] args){
        Grille gri = new Grille();
        Movement move = new Movement();

        gri.initialise(gri.getGrille());
        gri.getGrille()[9][4] = 1;
        /*
            On fait un do while pour que le programme ne s'arrête plus et qu'on peut bouger dans tous les sens
         */
        do {

            gri.affiche(gri.getGrille());
            move.move();

        }
        while(true);
    }
}
