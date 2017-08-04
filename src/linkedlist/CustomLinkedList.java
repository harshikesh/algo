package linkedlist;

/**
 * Created by harshikesh.kumar on 12/07/16.
 */
public class CustomLinkedList {

    public static class Node{
        int val;
        Node next;
    }


    static Node reverse(Node node , int k){

        Node prev = null;
        Node curr = node;
        Node next = null;
        int l = k;

        while(curr!=null){
                next =curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;

        }
        return prev;
    }

    static Node reverseK(Node node , int k){

        Node prev = null;
        Node curr = node;
        Node next = null;
        int count = 0;

        while(curr!=null && count < k){
            count++;
                next =curr.next;
                curr.next = prev;
                prev = curr;
                curr = next;
        }
        if(next !=null ){
            node.next = reverse(next,k);
        }
        return prev;
    }


    static void reverseK2(Node node , int k){

        Node prev = null;
        Node curr = node;
        if(curr == null || curr.next == null){
            return;
        }
        int count = 0;
        while(count < k){
            count++;
            Node next =curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node temp =  node.next;
       reverse(temp,k);
        node.next = temp;
    }


    static Node insertNode(Node n, int val){

        Node node = n;
        Node temp = new Node();
        temp.val = val;
        if(node == null){
            node = temp;
            return node;
        } else {
            while(node.next!=null){
                node = node.next;
            }
            node.next = temp;
            temp.next = null;
        }
        return n;
    }

    static void printNode(Node node){

        while (node!=null){
            System.out.println("val  "+node.val);
            node = node.next;
        }
    }

    public static void main(String[] args) {

        Node root = null;
       root =  insertNode(root,4);
       root =  insertNode(root,5);
       root =  insertNode(root,6);
       root =  insertNode(root,7);
        printNode(root);
        Node rev = reverse(root,3);
        System.out.println("reverse");
        printNode(rev);
        System.out.println("reverse in k size");
        Node revv = reverseK(rev,3);
        System.out.println("reverse in dsjhgfkjh size");

        reverseK2(rev,4);

        printNode(rev);

    }
}
