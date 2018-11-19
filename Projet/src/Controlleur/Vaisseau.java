package Controlleur;
import Modele.Grille;
import Vue.XSpaceVue;

import java.awt.event.KeyEvent;
import java.util.Arrays;
import java.util.Scanner;


public class Vaisseau {
    Scanner scanner;
    private Grille model;
    private XSpaceVue vue = null;
    private static int life = 3;
    public Vaisseau(Grille m){
        model = m;
    }

    public void moveVaiss(){
        scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "q" :
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
            case "k" : left1();break;
            case "l": right2();break;
            case "K" : left1();break;
            case "L": right2();break;
        }

    }

    public void lifes() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if (model.getGrille()[9][j] == 2) {
                    life -=1;
                    System.out.println("Il vous reste: "+life);
                }
                else if(life == 0){
                    System.out.println("Vous avez perdu");
                    System.exit(0);
                }
            }
        }
    }
    public void left(){
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if( model.getGrille()[i][j] == 1){
                    model.getGrille()[i][j] = 0;
                    int newPos = j-1;
                    model.getGrille()[i][newPos] =1 ;
                    return;
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
                if(model.getGrille()[i][j] ==1){
                    model.getGrille()[i][j] = 0;
                    int newPos = j + 1;
                    model.getGrille()[i][j+1] =1 ;
                    return;
                }
                else if(model.getGrille()[i][9] == 1){
                    model.getGrille()[i][9] = 1;
                    return;
                }
               /* else if (){
                    model.getGrille()[i][j+2] = 1;
                    return;
                }*/
            }
        }
    }


    public void attack() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1 : model.getGrille()[i-1][j] = 4;break;
                    case 4 :  model.getGrille()[i][j] =0;
                              model.getGrille()[i-1][j] =4;
                              break;
                }
                if(model.getGrille()[1][j] == 4){
                    model.getGrille()[1][j] = 0;
                }
                else if(model.getGrille()[i][j] == 2){
                    model.getGrille()[i+1][j] = 0;
                }
            }
        }
    }

    public void secondPlayer(){
        scanner = new Scanner(System.in);
        System.out.println("Desirez vous jouer à 2 ?[Oui/Non]");
        String reponse = scanner.nextLine().substring(0,1);
        if(reponse.equals("O") || reponse.equals("o")){
            model.getGrille()[9][5] = 3;
        }
        else {
            model.getGrille()[9][5] = 0;
        }
    }
    public void left1(){
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 3){
                    model.getGrille()[i][j] = 0;
                    int newPos = j-1;
                    model.getGrille()[i][newPos] =3 ;
                }
                else if(model.getGrille()[9][0] == 3){
                    model.getGrille()[9][0] = 3;
                    return;
                }

            }
        }
    }
    public void right2(){

        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 3){
                    model.getGrille()[i][j] = 0;
                    int newPos = j+1;
                    model.getGrille()[i][newPos] =3 ;
                    return;
                }
                else if(model.getGrille()[i][9] == 3){
                    model.getGrille()[i][9] = 3;
                    return;
                }

            }
        }
    }


    public void addView(XSpaceVue vue){
        this.vue = vue;
    }


}