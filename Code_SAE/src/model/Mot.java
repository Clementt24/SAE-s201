public class Mot {

    private String mot;
    private static final int TAILLE_MAX = 5;

    //Constructeurs
    public Mot(String motC)
    {
        if motIsValid(String motC)
        {
            this.mot = motC;
            System.out.println("Le mot est appliqué avec succes)");
        }
        else
        {
            System.out.println("Impossible, le mot n'est pas correct, pour rappel il doit avoir 5 lettres uniques.");
        }
    }

    //Getters
    public String getMot()
    {
        return this.mot;
    }

    //Conditions
    private boolean motIsValid(String motV)
    {
        if (motV.lenghts > TAILLE_MAX)
        {
            return false;
        }

        for (int i; i < TAILLE_MAX; i++)
        {
            char c = motV.charAt(i);

            if (!Character.isLetter(c))
            {
                return false;
            }
        }

        return true;
    }
}