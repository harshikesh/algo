package datastructure;

import java.util.HashMap;

/**
 * Created by harshikesh.kumar on 04/06/16.
 */


public class LRU {

    private static Node head;
    private static Node last;

    static class Node {
        int value;
        Node next;
        Node prev;
    }

   static HashMap<Integer,Node> hash = new HashMap<>();

    static void insertInLRU(int value){
        Node node;
        if(hash.containsKey(value)){
            node = hash.get(value);
            removeNode(node);
            setHead(node);
        } else  {
            node = new Node();
            node.value = value;
            hash.put(value,node);
            if(hash.size() < 4){
                setHead(node);
            } else {
                removeNode(last);
                setHead(node);
            }
        }

        Node temp = head;
        for (int i = 0; i < 6; i++) {
            System.out.print(temp.value+",");
            temp = temp.next;
            if(temp == null){
                break;
            }
        }
        System.out.println();

    }

    private static void setHead(Node node) {
        node.next = head;
        node.prev = null;

        if(head != null) {
            head.prev = node;
        }
        head = node;

        if(last == null){
            last = head;
        }
    }

    private static void removeNode(Node node) {
        if(node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
        if(node.next != null) {
            node.next.prev = node.prev;
        } else {
            node.next = last;
        }
    }

    public static void main(String[] args) {
        insertInLRU(4);
        insertInLRU(5);
        insertInLRU(6);
        insertInLRU(4);
        insertInLRU(42);
        insertInLRU(24);
        insertInLRU(4);
        insertInLRU(49);
        insertInLRU(6);
        insertInLRU(7);
        insertInLRU(49);
        insertInLRU(49);
    }
}
