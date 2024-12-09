public class Main {
    public static void main(String[] args) {
        int tableSize = 10;
        String[] testWords = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

        MyHashFunction firstLetterHash = new FirstLetterHash(tableSize);

        System.out.println("First Letter Hash:");
        for (String word : testWords) {
            System.out.printf("Word: %s, Hash: %d%n", word, firstLetterHash.hash(word));
        }

        MyHashFunction additiveHash = new AdditiveHash(tableSize);
        System.out.println("Additive Hash:");
        for (String word : testWords) {
            System.out.printf("Word: %s, Hash: %d%n", word, additiveHash.hash(word));
        }

        MyHashFunction polynomialHash = new PolynomialHash(tableSize);
        System.out.println("Polynomial Hash:");
        for (String word : testWords) {
            System.out.printf("Word: %s, Hash: %d%n", word, polynomialHash.hash(word));
        }
    }
}
