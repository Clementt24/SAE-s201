package donnees;

// Imports de .jar
import words.WordSet;
import words.JsonWordSet;

import modele.Mot;
import modele.Exceptions.LongueurMotException;
import modele.Exceptions.FormatMotException;

public class RepertoireMots {

    private WordSet dictionnaire;

    public RepertoireMots(String cheminFichier) throws Exception
    {
        this.dictionnaire = new JsonWordSet(cheminFichier);
    }

    public Mot getMotAleatoire() throws LongueurMotException, FormatMotException
    {
        String motTire = this.dictionnaire.random();

        return new Mot(motTire.toUpperCase());
    }

    public Mot getMotFixe(int index) throws LongueurMotException, FormatMotException
    {
        String motTire = this.dictionnaire.word(index);

        return new Mot(motTire.toUpperCase());
    }

    public int getTailleDictionnaire() {
        return this.dictionnaire.size();
    }
}