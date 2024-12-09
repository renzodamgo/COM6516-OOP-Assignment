public class Main {
    public static void main(String[] args) {
        int tableSize = 10;
        String[] testWords = {"apple", "banana", "cherry", "date", "elderberry", "fig", "grape"};

        MyHashFunction firstLetterHash = new FirstLetterHash(tableSize);

        System.out.println("First Letter Hash:");
        for (String word : testWords) {
            System.out.printf("Word: %s, Hash: %d%n", word, firstLetterHash.hash(word));
        }
    }
}
