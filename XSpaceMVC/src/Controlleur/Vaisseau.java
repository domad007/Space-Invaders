package Controlleur;
import Modele.Grille;
import Vue.XSpaceVue;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Vaisseau{
    /**
     * Variables d instance
     */
    Scanner scanner;
    private Grille model;
    private XSpaceVue vue = null;
    private static int life = 3;
    public Vaisseau(Grille m){
        model = m;
    }
    private static int pts = 0;

    /**
     * Deplacement du vaisseau ainsi que les tirs obliques
     * La console detecte qu une touche a ete appuye et deplace soit le vaisseau a gauche ou a droite
     * Meme chose pour les tirs obliques, lorsqu on appuie sur le boutton un tir oblique a ete lache
     */
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
                case "e":
                    obRightSide();
                    break;
                case "E":
                    obRightSide();
                    break;
                case "A" :
                    obLeftSide();
                    break;
                case "a" :
                    obLeftSide();
                    break;
                    }
    }

    /**
     * Deplacement du vaisseau vers la gauche
     * Lorsqu a il n y a pas d obstacle comme par exemple un second joueur on se deplace a gauche
     * Lorsqu a il y a un obstacle il y a un changement de positons entre le vaisseau qu on deplace et l obstacle
     * Des que le vaisseau est a l extreminite de l axe Y, il garde sa position
     */
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
                    model.setVaisseau(model.getGrille()[i][j-1]);
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

    /**
     * Deplacement du vaisseau vers la droite
     * Lorsqu a il n y a pas d obstacle comme par exemple un second joueur on se deplace a droite
     * Lorsqu a il y a un obstacle il y a un changement de positons entre le vaisseau qu on deplace et l obstacle
     * Des que le vaisseau est a l extreminite de l axe Y, il garde sa position
     */
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

    /**
     * Points accumules par le joueur
     * Lorsque le laser se trouve une position en dessous du monstre, le monstre disparait et le joueur obtient 10 poitns
     */
    public void points(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] == model.getLaser() && model.getGrille()[i-1][j] == model.monst(0)){
                    pts+=10;
                    System.out.println(pts);
                    //System.out.print(" points");
                }
            }
        }
    }

    /**
     * Attaque du vaisseau
     * Il y a un laser qui se genere juste au dessus du vaisseau
     * Lorsque le laser arrive tout au dessus de la grille, il disparait
     */
    public void attack() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1 : model.getGrille()[i-1][j] = model.getLaser();
                    break;
                    case 2 : model.getGrille()[i-1][j] = model.getLaser();
                            break;
                    case 3 : model.getGrille()[i][j] =model.getVide();
                              model.getGrille()[i-1][j] =model.getLaser();
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

    /**
     * Tir oblique du vaisseau grace a l appui d une touche
     * Il y a un laser qui se genere juste au dessus a droite du vaisseau
     * Lorsque le laser arrive a l extremite de la grille, il disparait
     */
    public void obRightSide(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1:  model.getGrille()[i-1][j+1] = model.getLaser();
                    break;
                    case 2: model.getGrille()[i-1][j+1] = model.getLaser();
                    break;
                    case 3 : model.getGrille()[i][j] =model.getVide();
                        model.getGrille()[i-1][j+1] =model.getLaser();
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
    /**
     * Tir oblique du vaisseau grace a l appui d une touche
     * Il y a un laser qui se genere juste au dessus a gauche du vaisseau
     * Lorsque le laser arrive a l extremite de la grille, il disparait
     */
    public void obLeftSide(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1:  model.getGrille()[i-1][j-1] = model.getLaser();
                        break;
                    case 2: model.getGrille()[i-1][j-1] = model.getLaser();
                        break;
                    case 3 : model.getGrille()[i][j] =model.getVide();
                        model.getGrille()[i-1][j-1] =model.getLaser();
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

    /**
     * Generation du second joueur
     * On pose la question au debut du jeu si il veut jouer solo ou a 2
     * Si oui un second joueur apparait
     * Sinon il y a juste le premier vaisseau qui apparait
     */
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

    /**
     * Meme systeme que pour le premier vaisseau
     */
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

    /**
     * Meme systeme que pour le premier vaisseau
     */
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

    /**
     * On ajoute la vue sur le controlleur
     * Getters et setter
     * @param vue
     */
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
