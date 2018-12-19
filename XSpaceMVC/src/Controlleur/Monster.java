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
    private static int life = 3;
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

    /**
     * Generation des vagues sur l axe Y de maniere random
     * Lorsqu on atteint 20 points la seconde vague apparait
     */
    public void waves() {
    	for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
            	if (Vaisseau.getPts()<=20) {
            			model.getGrille()[2][randomY()] = model.monst(1);
            	}
            }
    	}
    }

    /**
     * On ajoute la vue sur le controlleur
     */
    public void addView(XSpaceVue vue){
        this.vue = vue;
    }

}
