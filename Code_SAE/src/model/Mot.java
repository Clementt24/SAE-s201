public class Mot {

    private String valeur;
    private static final int TAILLE_MAX = 5;

    public Mot(String valeur) {
        this.valeur = valeur;
    }

    public String getMot() {
        return this.valeur;
    }

    // Méthode statique pour valider un texte avant d'en faire un objet Mot
    public static boolean isValid(String motV) {
        if (motV == null || motV.length() != TAILLE_MAX) {
            return false;
        }

        for (int i = 0; i < TAILLE_MAX; i++) {
            char c = motV.charAt(i);

            // Vérifie si le caractère est bien une lettre
            if (!Character.isLetter(c)) {
                return false;
            }

            // Vérifie qu'il n'y a pas de lettres répétées
            for (int j = i + 1; j < TAILLE_MAX; j++) {
                if (c == motV.charAt(j)) {
                    return false;
                }
            }
        }

        return true; // Si on arrive ici, le mot respecte toutes les règles
    }
}