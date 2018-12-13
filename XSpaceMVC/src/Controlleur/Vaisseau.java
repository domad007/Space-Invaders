package Controlleur;
import Modele.Grille;
import Vue.XSpaceVue;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
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

    private static int pts = 0;


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
            case "k" :
                left1();
                break;
            case "l":
                right1();
                break;
            case "K" :
                left1();
                break;
            case "L":
                right1();
                break;
        }
    }
    public void left(){
        for(int i =0; i<15; i++){
            for(int j = 0; j<10; j++){
                if( model.getGrille()[i][j] == model.getVaisseau()  && model.getGrille()[i][j-1] == model.getVide()){
                    model.getGrille()[i][j] = model.getVide();
                    int newPos = j-1;
                    model.getGrille()[i][newPos] =model.getVaisseau() ;
                    return;
                }
                if(model.getGrille()[i][j] ==model.getVaisseau() &&model.getGrille()[i][j-1] != model.getVide()){
                    model.getGrille()[i][j-1] = model.getVaisseau();
                    model.getGrille()[i][j] = model.getVaisseau2();
                    return;
                }
                else if(model.getGrille()[14][0] == model.getVaisseau()){
                    model.getGrille()[14][0] = model.getVaisseau();
                    return;
                }
            }
        }
    }

    public void right(){
        for(int i =0; i<15; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] ==model.getVaisseau() && model.getGrille()[i][j+1] == model.getVide()){
                    model.getGrille()[i][j] = model.getVide();
                    int newPos = j + 1;
                    model.getGrille()[i][newPos] =model.getVaisseau();
                    return;
                }
                if(model.getGrille()[i][j] ==model.getVaisseau() &&model.getGrille()[i][j+1] != model.getVide()){
                    model.getGrille()[i][j+1] = model.getVaisseau();
                    model.getGrille()[i][j] = model.getVaisseau2();
                    return;
                }
                else if(model.getGrille()[i][9] == model.getVaisseau()){
                    model.getGrille()[i][9] = model.getVaisseau();
                    return;
                }
            }
        }
    }
    public void points(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] == model.getLaser() && model.getGrille()[i-1][j] == model.monst(0)){
                    pts+=10;
                    System.out.println(pts);
                    System.out.print(" points");
                }
            }
        }
    }
    public void attack() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1 : model.getGrille()[i-1][j] = model.getLaser();
                            if(pts<=20){
                                model.getGrille()[i-1][j+1] = model.getLaser();
                            }
                        /*if(pts<=50){
                            model.getGrille()[i-1][j-1] = model.getLaser();
                        }*/
                    break;

                    case 2 : model.getGrille()[i-1][j] = model.getLaser();
                            break;
                    case 3 : model.getGrille()[i][j] =model.getVide();
                              model.getGrille()[i-1][j] =model.getLaser();
                              if(pts<=20){
                                  model.getGrille()[i-1][j ] =model.getLaser();

                              }
                              /*if(pts<=50){
                                  model.getGrille()[i][j] =model.getVide();
                                  model.getGrille()[i-1][j-1] =model.getLaser();
                              }*/
                              break;
                }
                if(model.getGrille()[i][9] == model.getLaser()){
                    model.getGrille()[i][9] = model.getVide();
                }
                if(model.getGrille()[i][0] == model.getLaser()){
                    model.getGrille()[i][0] = model.getVide();
                }
                if(model.getGrille()[1][j] == model.getLaser()){
                    model.getGrille()[1][j] = model.getVide();
                }
            }
        }
    }
    public void secondPlayer(){
        scanner = new Scanner(System.in);
        System.out.println("Desirez vous jouer à 2 ?[Oui/Non]");
        String reponse = scanner.nextLine().substring(0,1);
        if(reponse.equals("O") || reponse.equals("o")){
            model.getGrille()[14][5] = model.getVaisseau2();
        }
        else {
            model.getGrille()[14][5] = model.getVide();
        }
    }
    public void left1(){
        for(int i =0; i<15; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == model.getVaisseau2() && model.getGrille()[i][j-1] == model.getVide()){
                    model.getGrille()[i][j] = model.getVide();
                    int newPos = j-1;
                    model.getGrille()[i][newPos] =model.getVaisseau2() ;
                    return;
                }
                if(model.getGrille()[i][j] ==model.getVaisseau2() &&model.getGrille()[i][j-1] != model.getVide()){
                    model.getGrille()[i][j-1] = model.getVaisseau2();
                    model.getGrille()[i][j] = model.getVaisseau();
                    return;
                }
                else if(model.getGrille()[14][0] == model.getVaisseau2()){
                    model.getGrille()[14][0] = model.getVaisseau2();
                    return;
                }

            }
        }
    }
    public void right1(){

        for(int i =0; i<15; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == model.getVaisseau2()  && model.getGrille()[i][j+1] == model.getVide()){
                    model.getGrille()[i][j] = model.getVide();
                    int newPos = j+1;
                    model.getGrille()[i][newPos] =model.getVaisseau2() ;
                    return;
                }
                if(model.getGrille()[i][j] ==model.getVaisseau2() &&model.getGrille()[i][j+1] != model.getVide()){
                    model.getGrille()[i][j+1] = model.getVaisseau2();
                    model.getGrille()[i][j] = model.getVaisseau();
                    return;
                }
                else if(model.getGrille()[i][9] == model.getVaisseau2()){
                    model.getGrille()[i][9] = model.getVaisseau2();
                    return;
                }

            }
        }
    }


    public void addView(XSpaceVue vue){
        this.vue = vue;
    }
    public static int getPts() {
        return pts;
    }

    public static void setPts(int pts) {
        Vaisseau.pts = pts;
    }


}
