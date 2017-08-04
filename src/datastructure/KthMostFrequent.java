package datastructure;

/**
 * Created by harshikesh.kumar on 15/06/16.
 */

/*use Trie and Min Heap*/
public class KthMostFrequent {

    static Trie.Node heap[] = new Trie.Node[10];
    static int top = 0;
    static Trie trie = new Trie();

    static void insertMinHeap(Trie.Node leaf, String str) {
        if (top == 10) {
            top = 10;
        } else {
            top++;
        }
        heap[top] = leaf;
        heap[top].str = str;
        buildHeap(top);

    }

    static void buildHeap(int top) {
        int parent = 1;
        int temp = top;

        while (parent > 0) {
            if (heap[parent].count < heap[temp].count) {
                Trie.Node n = heap[temp];
                heap[temp] = heap[parent];
                heap[parent] = n;
                heap[parent].minHeapPos = temp;
                heap[temp].minHeapPos = parent;
            } else {
                heap[parent].minHeapPos = parent;
                heap[temp].minHeapPos = temp;
                break;
            }
            temp = parent;
            parent = temp / 2;
        }
    }


    private static void minHeapify(int parent) {
        int left = parent * 2;
        int right = parent * 2 + 1;
        while (left <= top && right <= top) {

            if (heap[left].count < heap[right].count) {
                Trie.Node n = heap[parent];
                heap[parent] = heap[left];
                heap[left] = n;
                heap[parent].minHeapPos = parent;
                heap[left].minHeapPos = left;
                parent = left;
            } else {
                Trie.Node n = heap[parent];
                heap[parent] = heap[right];
                heap[right] = n;
                heap[parent].minHeapPos = parent;
                heap[right].minHeapPos = right;
                parent = right;
            }
            left = parent * 2;
            right = parent * 2 + 1;
        }
    }

    private static void removeElementFromMinHeap() {
        int parent = 1;
        int left = parent * 2;
        int right = parent * 2 + 1;
        while (left < top && right < top) {

            if (heap[left].count < heap[right].count) {
                heap[parent] = heap[left];
                heap[parent].minHeapPos = parent;
                parent = left;
            } else {
                heap[parent] = heap[right];
                heap[parent].minHeapPos = parent;
                parent = right;
            }
            left = parent * 2;
            right = parent * 2 + 1;
        }
    }

    static Trie.Node getTop() {
        return heap[1];
    }

    public static void KthMost(String str) {
        Trie.Node leaf = trie.insertNode(str);

        if (leaf.minHeapPos != -1) {
            minHeapify(leaf.minHeapPos);
        } else if (top < 10) {
            insertMinHeap(leaf, str);
        } else if (getTop().count < leaf.count) {
            removeElementFromMinHeap();
            insertMinHeap(leaf, str);
        }

        System.out.print(getTop().count + " " + getTop().minHeapPos + " " + getTop().str + ", ");
    }


    public static void main(String[] args) {
        KthMost("hello");
        KthMost("what");
        KthMost("football");
        KthMost("hello");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("hellfo");
        KthMost("football");
        KthMost("football");
        KthMost("what");

//        System.out.println(trie.isPresent("football"));
//        System.out.println(trie.isPresent("hello"));
//        System.out.println(trie.isPresent("what"));
    }
}
