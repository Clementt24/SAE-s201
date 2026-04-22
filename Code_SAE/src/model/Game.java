import java.util.ArrayList;
import java.util.List;

public class Game {

    public static final int ESSAIS_MAX = 6;
    private int compteur;

    private Mot motSecret;
    private List<Resultat> historique; // Stocke toutes les tentatives du joueur

    public Game(Mot motSecret) {
        this.motSecret = motSecret;
        this.historique = new ArrayList<>();
        this.compteur = 0;
    }

    public Resultat jouer(Mot essai) {
        // CORRECTION : Vous devez créer une ArrayList
        ArrayList<String> statuts = new ArrayList<>();

        String secretStr = motSecret.getMot();
        String essaiStr = essai.getMot();

        // Analyse de la tentative lettre par lettre
        for (int i = 0; i < 5; i++) {
            char lettreEssai = essaiStr.charAt(i);

            if (lettreEssai == secretStr.charAt(i)) {
                // CORRECTION : On utilise .add() pour remplir une ArrayList
                statuts.add(Status.STATUS_OK);
            } else if (secretStr.contains(String.valueOf(lettreEssai))) {
                statuts.add(Status.STATUS_PRESENT);
            } else {
                statuts.add(Status.STATUS_ABSENT);
            }
        }

        // Maintenant, ça fonctionne car statuts est bien une ArrayList<String> !
        Resultat resultat = new Resultat(statuts);
        this.historique.add(resultat);
        this.compteur++;

        return resultat;
    }

    public int getEssaiActuel() {
        return this.compteur;
    }

    public Mot getMotSecret() {
        return this.motSecret;
    }

    public int calculateScore() {
        if (isWon()) {
            return 7 - compteur; // Ex: trouvé au 1er essai -> 7 - 1 = 6 points
        }
        return 0; // Aucun point si perdu
    }

    public boolean isGameOver() {
        // La partie s'arrête si c'est gagné OU si on a atteint 6 essais
        return isWon() || compteur >= ESSAIS_MAX;
    }

    public boolean isWon() {
        if (historique.isEmpty()) {
            return false;
        }
        Resultat dernierResultat = historique.get(historique.size() - 1);
        return dernierResultat.isWinning();
    }
}