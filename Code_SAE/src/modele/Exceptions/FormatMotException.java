package modele.Exceptions;

public class FormatMotException extends Exception {

    private String mot;

    //COnstructeur d'erreur
    public FormatMotException(String m) {
        super();
        this.mot = m;
    }

    //Getters
    public String getMot()
    {
        return this.mot;
    }

    //méthodes de base
    public String toString()
    {
        return "Le mot : " + this.mot + " n'es pas conforme, le mot doit étre entierement constitué de" +
                "lettres, plusieurs lettres du mot ne peuvent pas etre similaire.";
    }
}