public class Joueur {

    private String nom;
    private int score;

    public Joueur(String nom) {
        this.nom = nom;
        this.score = 0; // Le score commence toujours à 0
    }

    public String getNom() {
        return this.nom;
    }

    public int getScore() {
        return this.score;
    }

    public void addPoints(int points) {
        this.score += points;
    }
}