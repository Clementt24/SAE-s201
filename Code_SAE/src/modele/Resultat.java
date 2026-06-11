package modele;

import java.util.ArrayList;

public class Resultat {

    private Mot tentative;
    private ArrayList<Statut> listeStatuts;

    public Resultat(Mot tentative, ArrayList<Statut> statuts) {
        this.tentative = tentative;
        this.listeStatuts = statuts;
    }

    // Getter
    public ArrayList<Statut> getListeStatuts() {
        return this.listeStatuts;
    }

    public boolean isVictoire() {
        for (int i = 0; i < this.listeStatuts.size(); i++) {
            Statut statutActuel = this.listeStatuts.get(i);

            if (statutActuel.isGagnant() == false) {
                return false;
            }
        }
        return true;
    }

    //méthodes de base
    @Override
    public String toString() {
        StringBuilder affichage = new StringBuilder();
        String texteMot = this.tentative.getMot();

        for (int i = 0; i < texteMot.length(); i++) {
            affichage.append("[ ").append(texteMot.charAt(i)).append(" ]");
        }

        affichage.append(" -> ");

        for (int i = 0; i < this.listeStatuts.size(); i++) {
            String texteStatut = this.listeStatuts.get(i).getTexte().toUpperCase();
            affichage.append(String.format("%-9s", texteStatut));
        }

        return affichage.toString();
    }
}