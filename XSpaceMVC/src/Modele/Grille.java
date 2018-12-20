package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Grille extends Observable {

    /**
     * Variables d instance de la grille
     */
    private int [][] grille = new int[15][10]; //Tableau à 2 dimensions

    private int vide = 0; //Vide initié à 0
    private int vaisseau = 1;
    private int vaisseau2 = 2;
    private int laser = 3;
    /**
     * Creation d une collection pour les monstres
     * Le integer est pour l index
     * Char est le monstre imprime en console
     */
    HashMap<Integer, Character> monsters = new HashMap<>();

    public char monst(int index){
        monsters.put(0,'O');
        monsters.put(1, 'L');
        monsters.put(2, 'P');
        monsters.put(3, 'T');
        return monsters.get(index);
    }

    /**
     * On initialise la grille
     * Toute la grille est vide au debut si on n apporte pas de modifications a la grille
     * @param grille
     */

    public void initialise(int [][] grille){
        for(int i=0; i<grille.length; i++){
            for(int j=0; j<grille[i].length; j++){
                grille[i][j] = vide;
            }
        }
    }

    /**
     * On donne la forme a la grille
     * On imprime des | pour avoir une forme de la grille et savoir se reperer
     * Lorsqu on apporte une modification a la grille on imprime des differents signes pour representes un monstre, le vide, vaisseau etc.
     * @param grille
     */
    public void affiche(int [][] grille) {
        System.out.println();

        for (int[] ligne : grille) {
            System.out.print("|");
            for (int cellule : ligne) {
                switch(cellule){
                    case 0 : System.out.print(' ') ; break;
                    case 1:  System.out.print('X') ; break;
                    case 2:  System.out.print('V') ; break;
                    case 3:  System.out.print('|') ; break;
                }
                if(cellule == monst(0)){
                    System.out.print(monst(0));
                }
                if(cellule == monst(1)){
                    System.out.print(monst(1));
                }
                if(cellule == monst(2)){
                    System.out.print(monst(2));
                }
                if(cellule == monst(3)){
                    System.out.print(monst(3));
                }

                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Getters et setters pour que les autres classes peuvent y acceder
     * Ainsi que les modification qu on apporte a la grille dans le systeme MVC
     * @return
     */
    public  int[][] getGrille() {
        return grille;
    }

    public void setGrille(int[][] grille) {
        this.grille = grille;
        setChanged();
        notifyObservers();
    }

    public int getVide() {
        return vide;
    }

    public void setVide(int vide) {
        this.vide = vide;
        setChanged();
        notifyObservers();
    }

    public int getVaisseau() {
        return vaisseau;
    }

    public void setVaisseau(int vaisseau) {
        this.vaisseau = vaisseau;
        setChanged();
        notifyObservers();
    }

    public int getVaisseau2() {
        return vaisseau2;
    }

    public void setVaisseau2(int vaisseau2) {
        this.vaisseau2 = vaisseau2;
        setChanged();
        notifyObservers();
    }

    public int getLaser() {
        return laser;
    }

    public void setLaser(int laser) {
        this.laser = laser;
        setChanged();
        notifyObservers();
    }
}
