package Vue;

import Controlleur.Monster;
import Controlleur.Vaisseau;
import Modele.Grille;

import java.util.Observable;
import java.util.Observer;
import java.util.Scanner;

public class XSpaceVueConsole extends XSpaceVue implements Observer {
    Scanner scanner;
    /**
     * Heritage sur XSpaceVue
     * On ajoute la fonction play pour lancer le jeu dans le main qui est dans le package test
     * @param model
     * @param controllerVaiss
     * @param controllerMonst
     */
    public XSpaceVueConsole(Grille model, Vaisseau controllerVaiss, Monster controllerMonst){
        super(model, controllerVaiss, controllerMonst);
        play();
    }

    /**
     * On fait une mise a jour sur le modele qui est la grille
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg){
        System.out.print(model.getGrille());
    }

    /**
     * Deplacement du vaisseau ainsi que les tirs obliques
     * La console detecte qu une touche a ete appuye et deplace soit le vaisseau a gauche ou a droite
     * Meme chose pour les tirs obliques, lorsqu on appuie sur le boutton un tir oblique a ete lache
     * On lance un thread pour lancer le programme en synchrone avec le GUI
     */

    public void move(){
        Thread move = new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    scanner = new Scanner(System.in);
                    switch (scanner.nextLine()) {
                        case "q":
                            controllerVaiss.left();
                            break;
                        case "d":
                            controllerVaiss.right();
                            break;
                        case "Q":
                            controllerVaiss.left();
                            break;
                        case "D":
                            controllerVaiss.right();
                            break;
                        case "k":
                            controllerVaiss.left1();
                            break;
                        case "l":
                            controllerVaiss.right1();
                            break;
                        case "K":
                            controllerVaiss.left1();
                            break;
                        case "L":
                            controllerVaiss.right1();
                            break;
                        case "e":
                            controllerVaiss.obRightSide();
                            break;
                        case "E":
                            controllerVaiss.obRightSide();
                            break;
                        case "A":
                            controllerVaiss.obLeftSide();
                            break;
                        case "a":
                            controllerVaiss.obLeftSide();
                            break;
                    }
                }
            }
        }); move.run();
    }

    /**
     * On fait une fonction play pour lancer tout le programme
     * Une sorte de main mais sans le main
     */
    public void play() {
                model.initialise(model.getGrille());
                model.getGrille()[14][4] = 1;
                //controllerVaiss.secondPlayer();
                controllerMonst.monsters();
                do{
                    model.affiche(model.getGrille());
                    move();
                    controllerMonst.monsterDown();
                    controllerMonst.waves();
                    controllerVaiss.points();
                    controllerVaiss.attack();
                }while(true);



    }
}
