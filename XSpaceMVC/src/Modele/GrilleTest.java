package Modele;

import static org.junit.jupiter.api.Assertions.*;

class GrilleTest {

    Grille grille = new Grille();
    @org.junit.jupiter.api.Test
    void getMonst() {

        assertEquals('L',grille.monst(1));
    }
}