package Controlleur;
import Modele.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class Monster {


    public int randomX(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k=0; k<4; k++) {
            list.add(new Integer(k));

        }
        Collections.shuffle(list);
    }
    public int randomY(){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int k=0; k<9; k++) {
            list.add(new Integer(k));

        }
        Collections.shuffle(list);

    }


    public void timeOfMonster(){

        try {
            Thread.sleep(1000);

        }
        catch(InterruptedException e){
            Thread.currentThread().interrupt();
        }
    }
    public void generateMonster() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grille.getGrille()[i][j] == 0) {
                    Grille.getGrille()[randomX()][randomY()] = 2;
                }
            }
        }
    }

    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grille.getGrille()[i][j] == 2) {
                    Grille.getGrille()[i][j] = 0;
                    int newPos = i+1;
                    Grille.getGrille()[newPos][j] = 2;
                    return;
                }
            }
        }
    }

    public static void main(String[] args){
        Monster monst = new Monster();
        /*Grille gri = new Grille();
        gri.initialise(gri.getGrille());
        monst.generateMonster();*/

    }




}
