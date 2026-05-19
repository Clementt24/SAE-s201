package modele.EtatsStatus;

//imports
import modele.Statut;

public class StatutPresent extends Statut {

    public StatutPresent() {
        super("PRESENT", false);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        StatutPresent autre = (StatutPresent) obj;
        return this.getTexte().equals(autre.getTexte()) && this.isGagnant() == autre.isGagnant();
    }

    public String toString()
    {
        return "Statut de la lettre : Présente mais mal placée";
    }
}