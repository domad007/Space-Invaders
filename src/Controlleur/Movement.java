package Controlleur;
import java.util.Scanner;
import Modele.Grille;

public class Movement {

    private Scanner scanner;


    /*
    Déplacement du X vers la gauche ou la droite crée dans la classe Grille
     */
    public void move() {

        scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "q":
                left();
                break;
            case "d":
                right();
                break;
        }
    }


/*
    On parcours la grille pour trouver le X initial
    Dès qu'il est repéré on le déplace vers la gauche en remplacant sa ancienne position par le Vide
    Lorsqu'on arrive à la dernière case de la grille des 2 côtés(droite et gauche) et qu'on veut encore décaller, on reste sur la même case
 */
    public void left(){

        for(int i =0; i<Grille.getGrille().length; i++){
            for(int j = 0; j<Grille.getGrille()[i].length; j++){
                if(Grille.getGrille()[i][j] == 1){
                    Grille.getGrille()[i][j] = 0;
                    int newPos = j-1;
                    Grille.getGrille()[i][newPos] =1 ;
                }
                else if(Grille.getGrille()[9][0] == 1){
                    Grille.getGrille()[9][0] = 1;
                    return;
                }
            }
        }
    }

    public void right(){

        for(int i =0; i<Grille.getGrille().length; i++){
            for(int j = 0; j<Grille.getGrille()[i].length; j++){
                if(Grille.getGrille()[i][j] == 1){
                    Grille.getGrille()[i][j] = 0;
                    int newPos = j+1;
                    Grille.getGrille()[i][newPos] = 1;
                    return;
                }
                else if(Grille.getGrille()[i][9] == 1){
                    Grille.getGrille()[i][9] = 1;
                    return;
                }
            }
        }
    }



}
