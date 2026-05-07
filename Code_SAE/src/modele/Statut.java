package modele;

public class Statut {

    private boolean statut;
    private String texte;

    //constructeurs
    Statut()
    {
        this.statut = true;
        this.texte = "Aucun statut";
    }

    Statut(boolean newStatut, String nexText)
    {
        this.statut = newStatut;
        this.texte = nexText;
    }

    //setters
    public void setStatut(boolean newStatut)
    {
        this.statut = newStatut;
    }

}