package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {

    private Grille model;
    private XSpaceVue vue = null;
    private static int life = 3;
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


    public void monsters() {
    	if (Vaisseau.getPts() < 20) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(0);
            }
        }
    	if(Vaisseau.getPts() >= 20){
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(1);
            }
        }
    }
    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == model.monst(0)) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos] = model.getGrille()[i];
                    i = newPos;
                    model.getGrille()[i-1] = model.getGrille()[0];
                    return;
                }
                if (model.getGrille()[i][j] == model.monst(1)) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos] = model.getGrille()[i];
                    i = newPos;
                    model.getGrille()[i-1] = model.getGrille()[0];
                    return;
                }
                else if(model.getGrille()[14][j] ==model.monst(0)){
                    model.getGrille()[13][j] =model.getVide();
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
   /* public void waves() {
    	for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
            	if (Vaisseau.getPts() == 20) {
            		for (int k = 0; k <= numbMons(); k++) {
            			model.getGrille()[1][randomY()] = model.monst(1);
            		}
            	}
            }
    	}
    }*/
    public void addView(XSpaceVue vue){
        this.vue = vue;
    }

}
