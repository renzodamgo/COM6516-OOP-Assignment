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
            throw new Exception("Word cant be alphabetically smaller than the set");
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


        this.word = w;
    }

    public String getWord() {
        return this.word;
    }
}
