public class FirstLetterHash extends MyHashFunction {
    public FirstLetterHash(int m) {
        super(m);
    }

    @Override
    public int hash(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        return word.charAt(0) % tableSize;
    }
}