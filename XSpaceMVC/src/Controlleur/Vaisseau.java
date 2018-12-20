package Controlleur;
import Modele.Grille;
import Vue.XSpaceVue;
import java.util.Scanner;


public class Vaisseau{
    /**
     * Variables d'instance
     */
    Scanner scanner;
    private Grille model;
    private static int life = 3;
    public Vaisseau(Grille m){
        model = m;
    }
    private static int pts = 0;

    /**
     * Deplacements / tirs obliques des vaisseaux joueur1 / joueur2
     * Pour deplacer le vaisseau, les touches suivantes sont utilisees (en maj / min): 
     * joueur 1 : d = droite, q = gauche
     * joueur 2 : k = gauche, l = droite
     * Tirs obliques : 
     * joueur 1 : e = oblique droite, a = oblique gauche
     * joueur 2 : o = oblique droite, i = oblique gauche
     */
    public void moveVaiss(){
        scanner = new Scanner(System.in);
        switch (scanner.nextLine()){
            case "q" : left() ; break;
            case "d" : right(); break;
            case "Q" : left() ; break;
            case "D" : right(); break;
            	case "k" : left1() ; break;
            	case "l" : right1();break;
            	case "K" : left1() ; break;
            	case "L" : right1(); break;
            case "e" : obRightSide() ; break;
            case "E" : obRightSide() ; break;
            case "A" : obLeftSide()  ; break;
            case "a" : obLeftSide()  ; break;
            	case "i" : obLeftSide2() ; break;
            	case "I" : obLeftSide2() ; break;
            	case "o" : obRightSide2(); break;
            	case "O" : obRightSide2(); break;
        }
    }
    																/*						/*
    																 * DEPLACEMENTS JOUEUR1  *
    																 */				 		//
    /**
     * Deplacement du vaisseau vers la gauche
     * Si pas d'obstacle, deplacement vers la gauche
     * S'il y a obstacle, il y a changement de position entre le vaisseau et l'obstacle
     * Si le vaisseau est a l'extreminite de l axe Y, il garde sa position
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
     * Si pas d'obstacle, deplacement vers la droite
     * S'il y a obstacle, il y a changement de position entre le vaisseau et l'obstacle
     * Si le vaisseau est a l'extreminite de l axe Y, il garde sa position
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
     * Points gagnes par le joueur
     * Lorsque le laser se trouve a une position en dessous du monstre, le monstre disparait et le joueur obtient
     * 				 10 points si monstre de niveau 1 est tue
     * 				20 points si monstre de niveau 2 est tue
     * 				30 points si monstre de niveau 3 est tue
     * Si un monstre depasse la deriniere ligne, le joueur perd 1 point / monstre passe
     * La partie se termine lorsque la vie du joueur = 0
     */
    public void points(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] == model.getLaser() && model.getGrille()[i-1][j] == model.monst(0)){
                    pts+=10;
                    System.out.println("Points: "+pts);
                }
                if(model.getGrille()[i][j] == model.getLaser() && model.getGrille()[i-1][j] == model.monst(1)){
                    pts+=20;
                    System.out.println("Points: "+pts);
                }
                if(model.getGrille()[i][j] == model.getLaser() && model.getGrille()[i-1][j] == model.monst(2)){
                    pts+=30;
                    System.out.println("Points: "+pts);
                }
                else if(model.getGrille()[14][j] ==model.monst(0) || 
                		model.getGrille()[14][j] ==model.monst(1) || 
                		model.getGrille()[14][j] ==model.monst(2)){
                    			model.getGrille()[14][j] =model.getVide();
                    			life -=1;
                    			System.out.println("Il vous reste: "+life +" vies");
                }
                else if(model.getGrille()[14][j] ==model.monst(3)){
                    life = 0;
                }
                else if(life == 0){
                    System.out.println("Vous avez perdu");
                    System.exit(0);
                }
            }
        }
    }

    
																/*						/*
																 * ATTAQUES  JOUEUR1	 *
																 */						 //
    /**
     * Attaque du vaisseau avec le canon laser
     * Il y a un laser qui se genere juste au dessus du vaisseau
     * Si le laser atteint le max de la grille, il disparait
     */
    public void attack() {
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
                    case 1 : model.getGrille()[i-1][j] = model.getLaser(); break;
                    case 2 : model.getGrille()[i-1][j] = model.getLaser(); break;
                    case 3 : model.getGrille()[i][j] = model.getVide();
                              model.getGrille()[i-1][j] = model.getLaser();break;
                }
                /*if(model.getGrille()[i][9] == model.getLaser()){
                    model.getGrille()[i][9] = model.getVide();
                }
                if(model.getGrille()[i][0] == model.getLaser()){
                    model.getGrille()[i][0] = model.getVide();
                }*/
                if(model.getGrille()[1][j] == model.getLaser()){
                    model.getGrille()[1][j] = model.getVide();
                }
            }
        }
    }

    /**
     * Tir oblique droit du joeuur1 grace a l'appui d'une touche
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
     * Tir oblique gauche du joeuur1 grace a l appui d une touche
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
     * Generation du joueur2
     * On pose la question au debut du jeu si il veut jouer solo ou a 2
     * Si oui un second joueur apparait
     * Si non le joueur1 joue seul
     */
    public void secondPlayer(){
        scanner = new Scanner(System.in);
        System.out.println("Desirez vous jouer Ã  2 ?[Oui/Non]");
        String reponse = scanner.nextLine().substring(0,1);
        if(reponse.equals("O") || reponse.equals("o")){
            model.getGrille()[14][5] = model.getVaisseau2();
        }
        else {
            model.getGrille()[14][5] = model.getVide();
        }
    }

																		/*						/*
																		 * DEPLACEMENTS JOUEUR2  *
																		 */				 		//
    
    
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
    
    
																				/*						/*
																				 * ATTAQUES JOUEUR2	     *
																				 */				 		//
    
    
    /**
     * Tir oblique droit du joueur2 grace a l'appui d'une touche
     * Il y a un laser qui se genere juste au dessus a droite du vaisseau
     * Lorsque le laser arrive a l extremite de la grille, il disparait
     */
    public void obRightSide2(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
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
     * Tir oblique gauche du joeuur2 grace a l appui d une touche
     * Il y a un laser qui se genere juste au dessus a gauche du vaisseau
     * Lorsque le laser arrive a l extremite de la grille, il disparait
     */
    public void obLeftSide2(){
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < 10; j++) {
                switch(model.getGrille()[i][j]){
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
     * On ajoute la vue sur le controlleur
     * Getters et setter
     * @param vue
     */
    public void addView(XSpaceVue vue){
    }
    public static int getPts() {
        return pts;
    }

    public static void setPts(int pts) {
        Vaisseau.pts = pts;
    }


}
