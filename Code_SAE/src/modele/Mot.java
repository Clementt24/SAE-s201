package modele;

//IMports
import modele.Exceptions.*;

public class Mot {

    private String mot;
    public static final int TAILLE_MAX = 5;

    //COnstructeur
    public Mot(String m) {

        try
        {
            this.setMot(m);
        }

        catch (Exception e)
        {
            System.out.println("Impossible le mot saisis est incorect. " + "\n" +
                               "Il y'a l'erreur suivante : " + e         + "\n" +
                               " "                                       + "\n" +
                               "Veuillez ressaisir votre mot.."          + "\n");
        }
    }

    // Setter
    private void setMot(String m) throws LongueurMotException, FormatMotException
    {
        // Verification de la longueur
        if (m == null || m.length() != TAILLE_MAX)
        {
            throw new LongueurMotException(m.length());
        }

        // Verification du format
        for (int i = 0; i < TAILLE_MAX; i++)
        {
            char c = m.charAt(i);

            if (!Character.isLetter(c))
            {
                throw new FormatMotException(m);
            }

            for (int j = i + 1; j < TAILLE_MAX; j++)
            {
                if (c == m.charAt(j))
                {
                    throw new FormatMotException(m);
                }
            }
        }

        this.mot = m;
    }

    //Getters
    public String getMot() {
        return this.mot;
    }

    @Override
    public String toString() {
        return "Le mot saisi par le joueur est : " + this.mot;
    }
}