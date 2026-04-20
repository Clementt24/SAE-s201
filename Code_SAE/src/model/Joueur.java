public class Joueur {

    private static String NOM_JOUEUR = "...";
    private static final
    private static int SCORE = "0";

    public Player(String nomC)
    {
        if (nomC.isNomValide())
        {
            this.NOM_JOUEUR = nomC;
        }
        else
        {
            System.out.println("Imoossible le nom du joueur doit contenir moins de 10 caractères, le nom: " + nomC + " ne respecte pas cette contrainte.")
        }
    }

    //Getters
    public String getName()
    {
        return NOM_JOUEUR;
    }

    public int getScore()
    {
        return SCORE;
    }

    //Setters
    public void addPoints(int ajouts)
    {
        this.SCORE += ajouts;
    }

    //Verificateur
    private boolean isNomValide(String nomV)
    {
        if (nomV > 10)
        {
            return false;
        }
    }

}