package Modele;

import java.util.Observable;

public class Grille extends Observable {


    private int [][] grille = new int[10][10]; //Tableau à 2 dimensions

    private static int vide = 0; //Vide initié à 0
    private static int vaisseau = 1;
    private static int monstre = 2;
    private static int vaisseau2 = 3;
    private static int laser = 4;
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
                    case 2:  System.out.print('O') ; break;
                    case 3:  System.out.print('V') ; break;
                    case 4:  System.out.print('|') ; break;
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
        setChanged(); //actualise la grille � chaque mouvement
        notifyObservers();
    }
}
