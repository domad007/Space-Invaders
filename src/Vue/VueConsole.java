package Vue;
import Modele.*;
import Controlleur.*;
public class VueConsole {

    public static void main(String[] args){
        Vaisseau vaiss = new Vaisseau();
        Grille gri = new Grille();
        Monster monst = new Monster();
        gri.initialise(gri.getGrille());
        gri.getGrille()[9][4] = 1;
        monst.generateMonster();

        do {
            gri.affiche(gri.getGrille());
            vaiss.move();
            monst.monsterDown();


        } while(true);
    }
}
