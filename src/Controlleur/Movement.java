package Controlleur;
import java.util.Scanner;
import Modele.Grille;
public class Movement {

    private Scanner scanner;

    public void move() {

        scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "q":
                left();
                break;
            case "d":
                right();
                break;
            case "Q" :
                left();
                break;
            case "D" :
                right();
                break;
        }
    }


    public void left(){

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
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

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(Grille.getGrille()[i][j] == 1){
                    Grille.getGrille()[i][j] = 0;
                    int newPos = j+1;
                    Grille.getGrille()[i][newPos] =1 ;
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
