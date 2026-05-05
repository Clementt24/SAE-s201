package modele;

public class Joueur {

    public static int SCORE = 0;
    public static String NOM_JOUEUR = "Invité"; //Le nom du joueur par default sera invité.

    private void setNomJoueur(String j)
    {
        this.NOM_JOUEUR = j;
        //TODO implementer verification pour modifier le nom du joueur
    }

    private void setScore(int newscore)
    {
        this.SCORE = newscore;
    }

}