/**
 * @author Dominik Fiedorcczuk, Adelin Gaithier, Filipp Shatskiy 2TL
 */
package Test;

import Controlleur.*;
import Modele.Grille;
import Vue.*;

public class XSpaceMVC {
	
	/**
	 * Constructeur de la classe XSpaceMVC
	 */
    public XSpaceMVC() {
        Grille griMod = new Grille();

        Vaisseau vaissVueCons = new Vaisseau(griMod);
        Monster monstVueCons = new Monster(griMod);

        XSpaceVueConsole vueCons = new XSpaceVueConsole(griMod, vaissVueCons, monstVueCons);

        vaissVueCons.addView(vueCons);
        monstVueCons.addView(vueCons);


    }

    /**
     * Fonction principale
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
