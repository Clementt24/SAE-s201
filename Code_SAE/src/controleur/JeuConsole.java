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

        System.out.println("----------------------------------------");
        System.out.println("          FIND MY WORD         ");
        System.out.println("----------------------------------------");

        System.out.print("Entrez votre nom : ");
        String pseudo = clavier.nextLine();
        Joueur joueur = new Joueur(pseudo);

        // --- NOUVEAU : Menu de sélection du mode de jeu ---
        System.out.println("\nChoisissez votre mode:\n");
        System.out.println("1 - Mot fixe (AVION)");
        System.out.println("2 - Mot aléatoire");
        System.out.print("\nVotre choix (1 ou 2) : ");
        String choixMode = clavier.nextLine().trim();

        try {
            Mot motSecret = null;

            if (choixMode.equals("1")) {
                motSecret = new Mot("AVION");
                System.out.println("\n(Mode Test) Le mot secret est fixé à AVION.");
            } else {
                RepertoireMots dictionnaire = new RepertoireMots("src/data/mots.json");
                motSecret = dictionnaire.getMotAleatoire();
                System.out.println("\n(Mode Normal) Un mot secret de 5 lettres a été généré.");
            }

            Partie partie = new Partie(motSecret);
            System.out.println("Vous avez 6 essais pour le deviner.\n");

            while (!partie.isPartieTerminee()) {

                System.out.print("Essai n°" + (partie.getNbEssais() + 1) + " > Tapez votre proposition : ");
                String saisie = clavier.nextLine().toUpperCase().trim();

                try {
                    Mot tentative = new Mot(saisie);
                    Resultat resultat = partie.analyserTentative(tentative);
                    System.out.println();
                    for (Resultat r : partie.getHistorique()) {
                        System.out.println(r.toString());
                    }
                    System.out.println();

                } catch (LongueurMotException e) {
                    System.out.println("  Erreur : le mot doit contenir exactement 5 lettres.\n");
                } catch (FormatMotException e) {
                    System.out.println("  Erreur : le mot doit contenir uniquement des lettres, et il ne doit pas y avoir deux fois la meme lettrre dans le mot.\n");
                }
            }

            if (partie.isVictoire()) {
                System.out.println("BRAVO ! Vous avez trouvé en " + partie.getNbEssais() + " essai(s) !");
            } else {
                System.out.println("RATÉ ! Le mot était : " + motSecret.getMot());
            }

        } catch (Exception e) {
            System.out.println("Erreur lors du chargement ou de la création du mot : " + e.getMessage());
        } finally {
            clavier.close();
        }
    }
}