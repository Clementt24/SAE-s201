import java.util.ArrayList;

public class TestGlobal {

    public static void main(String[] args) {
        System.out.println("=========================================");
        System.out.println("  LANCEMENT DES TESTS GLOBAUX FINDMYWORD ");
        System.out.println("=========================================\n");

        testerValidationMot();
        testerJoueur();
        simulerPartieGagnante();
        simulerPartiePerdante();

        System.out.println("=========================================");
        System.out.println("          FIN DE TOUS LES TESTS          ");
        System.out.println("=========================================");
    }

    // --- TEST 1 : Les règles du mot ---
    private static void testerValidationMot() {
        System.out.println("--- TEST 1 : Validation des mots ---");
        System.out.println("Mot 'chat' (4 lettres) -> Valide ? " + Mot.isValid("chat") + " (Attendu: false)");
        System.out.println("Mot 'avions' (6 lettres) -> Valide ? " + Mot.isValid("avions") + " (Attendu: false)");
        System.out.println("Mot 'ab1de' (chiffre) -> Valide ? " + Mot.isValid("ab1de") + " (Attendu: false)");
        System.out.println("Mot 'belle' (doublon) -> Valide ? " + Mot.isValid("belle") + " (Attendu: false)");
        System.out.println("Mot 'ligne' (correct) -> Valide ? " + Mot.isValid("ligne") + " (Attendu: true)");
        System.out.println();
    }

    // --- TEST 2 : Le Joueur ---
    private static void testerJoueur() {
        System.out.println("--- TEST 2 : Gestion du Joueur ---");
        Joueur j1 = new Joueur("Alice");
        System.out.println("Création joueur : " + j1.getNom() + ", Score initial : " + j1.getScore());
        j1.addPoints(5);
        System.out.println("Ajout de 5 points. Nouveau score : " + j1.getScore() + " (Attendu: 5)");
        System.out.println();
    }

    // --- TEST 3 : Partie Gagnante (Cas de l'annexe C.1) ---
    private static void simulerPartieGagnante() {
        System.out.println("--- TEST 3 : Simulation Partie GAGNANTE ---");
        FixedWordRepository repo = new FixedWordRepository();
        Mot motSecret = repo.getWord(); // Retourne "ligne"
        Game game = new Game(motSecret);

        System.out.println("Le mot secret est : " + motSecret.getMot());

        // On simule 3 tentatives
        String[] tentatives = {"table", "lampe", "ligne"};

        for (int i = 0; i < tentatives.length; i++) {
            if (game.isGameOver()) break; // Sécurité

            Mot essai = new Mot(tentatives[i]);
            System.out.print("Tentative " + (game.getEssaiActuel() + 1) + " ('" + essai.getMot() + "') -> ");

            Resultat res = game.jouer(essai);
            afficherResultat(res, essai.getMot());
        }

        System.out.println("Partie terminée ? " + game.isGameOver() + " (Attendu: true)");
        System.out.println("Victoire ? " + game.isWon() + " (Attendu: true)");
        System.out.println("Score de la partie : " + game.calculateScore() + " (Attendu: 4)"); // 7 - 3 essais = 4
        System.out.println();
    }

    // --- TEST 4 : Partie Perdante ---
    private static void simulerPartiePerdante() {
        System.out.println("--- TEST 4 : Simulation Partie PERDANTE ---");
        FixedWordRepository repo = new FixedWordRepository();
        Game game = new Game(repo.getWord()); // Le mot est toujours "ligne"

        System.out.println("Le joueur va échouer 6 fois exprès.");
        String[] mauvaisesTentatives = {"table", "lampe", "lever", "loger", "luire", "livre"};

        for (String mot : mauvaisesTentatives) {
            Mot essai = new Mot(mot);
            Resultat res = game.jouer(essai);
            System.out.print("Essai " + game.getEssaiActuel() + " : ");
            afficherResultat(res, essai.getMot());
        }

        System.out.println("Partie terminée ? " + game.isGameOver() + " (Attendu: true)");
        System.out.println("Victoire ? " + game.isWon() + " (Attendu: false)");
        System.out.println("Score de la partie : " + game.calculateScore() + " (Attendu: 0)");
        System.out.println();
    }

    // --- Utilitaire d'affichage pour les tests ---
    private static void afficherResultat(Resultat res, String motTente) {
        ArrayList<String> etats = res.getEtats();
        for (int i = 0; i < etats.size(); i++) {
            // Affiche la lettre suivie de sa première initiale d'état (O, P, ou A)
            char initialeEtat = etats.get(i).charAt(0);
            System.out.print("[" + motTente.charAt(i) + ":" + initialeEtat + "] ");
        }
        System.out.println();
    }
}