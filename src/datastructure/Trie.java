package datastructure;

/**
 * Created by harshikesh.kumar on 16/06/16.
 */
public class Trie {

    private final Node mRoot;

    Trie(){
        mRoot = new Node();
    }

    class Node{
        boolean isLeaf;
        Node child[] = new Node[256];
        int count;
        int minHeapPos = -1;
        String str;
    }

    Node insertNode(String str){

        int len = str.length();
        Node temp = mRoot;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if(temp.child[c-'a'] !=null){
                temp = temp.child[c-'a'];
            } else {
                Node node = new Node();
                temp.child[c-'a'] = node;
                temp = node;
            }
        }
        temp.count++;
        temp.isLeaf = true;
        return temp;
    }

    boolean isPresent(String str) {

        int len = str.length();
        Node temp = mRoot;
        for (int i = 0; i < len; i++) {
            char c = str.charAt(i);
            if (temp.child[c - 'a'] != null) {
                temp = temp.child[c - 'a'];
                System.out.print(c+", ");
            } else {
                return false;
            }
        }
        if(temp.isLeaf) {
            return true;
        } else {
            return false;
        }
    }

}
