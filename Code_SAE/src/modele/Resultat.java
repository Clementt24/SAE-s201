package modele;

import java.util.ArrayList;

public class Resultat {

    private ArrayList<Statut> listeStatuts;

    // Constructeur
    public Resultat(ArrayList<Statut> statuts) {
        this.listeStatuts = statuts;
    }

    // Getter
    public ArrayList<Statut> getListeStatuts() {
        return this.listeStatuts;
    }

    public boolean isVictoire() {

        // On parcourt la liste des statuts
        for (int i = 0; i < this.listeStatuts.size(); i++) {
            Statut statutActuel = this.listeStatuts.get(i);

            if (statutActuel.isGagnant() == false) {            // Si un seul statut n'est pas gagnant, le mot n'est pas le bon !
                return false;
            }
        }

        return true; // Si la boucle se termine, c'est que le mot est le meme donc gagné
    }
    
    public String toString() {
        String affichage = "Résultat de la tentative : \n";
        for (int i = 0; i < this.listeStatuts.size(); i++) {
            affichage += "- Lettre " + (i + 1) + " : " + this.listeStatuts.get(i).getTexte() + "\n";
        }
        return affichage;
    }
}