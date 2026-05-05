package modele.Exceptions;

import modele.Mot;

public class LongueurMotException extends Exception {

    private int longeur;

    //COnstructeur d'erreur
    public LongueurMotException(int l) {
        super();
        this.longeur = l;
    }

    //Getters
    public int getLongeur()
    {
        return this.longeur;
    }

    public String toString()
    {
        return "La longeur du mot (" + this.longeur + " caracteres ) n'est pas conforme, la longeur minimale / maximale du mot est : "
                + Mot.TAILLE_MAX + " caractères.";
    }
}