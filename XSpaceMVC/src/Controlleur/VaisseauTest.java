package Controlleur;

import Modele.Grille;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VaisseauTest {
    /**
     * Variables d instance
     */
    Grille grille = new Grille();
    Vaisseau vaiss = new Vaisseau(grille);
    @Test
    /**
     * On verifie si le vaisseau se deplace correctement dans la grille
     */
    void left() {
        grille.getGrille()[5][6] = grille.getVaisseau();
        vaiss.left();
        assertEquals(grille.getVaisseau(),grille.getGrille()[5][5] );
    }

    @Test
    /**
     * On verifie si le vaisseau se deplace correctement dans la grille
     */
    void right() {
        grille.getGrille()[5][6] = grille.getVaisseau();
        vaiss.right();
        assertEquals(grille.getVaisseau(),grille.getGrille()[5][7]);
    }
    @Test
    /**
     * On regarde si les points marchent correctement apres avoir tue un monstre
     */
    void points() {
        grille.getGrille()[5][2] = grille.monst(0);
        grille.getGrille()[6][2] = grille.getLaser();
        vaiss.points();
        grille.affiche(grille.getGrille());
       assertEquals(10, vaiss.getPts());
    }

    /**
     * On regarde si le laser apparait bien au dessus du vaisseau
     * On utilise les poitns de la grille pour voir
     */
    @Test
    void attack() {
        grille.getGrille()[5][6] = grille.getVaisseau();
        vaiss.attack();
        assertEquals(grille.getLaser(), grille.getGrille()[4][6]);
    }

    /**
     * On regarde si le laser apparait bien de maniere oblique a droite par rapport au vaisseau
     */
    @Test
    void obRightSide() {
        grille.getGrille()[5][6] = grille.getVaisseau();
        //vaiss.obRightSide();
        assertEquals(grille.getLaser(),grille.getGrille()[4][7]);
    }

    /**
     * On regarde si le laser apparait bien de maniere oblique a gauche par rapport au vaisseau
     */
    @Test
    void obLeftSide() {
        grille.getGrille()[5][6] = grille.getVaisseau();
        //vaiss.obLeftSide();
        assertEquals(grille.getLaser(),grille.getGrille()[4][5]);
    }
}