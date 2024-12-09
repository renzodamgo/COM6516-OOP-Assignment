public class MyLinkedObject {

    private String word;
    private int count;
    private MyLinkedObject next;

    public MyLinkedObject(String w) {
        this.word = w;
        this.count = 0;
        this.next = null;
    }

    public void setWord(String w) throws Exception {
//        The important assumption here is that the parameter w is alphabetically not smaller than the word field of
//        this object. You may consider use of error handling if w violates the above assumption.
        int comparison = w.compareTo(this.word);
        if (comparison < 0) {
            System.out.println(w + " is not a valid word");
            throw new Exception("Word cant be alphabetically smaller than the class word");
        } else if (comparison == 0) {
//            It increments count if w is equal to word.
            this.count = this.count + 1;
        } else {
//            If w and word are not equal and if the next object does not exist (i.e., next is null), it
//            creates a new object for w, that is linked to the next field of this object.
            if (this.next == null) {
                this.next = new MyLinkedObject(w);
            } else {
//            If the next object exists, and if w is
//            alphabetically smaller than the word field of the next object, it creates a new object for w, and that object is
//            inserted between this and the next objects.
                int newComparison = w.compareTo(this.next.word);
                if (newComparison < 0) {
                    MyLinkedObject newNode = new MyLinkedObject(w);
                    newNode.next = this.next;
                    this.next = newNode;
                } else {
//                    Otherwise w is passed on to the next object — you may note the
//                    use of a recursive structure, eg, next.setWord(w), within the setWord method of this object.
                    this.next.setWord(w);
                }
            }
        }
    }

    public boolean isWord(String w) {
        if (this.word.equals(w)) {
//            This method returns true if the parameter w matches the word field of this object.
            return true;
        }
        if (this.next != null) {
//            If this object does not
//            match w, and if the next object exists, it tests the next object using recursive coding.
            return this.next.isWord(w);
        }
//        If this object does not
//        match w, and if the next object does not exist (i.e., null), it returns false.
        return false;
    }

    public int getCount(String w) {
//        This method returns the value stored in the countfield if the parameter wmatches the wordfield of this object.
        if (this.word.equals(w)) {
            return this.count;
        }
//        f this object does not match w, and if the next object exists, it tests the next object using recursive coding. I
        if (this.next != null) {
            return this.next.getCount(w);
        }
//        If this object does not match w, and if the next object does not exist (i.e., null), it returns 0 (zero).
        return 0;
    }

    public String getWord() {
        return this.word;
    }

    public MyLinkedObject getNext() {
        return this.next;
    }

    public void setNext (MyLinkedObject next) {
        this.next = next;
    }
}
