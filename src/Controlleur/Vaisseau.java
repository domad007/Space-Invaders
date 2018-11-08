package Controlleur;
import Modele.Grille;
import Vue.XSpaceVue;

import java.util.Scanner;

public class Vaisseau {
    Scanner scanner;
    private Grille model;
    private XSpaceVue vue = null;

    public Vaisseau(Grille m){
        model = m;
    }

    public void moveVaiss(){
        scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "q":
                left();
                break;
            case "d":
                right();
                break;
            case "Q":
               left();
                break;
            case "D":
                right();
                break;
        }

    }
    public void left(){

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 1){
                    model.getGrille()[i][j] = 0;
                    int newPos = j-1;
                    model.getGrille()[i][newPos] =1 ;
                }
                else if(model.getGrille()[9][0] == 1){
                    model.getGrille()[9][0] = 1;
                    return;
                }

            }
        }
    }
    public void right(){

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 1){
                    model.getGrille()[i][j] = 0;
                    int newPos = j+1;
                    model.getGrille()[i][newPos] =1 ;
                    return;
                }
                else if(model.getGrille()[i][9] == 1){
                    model.getGrille()[i][9] = 1;
                    return;
                }

            }
        }
    }

    /*public void attack() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] == 1 &&)
            }
        }
    }*/


    public void addView(XSpaceVue vue){
        this.vue = vue;
    }


}
