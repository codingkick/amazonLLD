package questions.lruCache;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private int capacity;
    private Node head;
    private Node tail;
    private Map<Integer, Node> cache;
    LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        head.setNext(tail);
        tail.setPrev(head);
        this.cache = new HashMap<>();
    }

    public synchronized int get(int key) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(head);
            node.setNext(head.getNext());
            head.getNext().setPrev(node);
            head.setNext(node);
            return node.getValue();
        }
        else
            return -1;
    }
     public synchronized void put(int key,int value){
        if(this.cache.containsKey(key)){
            Node node = cache.get(key);
            node.setValue(value);
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
            node.setPrev(head);
            node.setNext(head.getNext());
            head.getNext().setPrev(node);
            head.setNext(node);
        }
        else{
            if(cache.size() == capacity){
                Node node = tail.getPrev();
                this.cache.remove(node.getKey());
                tail.setPrev(tail.getPrev().getPrev());
                tail.getPrev().setNext(tail);
            }
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            newNode.setPrev(head);
            newNode.setNext(head.getNext());
            head.getNext().setPrev(newNode);
            head.setNext(newNode);
        }
     }
}
