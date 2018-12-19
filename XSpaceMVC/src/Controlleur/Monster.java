package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {
    /**
     * Variables d instance
     */
    private Grille model;
    private XSpaceVue vue = null;
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
     * Descente des monstres ligne par ligne pour les vagues
     * Lorsque les monstres descendent tout en bas de la grille, elles disparaissent et le vaisseau perds des vies
     * 1 monstre en bas est egal a une perte de vie
     * La partie se termine lorsque le vaisseau a perdu 3 points de vie
     */
    public void monsterDown(){
        Thread moveEnn = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 15; i++) {
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
                        }
                        if (model.getGrille()[i][j] == model.monst(2)) { //s'il y a un monstre
                            int newPos = i + 1;
                            model.getGrille()[newPos][j] = model.monst(2);
                            model.getGrille()[i][j] = model.getVide();
                            return;
                        }
                        if (model.getGrille()[i][j] == model.monst(3)) { //s'il y a un monstre
                            int newPos = i + 1;
                            model.getGrille()[newPos][j] = model.monst(2);
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
     * Lorsqu on atteint 20 points la seconde vague apparait
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
        else if(Vaisseau.getPts() == 200) {
            for (int k = 0; k <= numbMons(); k++) {
                model.getGrille()[1][randomY()] = model.monst(3);
            }
        }
        /*for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] != model.monst(0) || model.getGrille()[i][j] != model.monst(1) || model.getGrille()[i][j] != model.monst(2) || model.getGrille()[i][j] != model.monst(3)){
                    System.out.println("Le jeu est fini Merci d'y avoir joué");
                    System.exit(0);
                }
            }
        }*/
    }
    /**
     * On ajoute la vue sur le controlleur
     */
    public void addView(XSpaceVue vue){
        this.vue = vue;
    }

}
