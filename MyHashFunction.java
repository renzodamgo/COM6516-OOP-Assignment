public abstract class MyHashFunction {
    protected int tableSize;

    public MyHashFunction(int m) {
        if (m <= 0) {
            throw new IllegalArgumentException("Hash table size must be positive");
        }
        this.tableSize = m;
    }

    public abstract int hash(String word);
}