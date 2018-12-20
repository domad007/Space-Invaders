package Vue;

import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import java.util.Observable;
import java.util.Observer;

public class XSpaceVueConsole extends XSpaceVue implements Observer {

    /**
     * Heritage sur XSpaceVue
     * On ajoute la fonction play pour lancer le jeu dans le main qui est dans le package test
     * @param model
     * @param controllerVaiss
     * @param controllerMonst
     */
    public XSpaceVueConsole(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
        play();
    }

    /**
     * On fait une mise a jour sur le modele qui est la grille
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg){
       model.getGrille();
    }

    /**
     * On fait une fonction play pour lancer tout le programme
     * Une sorte de main mais sans le main
     */
    public void play() {
         model.initialise(model.getGrille());
        model.getGrille()[14][4] = 1;
        //controllerVaiss.secondPlayer();
        controllerMonst.monsters();
        while(true){
            model.affiche(model.getGrille());
            controllerVaiss.moveVaiss();
            controllerMonst.waves();
            controllerMonst.monsterDown();
            controllerVaiss.points();
            controllerVaiss.attack();
        }
    }
}
