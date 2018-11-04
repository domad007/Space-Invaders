package Vue;
import Modele.*;
import Controlleur.*;
public class VueConsole {

    public static void main(String[] args){
        Movement move = new Movement();
        Grille gri = new Grille();
        Monster monst = new Monster();
        gri.initialise(gri.getGrille());
        gri.getGrille()[9][4] = 1;
        monst.generateMonster();

        do {
            gri.affiche(gri.getGrille());
            move.move();
            monst.generateMonster();
            monst.monsterDown();


        } while(true);
    }
}
