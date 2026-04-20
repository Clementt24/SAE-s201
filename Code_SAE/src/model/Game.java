import java.utils;

public class Game {

    public static int COMPTEUR = 0;
    public static final int ESSAIES_MAX = 6;

    public Game(Mot motSecret)
    {
        new Mot m1 = Mot(motSecret);
        new ArrayList<> p = ;//finir
        this.COMPTEUR = 0;
    }

    public Resultat jouer(Mot essai)
    {

    }

    //Getters
    public int getEssaiActuel()
    {
        return COMPTEUR;
    }

    public Mot getMotSecret()
    {
        return super.getMot();
    }

    //Calculateurs
    public int calculateScore()
    {
        return 7 - COMPTEUR;
    }

    //Comparateurs
    public boolean isGameOver()
    {
        if (COMPTEUR >= ESSAIES_MAX)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    public boolean isWon()
    {
        return "Victoire";
    }


}