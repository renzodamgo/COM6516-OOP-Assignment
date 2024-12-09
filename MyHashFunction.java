public abstract class MyHashFunction {
    protected long tableSize;

    public MyHashFunction(long m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Hash table size must be positive");
        }
        this.tableSize = m;
    }

    public abstract long hash(String word);
}