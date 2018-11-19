package Vue;
import Modele.*;
import Controlleur.*;

import java.util.Observer;

public abstract class XSpaceVue implements Observer {


    protected Grille model;
    protected Vaisseau controllerVaiss;
    protected Monster controllerMonst;

    XSpaceVue(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        this.model = model;
        this.controllerVaiss = controllerVaiss;
        this.controllerMonst = controllerMonst;
    }


}
