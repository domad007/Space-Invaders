package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {
    /**
     * Variables d instance
     */
    private Grille model;
    private Random rand = new Random();
    public Monster(Grille m){
        model = m;
    }
    /**
     * Generation d un nombre random de monstres
     * Generation entre 3 et 5 monstres
     * @return le nombre de monstres random
     */
    public int numbMons(){
        int mons = 3+rand.nextInt(5-3);
        return mons;
    }

    /**
     * Generation d une positions random sur l axe Y de la grille
     * Generation d une position random sur toute la longueur de l axe Y
     * @return la position
     */
    public int randomY(){
        int y = rand.nextInt(10-0);
        return y;
    }

    /**
     * Generation d un nombre random des monstres sur l axe Y
     * Chaque monstre se genere avec une position random sur l axe Y
     */
    public void monsters() {
        if (Vaisseau.getPts() < 20) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(0);
            }
        }
    }
    /**
     * On parcours le tableau
     * si un des monstres est present, on lui assigne la nouvelle position qui est [position+1] vers le bas
     * 
     */
    public void monsterDown(){
        Thread moveEnn = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
                    for (int j = 0; j < 10; j++) {
                        int newPos = i + 1;
                        if (model.getGrille()[i][j] == model.monst(0)) { //s'il y a un monstre
                            model.getGrille()[newPos][j] = model.monst(0);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                        if (model.getGrille()[i][j] == model.monst(1)) { //s'il y a un monstre
                            model.getGrille()[newPos][j] = model.monst(1);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                        if (model.getGrille()[i][j] == model.monst(2)) { //s'il y a un monstre
                            model.getGrille()[newPos][j] = model.monst(2);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                        if (model.getGrille()[i][j] == model.monst(3)) { //s'il y a un monstre
                            model.getGrille()[newPos][j] = model.monst(3);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                        if (model.getGrille()[i][j] == model.monst(4)) { //s'il y a un monstre
                            model.getGrille()[newPos][j] = model.monst(4);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                    }
                }
            }
        }); moveEnn.start();

        /*for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == model.monst(0)) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos][j] = model.monst(0);
                    model.getGrille()[i][j] = model.getVide();
                    return;
                }
                if (model.getGrille()[i][j] == model.monst(1)) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos][j] = model.monst(1);
                    model.getGrille()[i][j] = model.getVide();
                    return;
                }*/
                /*if (model.getGrille()[i][j] == model.monst(1)) { //s'il y a un monstre
                    int newPo = i + 1;
                    model.getGrille()[newPo] = model.getGrille()[i];
                    i = newPo;
                    model.getGrille()[i - 1] = model.getGrille()[0];
                    return;
                }
                if (model.getGrille()[i][j] == model.monst(0)) { //s'il y a un monstre
                    int newPos = i + 1;
                    model.getGrille()[newPos] = model.getGrille()[i];
                    //i = newPos;
                    model.getGrille()[i] = model.getGrille()[i-1];
                    return;
                }*/
                /*if (model.getGrille()[i][j] == model.monst(1)) { //s'il y a un monstre
                    int newPo = i + 1;
                    model.getGrille()[newPo] = model.getGrille()[i];
                    i = newPo;
                    model.getGrille()[i - 1] = model.getGrille()[0];
                    return;
                }*/
    }

    /**
     * Generation des vagues sur l axe Y de maniere random
     * 20 points gagnes =  la 2e vague commence
     * 70 points gagnes =  la 3e vague commence
     * 100 points gagnes =  la 4e vague commence
     * 150 points gagnes =  le Boss commence
     */
    public void waves(){
        if (Vaisseau.getPts() == 20) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(1);
            }
        }
        else if(Vaisseau.getPts() == 70){
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(2);
            }
        }
        else if(Vaisseau.getPts() == 100) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(3);
            }
        }
        else if(Vaisseau.getPts()== 150) {
        	for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(4);
        	}
        }
        /*for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] != model.monst(0) || model.getGrille()[i][j] != model.monst(1) || model.getGrille()[i][j] != model.monst(2) || model.getGrille()[i][j] != model.monst(3)){
                    System.out.println("Le jeu est fini Merci d'y avoir joue");
                    System.exit(0);
                }
            }
        }*/
    }
    /**
     * On ajoute la vue sur le controlleur
     */
    public void addView(XSpaceVue vue){
    }

}
