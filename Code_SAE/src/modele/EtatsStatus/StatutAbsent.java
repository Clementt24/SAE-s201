package modele.EtatsStatus;

import modele.Statut;

public class StatutAbsent extends Statut {

    public StatutAbsent() {
        super("ABSENT", false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        StatutAbsent autre = (StatutAbsent) obj;
        return this.getTexte().equals(autre.getTexte()) && this.isGagnant() == autre.isGagnant();
    }

    public String toString() {
        return "Statut de la lettre : Absente du mot secret";
    }
}