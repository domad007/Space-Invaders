package Controlleur;
import Modele.*;
import java.util.Random;

public class Monster {

    Random rand = new Random();


    public int numbMons(){
        int mons = rand.nextInt(7-1);
        return mons;
    }
    public int randomY(){
        int y = rand.nextInt(10-0);
        return y;
    }


    public void generateMonster() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grille.getGrille()[i][j] == 0) {
                    for(int k = 0; k<=numbMons(); k++) {
                        Grille.getGrille()[0][randomY()] = 2;
                    }
                }
                    return;
            }
        }
    }


    public void monsterDown(){
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grille.getGrille()[i][j] == 2) { //s'il y a des mobs
                    int newPos = i + 1;
                    Grille.getGrille()[newPos][j] = 2;
                    Grille.getGrille()[i][j] = 0;
                    return;
                }

                else if (Grille.getGrille()[9][j] == 2) {
                        Grille.getGrille()[9][j] = 0;
                    }
                }
            }
        }

    public void waves() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (Grille.getGrille()[5][j] == 2) { //si mob present a la ligne 5, generation de nouvx mobs
                    for (int k = 0; k <= numbMons(); k++) {
                        Grille.getGrille()[0][randomY()] = 2;
                    }
                }
            }
        }
    }


    /*public static void main(String[] args){
        Monster monst = new Monster();
        Grille gri = new Grille();
        gri.initialise(gri.getGrille());

        do {
            gri.affiche(gri.getGrille());
            monst.generateMonster();
            monst.monsterDown();
        }while(true);



    }*/




}
