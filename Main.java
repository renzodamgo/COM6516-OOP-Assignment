public class Main {
    public static void main(String[] args) throws Exception {
//        int tableSize = 10;
//        String[] testWords = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};
//
//        MyHashFunction firstLetterHash = new FirstLetterHash(tableSize);
//
//        System.out.println("First Letter Hash:");
//        for (String word : testWords) {
//            System.out.printf("Word: %s, Hash: %d%n", word, firstLetterHash.hash(word));
//        }
//
//        MyHashFunction additiveHash = new AdditiveHash(tableSize);
//        System.out.println("Additive Hash:");
//        for (String word : testWords) {
//            System.out.printf("Word: %s, Hash: %d%n", word, additiveHash.hash(word));
//        }
//
//        MyHashFunction polynomialHash = new PolynomialHash(tableSize);
//        System.out.println("Polynomial Hash:");
//        for (String word : testWords) {
//            System.out.printf("Word: %s, Hash: %d%n", word, polynomialHash.hash(word));
//        }
        int tableSize = 7; // Prime number for better distribution
        MyHashFunction hashFunction = new FirstLetterHash(tableSize);
        MyHashTable hashTable = new MyHashTable(tableSize, hashFunction);

        // Test insertions
        String[] words = {"peach", "papaya", "pablo","pear", "pan"};
        for (String word : words) {
            hashTable.insert(word);
        }

        // Print table contents
        System.out.println("Hash Table Contents:");
        hashTable.printTable();
    }
}
