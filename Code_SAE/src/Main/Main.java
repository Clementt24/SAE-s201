package Main;

import controleur.JeuConsole;

public class Main {

    public static void main(String[] args) {

        //On crée linterface
        JeuConsole monJeu = new JeuConsole();

        //On lance la partie
        monJeu.jouer();

    }
}