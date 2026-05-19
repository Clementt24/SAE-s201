package modele;

import java.util.ArrayList;
import modele.EtatsStatus.*;

public class Partie {

    private Mot motSecret;
    private int nbEssais;
    private final int MAX_ESSAIS = 6;
    private ArrayList<Resultat> historique;
    private boolean partieTerminee;
    private boolean victoire;

    // Constructeur
    public Partie(Mot secret) {
        this.motSecret = secret;
        this.nbEssais = 0;
        this.historique = new ArrayList<>();
        this.partieTerminee = false;
        this.victoire = false;
    }

    public Resultat analyserTentative(Mot tentative) {

        if (this.partieTerminee) {
            return null;
        }

        this.nbEssais++;
        String motS = this.motSecret.getMot();
        String motT = tentative.getMot();

        Statut[] statutsProvisoires = new Statut[5];

        boolean[] lettresSecretesUtilisees = new boolean[5];

        for (int i = 0; i < 5; i++) {
            if (motT.charAt(i) == motS.charAt(i)) {
                statutsProvisoires[i] = new StatutOk();
                lettresSecretesUtilisees[i] = true;
            }
        }

        for (int i = 0; i < 5; i++) {
            if (statutsProvisoires[i] == null) {

                boolean lettreTrouveeAilleurs = false;
                char lettreTestee = motT.charAt(i);

                for (int j = 0; j < 5; j++) {
                    if (motS.charAt(j) == lettreTestee && lettresSecretesUtilisees[j] == false) {
                        statutsProvisoires[i] = new StatutPresent();
                        lettresSecretesUtilisees[j] = true;
                        lettreTrouveeAilleurs = true;
                        break;
                    }
                }

                if (lettreTrouveeAilleurs == false) {
                    statutsProvisoires[i] = new StatutAbsent();
                }
            }
        }

        ArrayList<Statut> listeDefinitive = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            listeDefinitive.add(statutsProvisoires[i]);
        }

        Resultat resultatDuTour = new Resultat(listeDefinitive);
        this.historique.add(resultatDuTour);

        if (resultatDuTour.isVictoire()) {
            this.victoire = true;
            this.partieTerminee = true;
        } else if (this.nbEssais >= this.MAX_ESSAIS) {
            this.partieTerminee = true;
        }

        return resultatDuTour;
    }

    // Getters
    public int getNbEssais() { return this.nbEssais; }
    public boolean isPartieTerminee() { return this.partieTerminee; }
    public boolean isVictoire() { return this.victoire; }
    public ArrayList<Resultat> getHistorique() { return this.historique; }
}