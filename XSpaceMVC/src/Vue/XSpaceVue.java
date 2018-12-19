package Vue;
import Modele.*;
import Controlleur.*;

import java.util.Observer;

public abstract class XSpaceVue implements Observer {

    /**
     * Ajout des 3 classes
     */
    protected Grille model;
    protected Vaisseau controllerVaiss;
    protected Monster controllerMonst;

    /**
     * Ajout des constructeurs
     * @param model
     * @param controllerVaiss
     * @param controllerMonst
     */
    XSpaceVue(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        this.model = model;
        this.controllerVaiss = controllerVaiss;
        this.controllerMonst = controllerMonst;
    }


}
