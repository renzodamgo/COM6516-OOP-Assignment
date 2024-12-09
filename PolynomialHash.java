public class PolynomialHash extends MyHashFunction {
    private final int base = 31;              // Base value (A)
    private final long prime = 1000000007L; // Prime modulus (P)

    public PolynomialHash(int m) {
        super(m);
    }

    @Override
    public int hash(String str) {
        long hash = 0;
        long power = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            hash = (hash + (str.charAt(i) * power) % prime) % prime;
            power = (power * base) % prime;
        }
        return  (int) hash % this.tableSize;
    }
}
