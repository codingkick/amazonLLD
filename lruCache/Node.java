package questions.lruCache;

public class Node {
    private int key;
    private int value;
    private Node prev;
    private Node next;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }

    public int getValue(){
        return this.value;
    }

    public void setValue(int value){
        this.value = value;
    }

    public int getKey(){
        return this.key;
    }

    public Node getNext(){
        return this.next;
    }

    public Node getPrev(){
        return this.prev;
    }

    public void setNext(Node next){
        this.next = next;
    }

    public void setPrev(Node prev){
        this.prev = prev;
    }
}
