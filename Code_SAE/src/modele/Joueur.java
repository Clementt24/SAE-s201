package modele;

public class Joueur {

    private String pseudo;
    private int score;

    public Joueur(String pseudo) {
        this.pseudo = pseudo;
        this.score = 0;
    }

    public String getPseudo() {
        return this.pseudo;
    }

    public int getScore() {
        return this.score;
    }

    public void ajouterPoints(int points) {
        this.score += points;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        Joueur autre = (Joueur) obj;
        return this.pseudo.equals(autre.getPseudo());
    }

    public String toString() {
        return "Joueur : " + this.pseudo + " | Score total : " + this.score + " points";
    }
}