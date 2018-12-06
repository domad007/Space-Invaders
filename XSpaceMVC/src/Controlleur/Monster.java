package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {

    private Grille model;
    private XSpaceVue vue = null;
    private static int life = 3;
    private Random rand = new Random();
    private static int pts = 0;
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


    public void monsters() {
    	if (pts < 20) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = 2;
            }
        }
    }
    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == 2) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos] = model.getGrille()[i];
                    i = newPos;
                    model.getGrille()[i-1] = model.getGrille()[0];
                    return;
                }
                else if(model.getGrille()[14][j] == 2){
                    model.getGrille()[13][j] =0;
                    life -=1;
                    System.out.println("Il vous reste: "+life +" vies");
                }
                else if(life == 0){
                    System.out.println("Vous avez perdu");
                    System.exit(0);
                }
            }
        }
    }
    public void waves() {
    	for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	if (pts >= 20 && model.getGrille()[5][j] == 2) {
            		for (int k = 0; k <= numbMons(); k++) {
            			model.getGrille()[1][randomY()] = 5;
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
