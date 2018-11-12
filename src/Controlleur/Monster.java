/**
 * @author Dominik Fiedorcczuk, Adelin Gaithier, Filipp Shatskiy 2TL
 */
package Controlleur;
import Modele.*;
import Vue.XSpaceVue;

import java.util.Random;


public class Monster {

    private Grille model; //initialisation de la grille ?
    private XSpaceVue vue = null; //vue du GUI

    private Random rand = new Random(); //initialisation de la fonction RANDOM

    /**
     * Constructeur de la classe Monster
     * @param m Grille dans laquelle les monstres apparaitront
     */
    public Monster(Grille m){
        model = m;
    }

    /**
     * Initialisation aléatoire du nombre de monstres
     * @return mons le nombre de monstres
     */
    public int numbMons(){
        int mons = 3+rand.nextInt(5-3);
        return mons;
    }
    
    /**
     * 
     * @return
     */
    public int randomY(){
        int y = rand.nextInt(10-0);
        return y;
    }

    /**
     * Permet l'apparition de monstres dans le tableau
     */
    public void monsters() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[i][j] == 0) {
                    for (int k = 0; k <= numbMons(); k++) {
                        model.getGrille()[0][randomY()] = 2; // 2 = monstre
                    } return; //just exits the method at that point
                }
                
            }
        } 
    }


    /**
     * Permet le deplacement des monstres generes vers le bas
     */
    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) { 
                while (model.getGrille()[i][j] == 2) { //tant que/s'il y a des mobs dans la grille
                    int newPos = i + 1; //leur nouvelle position
                    model.getGrille()[newPos][j] = 2; //mob descend d'une ligne
                    model.getGrille()[i][j] = 0; //la ligne precedente devient vide
                    waves();
                    return; //exits the method
                } 
                /*if (model.getGrille()[3][j] == 2) { //des qu'un mob atteint la ligne 4, une nouvelle vague apparait
                    for (int k = 0; k <= numbMons(); k++) {
                        model.getGrille()[0][randomY()] = 2;
                    }
                }*/
            }
        } 
    }
    
    /**
     * Generation de vagues de monstres apres avoir passe un certain nb de lignes
     */
    public void waves() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                while (model.getGrille()[5][j] == 2) { //si mob present a la ligne 5, generation de nouvx mobs
                    //for (int k = 0; k <= numbMons(); k++) { -------------------PAS BESOIN
                	if (model.getGrille()[0][j] == 0) {
                		for (int k = 0; k < numbMons(); k++) { 
                			model.getGrille()[0][randomY()] = 2; 
                		}
                	}
                   // }
                	return;
                }
            }
        }
    }
    
    /**
     * Permet d'afficher le jeu pour le MVC
     * @param vue, vue du jeu
     */
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
