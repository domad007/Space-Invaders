package Controlleur;

import org.junit.jupiter.api.Test;
import Modele.*;
import static org.junit.jupiter.api.Assertions.*;

class MonsterTest {
    /**
     * Création des objets grille et monstres pour les test
     */
    Grille grille = new Grille();
    Monster monst = new Monster(grille);
    @Test
    /**
     * On test la generation des monstres
     * Le test marche 1 fois sur quelques fois car on donne une position precise du monstre
     * Vu qu on genere des monstres sur des positions randoms ca varie de position
     */
    void monsters() {
        monst.monsters();
        //grille.affiche(grille.getGrille());
        assertEquals(grille.monst(0), grille.getGrille()[1][1]);

    }

    /**
     * On test la descente des monstres
     * Le test marche donc le monstre est descendu sur la position qu on veux
     */
    @Test
    void monsterDown() {
        grille.getGrille()[2][1] = grille.monst(0);
        monst.monsterDown();
        assertEquals(grille.monst(0), grille.getGrille()[3][1]);
        grille.getGrille()[3][1] = grille.monst(1);
        monst.monsterDown();
        assertEquals(grille.monst(1), grille.getGrille()[4][1]);

    }

    /**
     * Test des vagues
     * Meme chose que pour la fonction des monstres
     * Les monstres sont generer de maniere random sur la grille
     */
    @Test
    void waves() {
        grille.getGrille()[5][1] = grille.monst(0);
        //monst.waves();
        grille.affiche(grille.getGrille());
        assertEquals(grille.monst(1), grille.getGrille()[2][5]);
    }

    @Test
    void monstLife() {

    }
}