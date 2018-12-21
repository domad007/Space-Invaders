package Test;

import Controlleur.*;
import Modele.Grille;
import Vue.*;

import java.util.Observable;

public class XSpaceMVC {
    /**
     * On cree des objets pour s en servir dans le gui ainsi que dans la console
     * On ajoute la vue des controleurs sur le GUI et la console pour ensuite la modifier dans le Modele
     */
    public XSpaceMVC() {

        Grille griMod = new Grille();
        Vaisseau vaissVueCons = new Vaisseau(griMod);
        Monster monstVueCons = new Monster(griMod);

        GUI gui = new GUI(griMod,vaissVueCons, monstVueCons);
        vaissVueCons.addView(gui);
        monstVueCons.addView(gui);

        XSpaceVueConsole vueCons = new XSpaceVueConsole(griMod, vaissVueCons, monstVueCons);
        vaissVueCons.addView(vueCons);
        monstVueCons.addView(vueCons);

    }

    /**
     * On lance tout le jeu
     * Ca lance la console et le GUI qui sont coordonnes
     * @param args
     */
    public static void main(String[] args){
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
              new XSpaceMVC();
            }
        });
        thread.start();
    }
}
