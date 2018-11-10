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
    private boolean position = true;
    public Vaisseau(Grille m){
        model = m;
    }
    
    /**
     * Permet le mouvement du veaisseau grace aux actions de l'user : 
     * Appuyer sur q ou Q pour le bouger a gauche
     * Appuyer sur d ou D pour le bouger a droite
     * Deuxieme joueur : Appuyer sur k pour le bouger a gauche
     * Deuxieme joueur : Appuyer sur l pour le bouger a droite
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
            case "k" : left1();break;
            case "l": right2();break;
        }

    }
    
    /**
     * Fonction permettant de deplacer le vaisseau dans la grille vers la gauche
     */
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
    
    /**
     * Fonction permettant de deplacer le vaisseau dans la grille vers la droite 
     */
    public void right(){
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] ==1){ 
                    model.getGrille()[i][j] = 0;
                    int newPos = j+1;
                    model.getGrille()[i][newPos] =1 ;
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

    /**
     * Fonction permettant le deplacement de l'attaque (laser) dans la grille
     */
    public void attack() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(model.getGrille()[i][j] == 1){
                    System.out.println(model.getGrille()[i-1][j] = 4);
                }
                else if(model.getGrille()[i][j] == 4){
                    model.getGrille()[i][j] =0;
                    model.getGrille()[i-1][j] =4;
                }
                else if(model.getGrille()[1][j] == 4){
                    model.getGrille()[1][j] = 0;
                }
                else if(model.getGrille()[i][j] == 2 &&model.getGrille()[i][j] == 4 ) {
                    model.getGrille()[i][j] = 2;
                }
            }
        }
    }
    
    /**
     * Demande de jouer au jeu a deux. 
     * Si oui : le vaisseau du joueur2 sera place dans une case
     * Si non : la case du joueur2 restera vide (jeu solo)
     */
    public void secondPlayer(){
        scanner = new Scanner(System.in);
        System.out.println("Desirez vous jouer à 2 ?[Oui/Non]");
        String reponse = scanner.nextLine().substring(0,1);
        if(reponse.equals("O") || reponse.equals("o")){
            model.getGrille()[9][5] = 3; // on remplit la case avec un deuxieme vaisseau
        }
        else {
            model.getGrille()[9][5] = 0; // case reste vide
        }
    }
    
    /**
     * Fonction permettant de deplacer le vaisseau du joueur2 dans la grille vers la gauche
     */
    public void left1(){
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 3){ 		//si vaisseau2 est tjs présent dans la case
                    model.getGrille()[i][j] = 0; 		//on la libere
                    int newPos = j-1;					//et on le deplace vers la gauche
                    model.getGrille()[i][newPos] =3 ; 	//on initialise la nouvelle position du vaisseau
                }
                else if(model.getGrille()[9][0] == 3){ 
                    model.getGrille()[9][0] = 3;  		//sinon on laisse le vaisseau a l'endroit
                    return;
                }

            }
        }
    }
    
    /**
     * Fonction permettant de deplacer le vaisseau du joueur2 dans la grille vers la droite
     */
    public void right2(){
        for(int i =0; i<10; i++){
            for(int j = 0; j<10; j++){
                if(model.getGrille()[i][j] == 3){		//si vaisseau2 est tjs présent dans la case
                    model.getGrille()[i][j] = 0;  		//on la libere
                    int newPos = j+1; 					//et on le deplace vers la droite
                    model.getGrille()[i][newPos] =3 ; 	//on initialise la nouvelle position du vaisseau
                    return;
                }
                else if(model.getGrille()[i][9] == 3){
                    model.getGrille()[i][9] = 3; 		//sinon on laisse le vaisseau a l'endroit
                    return;
                }

            }
        }
    }


    /**
     * MVC
     * @param vue
     */
    public void addView(XSpaceVue vue){
        this.vue = vue;
    }


}
