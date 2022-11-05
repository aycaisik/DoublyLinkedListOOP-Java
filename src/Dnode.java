public class Dnode<T extends Comparable> {
    public T value;
    public Dnode<T> next, prev;
    // public node<T> prev; // sil bunu sen koydun

    public Dnode(T val) { //constrctr
        this.value = val;
        this.next = null;
        this.prev = null;
    }


    public String toString() {
        return String.valueOf(this.value);

    }
}
