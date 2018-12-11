package Modele;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

public class Grille extends Observable {


    private int [][] grille = new int[15][10]; //Tableau à 2 dimensions

    private int vide = 0; //Vide initié à 0
    private int vaisseau = 1;
    private int vaisseau2 = 2;
    private int laser = 3;

    HashMap<Integer, Character> monsters = new HashMap<>();

    public char monst(int index){
        monsters.put(0,'O');
        monsters.put(1, 'L');
        return monsters.get(index);
    }

/*
    On parcours toute la grille
    Chaque position du tableau est égale à 0 après le parcours
 */

    public void initialise(int [][] grille){
        for(int i=0; i<grille.length; i++){
            for(int j=0; j<grille[i].length; j++){
                grille[i][j] = vide;
            }
        }
    }




    /*
        On donne la forme du tableau dans la console
        On imprime | pour les lignes et les colonnes
        Si la position est à 0 donc qui est vide on imprime ' '
        Si la position est à 1 donc qui as le X dans ce cas on imprime x
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
                    case 5:  System.out.print('L') ; break;
                }
                if(cellule == monst(0)){
                    System.out.print(monst(0));
                }
                if(cellule == monst(1)){
                    System.out.print(monst(1));
                }

                System.out.print("|");
            }
            System.out.println();
        }
    }
    /*
        Getters et setteurs pour les autres classes qui en ont besoin
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
