package Modele;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {
    /**
     * Creation de l objet grille pour les test
     */
    Grille grille = new Grille();

    /**
     * On regarde si la collection marche correctement
     */
    @Test
    void monst() {
        assertEquals('L',grille.monst(1));
    }

    /**
     * On initialise la grille
     * Et on regarde qu il y a du vide sur un des endroits de la grille
     */
    @Test
    void initialise() {
        grille.initialise(grille.getGrille());
        assertEquals(grille.getVide(), grille.getGrille()[1][2]);
    }

    /**
     * On affiche la grille
     * On procede de la meme maniere que pour l initialisation de la grille
     */
    @Test
    void affiche() {
        grille.affiche(grille.getGrille());
        assertEquals(grille.getVide(), grille.getGrille()[5][4]);
    }
}