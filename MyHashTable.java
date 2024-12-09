public class MyHashTable {
    //    The MyHashTable class creates an array of linked lists, and each linked list is a linearly connected linked objects.
    private MyLinkedObject[] table;
    private MyHashFunction hashFunction;

    public MyHashTable(int m, MyHashFunction hashFunction) {
//    The hash table size ‘m’ defines the number of linked lists
        this.table = new MyLinkedObject[m];
        this.hashFunction = hashFunction;
    }

    public void insert(String word) throws Exception {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException("Word cannot be null or empty");
        }

        int index = hashFunction.hash(word);


        if (table[index] == null) {
            table[index] = new MyLinkedObject(word);
        } else {
            // Get word of the first node on the index and check if is alphabetically not smaller than the word to insert
            if (word.compareTo(table[index].getWord()) < 0) {
                // If first node word is smaller than inserted node create a new node
                MyLinkedObject newNode = new MyLinkedObject(word);
                //  Set first node to next node of the created node
                newNode.setNext(table[index]);
                // Set created node as first node
                table[index] = newNode;
            } else {
                // If word is alphabetically larger, use normal setWord
                table[index].setWord(word);
            }
        }
    }

    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            System.out.printf("Bucket %d: ", i);
            MyLinkedObject current = table[i];
            while (current != null) {
                System.out.printf("%s (%s) -> ", current.getWord(), current.getCount(current.getWord()));
                current = current.getNext();
            }
            System.out.println("null");
        }
    }
}
