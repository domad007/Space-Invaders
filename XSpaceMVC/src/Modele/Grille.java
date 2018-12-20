package Modele;

import java.util.HashMap;
import java.util.Observable;

public class Grille extends Observable {

    /**
     * Variables d instance de la grille
     */
    private int [][] grille = new int[15][10]; //Tableau a 2 dimensions

    private int vide = 0; //Vide initie a 0
    private int vaisseau = 1; //joueur1
    private int vaisseau2 = 2;//joueur2
    private int laser = 3;	  // canon laser
    
    /**
     * Creation d une collection pour les monstres
     * Le integer est pour l index
     * Char est le monstre imprime en console
     */
    HashMap<Integer, Character> monsters = new HashMap<>();

    public char monst(int index){
        monsters.put(0, 'O'); //monstres lvl 1
        monsters.put(1, 'L'); //		 lvl 2
        monsters.put(2, 'P'); //		 lvl 3
        monsters.put(3, 'T'); // 		 lvl 4
        monsters.put(4, 'B'); // BOSS final
        return monsters.get(index);
    }

    /**
     * On initialise la grille a vide en la parcourant
     * @param grille
     */
    public void initialise(int [][] grille){
        for(int i=0; i<grille.length; i++){
            for(int j=0; j<grille[i].length; j++){
                grille[i][j] = vide;
            }
        }
    }

    /**
     * On donne la forme a la grille
     * On imprime des | pour les colonnes afin d'avoir une forme de la grille et savoir se reperer
     * Lorsqu'on apporte une modification a la grille on imprime des differents signes pour representer :
     * le vide,les monstres, les joueurs, le laser etc.
     * @param grille
     */
    public void affiche(int [][] grille) {
        System.out.println();

        for (int[] ligne : grille) {
            System.out.print("|");
            for (int cellule : ligne) {
                switch(cellule){
                    case 0 : System.out.print(' ') ; break;	//vide
                    case 1 : System.out.print('X') ; break;	//joueur 1
                    case 2 : System.out.print('V') ; break;	//joueur 2
                    case 3 : System.out.print('|') ; break;	//laser
                }
                if(cellule == monst(0)){
                    System.out.print(monst(0));
                }
                if(cellule == monst(1)){
                    System.out.print(monst(1));
                }
                if(cellule == monst(2)){
                    System.out.print(monst(2));
                }
                if(cellule == monst(3)){
                    System.out.print(monst(3));
                }

                System.out.print("|");
            }
            System.out.println();
        }
    }

    /**
     * Getter grille
     * @return grille
     */
    public  int[][] getGrille() {
        return grille;
    }
    
    /**
     * Setter grille
     * @param grille
     */
    public void setGrille(int[][] grille) {
        this.grille = grille;
        setChanged();
        notifyObservers();
    }
    /**
     *  getter Vide
     * @return le vide
     */
    public int getVide() {
        return vide;
    }
    /**
     * setter Vide
     * @param vide
     */
    public void setVide(int vide) {
        this.vide = vide;
        setChanged();
        notifyObservers();
    }
    /**
     * getter Vaisseau joueur1
     * @return vaisseau
     */
    public int getVaisseau() {
        return vaisseau;
    }
    /**
     * setter Vaisseau joueur1
     * @param vaisseau
     */
    public void setVaisseau(int vaisseau) {
        this.vaisseau = vaisseau;
        setChanged();
        notifyObservers();
    }
    /**
     * getter Vaisseau joueur2
     * @return vaisseau du joueur 2
     */
    public int getVaisseau2() {
        return vaisseau2;
    }
    
    /**
     * setter Vaisseau joueur2
     * @param vaisseau2
     */
    public void setVaisseau2(int vaisseau2) {
        this.vaisseau2 = vaisseau2;
        setChanged();
        notifyObservers();
    }
    /**
     * getter laser
     * @return
     */
    public int getLaser() {
        return laser;
    }
    /**
     * setter laser
     * @param laser
     */
    public void setLaser(int laser) {
        this.laser = laser;
        setChanged();
        notifyObservers();
    }
}
