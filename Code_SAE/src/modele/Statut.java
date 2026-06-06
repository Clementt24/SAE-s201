package modele;

public abstract class Statut {

    private String texte;
    private boolean gagnant;

    // Constructeur
    public Statut(String texte, boolean gagnant) {
        this.texte = texte;
        this.gagnant = gagnant;
    }

    // Getters
    public String getTexte() {
        return this.texte;
    }

    public boolean isGagnant() {
        return this.gagnant;
    }

    // Méthodes
    public boolean equals(Object c) {
        if (c == null) {
            return false;
        }
        if (this.getClass() != c.getClass()) {
            return false;
        }

        Statut autre = (Statut) c;
        return this.texte.equals(autre.getTexte())
                && this.gagnant == autre.isGagnant();
    }

    public String toString() {
        return "Informations du Status (Texte : " + this.texte + ", Condition de victoire : " + this.gagnant + ")";
    }
}