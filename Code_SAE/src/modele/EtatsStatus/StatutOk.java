package modele.EtatsStatus;

//imports
import modele.Statut;

public class StatutOk extends Statut {

    public StatutOk() {
        super("OK", true);
    }

    //méthodes de base
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        StatutOk autre = (StatutOk) obj;
        return this.getTexte().equals(autre.getTexte()) && this.isGagnant() == autre.isGagnant();
    }

    public String toString()
    {
        return "Statut de la lettre : Correct et bien placé";
    }
}