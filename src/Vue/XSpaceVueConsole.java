package Vue;

import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import java.util.Observable;
import java.util.Observer;

public class XSpaceVueConsole extends XSpaceVue implements Observer {


    public XSpaceVueConsole(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
        play();
    }
    
    //update la grille à chaque mouvement
    public void update(Observable o, Object arg){
       System.out.println(model.getGrille());

    }

    public void play() {
        model.initialise(model.getGrille());
        controllerVaiss.secondPlayer();
        model.getGrille()[9][4] = 1;
        controllerMonst.monsters();
        do {
            model.affiche(model.getGrille());
            controllerVaiss.moveVaiss();
            controllerVaiss.lifes();
            controllerMonst.monsterDown();
            controllerVaiss.attack();
        }while(true);
    }
}
