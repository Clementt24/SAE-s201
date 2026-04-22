public class FixedWordRepository {

    // Pour nos tests, le mot secret sera toujours "LIGNE"
    public Mot getWord() {
        return new Mot("ligne");
    }
}