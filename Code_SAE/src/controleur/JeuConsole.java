package controleur;

import java.util.Scanner;
import donnees.RepertoireMots;
import modele.Joueur;
import modele.Mot;
import modele.Partie;
import modele.Resultat;
import modele.Exceptions.*;

public class JeuConsole {

    public void jouer() {
        Scanner clavier = new Scanner(System.in);

        System.out.println("=========================================");
        System.out.println("          BIENVENUE DANS WORDLE          ");
        System.out.println("=========================================\n");

        System.out.print("Entrez votre nom : ");
        String pseudo = clavier.nextLine();
        Joueur joueur = new Joueur(pseudo);

        try {
            RepertoireMots dictionnaire = new RepertoireMots("/home/clement/IdeaProjects/SAE-s201/Code_SAE/src/data/mots.json");
            //todo changer le chemin pour pas le mettre en dur
            Mot motSecret = dictionnaire.getMotAleatoire();
            Partie partie = new Partie(motSecret);

            System.out.println("\nUn mot secret de 5 lettres a été généré.");
            System.out.println("Vous avez 6 essais pour le deviner.\n");

            while (!partie.isPartieTerminee()) {
                System.out.print("Essai n°" + (partie.getNbEssais() + 1) + "Tapez votre proposition : ");
                String saisie = clavier.nextLine().toUpperCase().trim();

                try {
                    Mot tentative = new Mot(saisie);
                    Resultat resultat = partie.analyserTentative(tentative);
                    System.out.println(resultat.toString());
                } catch (LongueurMotException e) {
                    System.out.println("  Erreur : le mot doit contenir exactement 5 lettres.\n");
                } catch (FormatMotException e) {
                    System.out.println("  Erreur : le mot doit contenir uniquement des lettres.\n");
                }
            }

            if (partie.isVictoire()) {
                System.out.println("BRAVO ! Vous avez trouvé en " + partie.getNbEssais() + " essai(s) !");
            } else {
                System.out.println("RATÉ ! Le mot était : " + motSecret.getMot());
            }

        } catch (Exception e) {
            System.out.println("Erreur lors du chargement : " + e.getMessage());
        } finally {
            clavier.close();
        }
    }
}