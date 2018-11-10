/**
 * @author Dominik Fiedorcczuk, Adelin Gaithier, Filipp Shatskiy 2TL
 */
package Vue;

import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import java.util.Observable;
import java.util.Observer;

public class XSpaceVueConsole extends XSpaceVue implements Observer {

	/**
	 * Constructeur de la classe XSpaceVueConsole
	 * @param model
	 * @param controllerVaiss
	 * @param controllerMonst
	 */
    public XSpaceVueConsole(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
        play();
    }
    
    	/**
    	 * 
    	 */
    public void update(Observable o, Object arg){
       System.out.println(model.getGrille());

    }

    /**
     * Fonction initialisant le jeu
     */
    public void play() {
        model.initialise(model.getGrille());
        //controllerVaiss.secondPlayer();
        model.getGrille()[9][4] = 1;
        controllerMonst.monsters();
        do {
            model.affiche(model.getGrille());
            controllerVaiss.moveVaiss();
            controllerMonst.monsterDown();
            controllerVaiss.attack();
        }while(true);
    }
}
