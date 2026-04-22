import java.util.ArrayList;

public class Resultat {

    private ArrayList<String> etats;

    public Resultat(ArrayList<String> etats) {
        this.etats = etats;
    }

    public ArrayList<String> getEtats() {
        return this.etats;
    }

    // Vérifie si toutes les lettres sont OK
    public boolean isWinning() {
        // On utilise la boucle for-each (plus élégante avec les ArrayList) ou une boucle for classique
        for (int i = 0; i < etats.size(); i++) { // .size() au lieu de .length
            // Si un seul état n'est pas "OK", la tentative n'est pas gagnante
            if (!Status.STATUS_OK.equals(etats.get(i))) { // .get(i) au lieu de etats[i]
                return false;
            }
        }
        return true;
    }
}