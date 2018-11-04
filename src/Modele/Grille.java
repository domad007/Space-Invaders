package Modele;
public class Grille {


    private static int [][] grille = new int[10][10]; //Tableau à 2 dimensions

    private static int VIDE = 0; //Vide initié à 0

/*
    On parcours toute la grille
    Chaque position du tableau est égale à 0 après le parcours
 */

    public static void initialise(int [][] grille){
        for(int i=0; i<grille.length; i++){
            for(int j=0; j<grille[i].length; j++){
                grille[i][j] = VIDE;
            }
        }
    }


    /*
        On donne la forme du tableau dans la console
        On imprime | pour les lignes et les colonnes
        Si la position est à 0 donc qui est vide on imprime ' '
        Si la position est à 1 donc qui as le X dans ce cas on imprime x
     */
    public static void affiche(int [][] grille) {
        System.out.println();

        for (int[] ligne : grille) {
            System.out.print("|");
            for (int cellule : ligne) {
                if (cellule == VIDE) {
                    System.out.print(' ');
                }
                else {
                    System.out.print('x');
                }

                System.out.print("|");
            }
            System.out.println();
        }
    }
    /*
        Getters et setteurs pour les autres classes qui en ont besoin
     */
    public static int[][] getGrille() {
        return grille;
    }

    public static void setGrille(int[][] grille) {
        Grille.grille = grille;
    }
}
