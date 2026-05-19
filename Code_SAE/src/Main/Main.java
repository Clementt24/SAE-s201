package Main;

import modele.*;
import modele.EtatsStatus.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("----------------- Début du main -----------------");
        System.out.println("");

        //Test méthodes Mot
        Mot m1 = new Mot("abcdd");
        System.out.println(m1);

        //Test méthode Status et ses filles
        Statut s1 = new StatutOk();
        System.out.println(s1);

        Statut s2 = new StatutPresent();
        System.out.println(s2);

        Statut s3 = new StatutAbsent();
        System.out.println(s3);

        //Test de la méthode equals
        Statut s4 = new StatutOk();
        System.out.println(s4);

        boolean testEgalite = s1.equals(s4);
        System.out.println(testEgalite);


        Mot secret = new Mot("PLAGE");
        Partie maPartie = new Partie(secret);
        System.out.println("Le mot secret est choisi (PLAGE).\n");

        //une lettre mal placé
        System.out.println("MOURA");
        Mot essai1 = new Mot("MOURA");
        Resultat r1 = maPartie.analyserTentative(essai1);
        System.out.println(r1.toString());

        // present mais faux
        System.out.println("POULE");
        Mot essai2 = new Mot("POULE");
        Resultat r2 = maPartie.analyserTentative(essai2);
        System.out.println(r2.toString());

        // Victoire
        System.out.println("PLAGE");
        Mot essai3 = new Mot("PLAGE");
        Resultat r3 = maPartie.analyserTentative(essai3);
        System.out.println(r3.toString());

        System.out.println("");
        System.out.println("------------------ Fin du main ------------------");
    }

}