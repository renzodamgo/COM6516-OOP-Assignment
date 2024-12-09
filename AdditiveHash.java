public class AdditiveHash extends MyHashFunction {
    public AdditiveHash(long m) {
        super(m);
    }

    @Override
    public long hash(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }
        int sum = 0;
        for (char c : word.toCharArray()) {
            sum += c;
        }
        return sum % tableSize;
    }
}