package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {

    private Grille model;
    private XSpaceVue vue = null;

    private Random rand = new Random();

    public Monster(Grille m){
        model = m;
    }

    public int numbMons(){
        int mons = 3+rand.nextInt(5-3);
        return mons;
    }
    public int randomY(){
        int y = rand.nextInt(10-0);
        return y;
    }

    // affichage des monstres sur des cases aléatoires
    public void monsters() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == 0) {
                    for (int k = 0; k <= numbMons(); k++) {
                        model.getGrille()[0][randomY()] = 2;
                    }
                }
                return;
            }
        }
    }


    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == 2) { //s'il y a des mobs
                    int newPos = i + 1;
                    model.getGrille()[newPos][j] = 2;
                    model.getGrille()[i][j] = 0;
                    return;
                }
                else if(model.getGrille()[9][j] == 2){
                    model.getGrille()[9][j] =0;
                }
            }
        }
    }
    public void waves() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[5][j] == 2) { //si mob present a la ligne 5, generation de nouvx mobs
                    for (int k = 0; k <= numbMons(); k++) {
                        model.getGrille()[0][randomY()] = 2;
                    }
                }
            }
        }
    }
    public void addView(XSpaceVue vue){
        this.vue = vue;
    }

    /*public static void main(String[] args){
        Monster monst = new Monster();
        model gri = new model();
        gri.initialise(gri.getGrille());

        do {
            gri.affiche(gri.getGrille());
            monst.generateMonster();
            monst.monsterDown();
        }while(true);



    }

*/
}
