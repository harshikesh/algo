package datastructure;

import java.util.*;

/**
 * Created by harshikesh.kumar on 05/06/16.
 */
public class Tree {

   public static class Node {
       Node(){

       }
       public Node(int data){
           this.data =data;
       }
        Node left;
        Node right;
        int data;
       Node next;
       int nd;
    }
       static Node insertNode(Node root, int data){

           Node node = new Node();
           node.data = data;
           if(root == null){
               root = node;
               return root;
           }else{

               if(data < root.data)
               {
                   root.left = insertNode(root.left,data);
               }else{
                   root.right = insertNode(root.right,data);
               }
           }
           return root;
        }

        static void printInorder(Node node){
            if(node!=null) {
                printInorder(node.left);
                System.out.print(node.data+" ");
                printInorder(node.right);
            }
        }
static int count = 0;

    static void printNthLargest(Node node,int n){
        if(node!=null) {
            printNthLargest(node.left,n);
            count++;
            if(count == n){
                System.out.print(node.data);
                return;
            }
            printNthLargest(node.right,n);
        }
    }

    static void printDistanceKth(Node node,int n){
        if(node!=null) {
            printNthLargest(node.left,n);
            count++;
            if(count == n){
                System.out.print(node.data);
                return;
            }
            printNthLargest(node.right,n);
        }
    }


    static void printPreOrder(Node node){
        if(node!=null) {
            System.out.print(node.data+" ");
            printPreOrder(node.left);
            printPreOrder(node.right);
        }
    }

    static void printPreOrderWR(Node node){
        if(node!=null) {
            System.out.print(node.data);
            printInorder(node.left);
            printInorder(node.right);
        }
    }

    static void zigZag(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty() || !stack2.isEmpty()){
        while (!stack1.empty()) {
            Node temp = stack1.pop();
            System.out.print(temp.data+" ");
            if (temp.left != null)
                stack2.push(temp.left);
            if (temp.right != null)
                stack2.push(temp.right);
        }
            System.out.println();
        while (!stack2.isEmpty()) {
            Node temp = stack2.pop();
            System.out.print(temp.data+" ");
            if (temp.right != null) {
                stack1.push(temp.right);
            }
            if (temp.left != null)
                stack1.push(temp.left);
        }
            System.out.println();
    }

    }
    static void mirrorTree(Node root){

        if(root != null){
             mirrorTree(root.left);
            mirrorTree((root.right));
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
        }
    }

    static void mirrorTreePreorder(Node root){

        if(root != null){
            Node temp = root.left;
            root.left = root.right;
            root.right = temp;
            mirrorTree(root.left);
            mirrorTree((root.right));
        }
    }

    static void spiralOrder(Node root){

        Stack<Node> st1=new Stack<>(),st2=new Stack<>();

        st1.push(root);
        while(!st1.isEmpty() || !st1.isEmpty()){

            while(!st1.isEmpty()){
               Node n =   st1.pop();
                System.out.println(n.data);
                if(n.right!=null){
                st2.push(n.right);}
                if(n.left!=null){
                    st2.push(n.left);
                }
            }
            while(!st2.isEmpty()){
                Node n =   st2.pop();
                System.out.println(n.data);
                if(n.left!=null){
                st1.push(n.left);}
                if(n.right!=null) {
                    st1.push(n.right);
                }
            }
        }
    }

    static void sumTree(Node root){

        if(root!=null){
            sumTree(root.left);
            sumTree(root.right);

            if(root.left!=null && root.right!=null){
                root.data = root.left.data+root.right.data;
            }
            else if (root.left!=null ){
                root.data = root.left.data;
            } else if(root.right!=null ){
                root.data = root.right.data;
            }
        }
    }

    static boolean isequal(Node root1,Node root2){

        if(root1 == null && root2 ==null){
            return true;
        }

        if(root1 != null || root2 !=null){
            return false;
        }

        if(root1.data != root2.data){
            return false;
        }

        return isequal(root1.left,root2.left) || isequal(root1.right,root2.right);

    }

    static boolean isStructurequal(Node root1,Node root2){

        if(root1 == null && root2 ==null){
            return true;
        }

        if(root1 != null || root2 !=null){
            return false;
        }

        return isequal(root1.left,root2.left) || isequal(root1.right,root2.right);

    }



    static Node lca(Node root,int n1,int n2){

        if(root == null){
            return null;
        }
        if(root.data == n1 || root.data == n2){
            return root;
        }
        Node left = lca(root.left,n1,n2);
        Node right = lca(root.right,n1,n2);
        if(left!=null && right != null){
            return root;
        }
        if(left!=null )return left; else return right;
    }

//    http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
//

//    wo trees are identical.
//    n array which is first increasing and then decreasing, find the index where it changes from increasing to decreasing.
//    LCA in a binary tree.
//    Given an array , find a subarray with the sum closest to zero
//
//    /convert-a-given-tree-to-sum-tree/
//    Generate all permutations for a given string
//    http://www.geeksforgeeks.org/connect-leaves-doubly-linked-list/
//
//    k largest(or smallest) elements in an array | added Min Heap method
//    Count all possible paths from top left to bottom right of a mXn matrix
//    Power(x,y) without loop.
//    A MxN matrix containing integers (positive, negative and zero’s). For every position containing 0, mark the corresponding row and column as 0.
//    http://www.geeksforgeeks.org/maximum-product-subarray/

    static int max =-1;
    static void leftView(Node root,int i){
        if(root == null){
            return;
        }
        if(i>max){
            max = i;
            System.out.print(root.data);
        }
        leftView(root.left,i+1);
        leftView(root.right,i+1);

    }
    static void rightView(Node root,int i){
        if(root == null){
            return;
        }
        if(i > max){
            max = i;
            System.out.print(root.data);
        }
        rightView(root.right,i+1);
        rightView(root.left,i+1);

    }


    static void topView(Node root,int leftMax, HashSet<Integer> set){

        if(root == null){
            return;
        }

        if(!set.contains(leftMax)){
            set.add(leftMax);
            System.out.print(" " + root.data);
        }
        topView(root.left,leftMax-1,set);
        topView(root.right,leftMax+1,set);
    }

    static void bottomView2(Node root){

        HashMap<Integer, Node> hashMap =new HashMap<>();

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        root.nd = 0;
        hashMap.put(0, root);
        while (!queue.isEmpty()){
            Node temp  = queue.poll();
int nd = temp.nd;
            if(temp.left != null) {
                temp.left.nd = nd - 1;
                queue.add(temp.left);
                hashMap.put(nd-1, temp.left);
            }

            if(temp.right != null) {
                temp.right.nd = nd+ 1;
                queue.add(temp.right);
                hashMap.put(nd+1, temp.right);
            }
        }

        for (Map.Entry<Integer,Node> en : hashMap.entrySet()) {
            System.out.print(en.getValue().data+" ");
        }
    }


    static void verticalOrder(Node root){


        HashMap<Integer, Set<Node>> hashMap =new HashMap<>();

        Queue<Node> queue = new LinkedList();
        queue.add(root);
        root.nd = 0;
        Set<Node> set =new HashSet<Node>();
        set.add(root);
        hashMap.put(0,set);
        while (!queue.isEmpty()){
            Node temp = queue.poll();

            int nd = temp.nd;
            if(temp.left != null){
                temp.left.nd = nd-1;
                if(hashMap.containsKey(nd-1)){
                    hashMap.get(nd-1).add(temp.left);
                } else {
                    Set<Node> com =new HashSet<Node>();
                    com.add(temp.left);
                    hashMap.put(nd-1,com);
                }
                queue.add(temp.left);
            }

            if(temp.right != null){
                temp.right.nd = nd+1;
                if(hashMap.containsKey(nd+1)){
                    hashMap.get(nd+1).add(temp.right);
                } else {
                    Set<Node> com =new HashSet<Node>();
                    com.add(temp.right);
                    hashMap.put(nd+1,com);
                }
                queue.add(temp.right);
            }


        }

        for (Map.Entry<Integer, Set<Node>> entry : hashMap.entrySet()) {

            Set st = entry.getValue();
            Iterator<Node> itr = st.iterator();
            while (itr.hasNext()) {
                System.out.print(itr.next().data);
            }
            System.out.println("verical order");
        }
    }

    static void verticalSum(Node node,int hd,HashMap<Integer,Integer> hash){

        if(node == null){
            return;
        }

        int d = hash.get(hd) == null ? 0 : hash.get(hd);
        int sum  = d + node.data;
        hash.put(hd,sum);
        verticalSum(node.left,hd-1,hash);
        verticalSum(node.right,hd+1,hash);
    }

    static boolean childSumProperty(Node node) {

        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.data != (node.left == null ? 0 : node.left.data) + (node.right == null ? 0 : node.right.data)) {
            return false;
        }

        return childSumProperty(node.left) && childSumProperty(node.right);

    }

    static boolean makeChildSumProperty(Node node) {

        if (node == null) {
            return true;
        }

        if (node.left == null && node.right == null) {
            return true;
        }
        if (node.data != (node.left == null ? 0 : node.left.data) + (node.right == null ? 0 : node.right.data)) {
            return false;
        }

        return childSumProperty(node.left) && childSumProperty(node.right);

    }


    static void connectAllAtSameLevel(Node root){

        if(root == null){
            return;
        }

        connectAllAtSameLevel(root.next);

        if(root.left!=null){
            if(root.right!=null){
                root.left.next = root.right;
                root.right.next = findRightNext(root.next);
            } else {
                root.left.next = findRightNext(root.next);
            }
        }else if(root.right!=null){
            root.right.next = findRightNext(root.next);
        }
        connectAllAtSameLevel(root.left);
        connectAllAtSameLevel(root.right);
    }

    private static Node findRightNext(Node next) {

        if(next == null){
            return null;
        }

        if(next.left!=null){
            return next.left;
        } else if(next.right!=null){
            return next.right;
        } else {
            return findRightNext(next.next);
        }
    }

    static void levelOrder(Node root){

        if(root == null){
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        qu.add(root);
        while(!qu.isEmpty()){

            Node node = qu.remove();
            System.out.print(node.data);

            if(node.left != null){
                qu.add(node.left);
            }
            if(node.right != null){
                qu.add(node.right);
            }
        }
    }

    static void bottomView(Node root){
        if(root == null){
            return;
        }
        Queue<Node> qu = new LinkedList<>();
        HashMap<Integer,Node> hashMap  = new HashMap<>();
        root.nd = 0;
        qu.add(root);
        while(!qu.isEmpty()) {
            Node node = qu.remove();
            int nd = node.nd;
            hashMap.put(nd,node);
            if(node.left !=null){
                node.left.nd = nd-1;
                qu.add(node.left);
            }
            if(node.right !=null){
                node.right.nd = nd+1;
                qu.add(node.right);
            }
        }
        Set<Map.Entry<Integer, Node>> set = hashMap.entrySet();
        for (Map.Entry<Integer,Node> r:set) {
            System.out.print(r.getValue().data);
        }
    }


   static Node createTree(int inarra[],int prearr[],int l,int r,int index){


        if(l==r){
            Node node =new Node(inarra[l]);
            return node;
        }

        int pos = searchIndex(inarra,l,r,prearr[index]);

        Node node =new Node(prearr[index]);
        node.left = createTree(inarra,prearr,l,pos-1,index+1);
        node.right = createTree(inarra,prearr,pos+1,r,index+1);

        return node;
    }


    static int searchIndex(int inarr[],int l,int r,int val){
        for (int i = l; i <=r; i++) {
         if(inarr[i] ==val   ){
             return i;
         }
        }
        return -1;
    }


    static int diameter(Node node){

        if(node == null){
            return 0;
        }
        int left = hieght(node.left);
        int right = hieght(node.right);
        int max;
        max = Math.max(left, right);

        return 1+ max;

    }

    static void leftView(Node root,int max,int[] Max){

        if(root == null){
            return;
        }
        if(max > Max[0]){
            Max[0] = max;
            System.out.print(root.data+ " ");
        }
        leftView(root.left,max+1,Max);
        leftView(root.right,max+1,Max);
    }
    static int hieght(Node node){

        if(node == null){
            return 0;
        }
        int left = hieght(node.left);
        int right = hieght(node.right);
        int max;
        max = Math.max(left, right);

        return 1+ max;

    }

    static void convertIntoSumTree(Node node){

    }

    public static void main(String[] args) {


        int values[] = {4, 7, 5,2,3, 8, 9, 1,0};
          Node root = null;
        for (int i = 0; i < values.length; i++) {
            root  = insertNode(root,values[i]);
        }
       // Node noe = lca(root,7,1);
        System.out.println("\nheight : "+hieght(root));
        count =0;
//        System.out.println("inorder : ");
//        printInorder(root);

      //  System.out.println("leftview : ");
       // leftView(root,0,new int[]{-1});
        System.out.println("\ntopView : ");
        topView(root,-1,new HashSet<Integer>());

        System.out.println("\nZigZag");
        zigZag(root);

        //System.out.println("bottomview : ");
       // bottomView2(root);
      //  System.out.println("vertical Order : ");
      //  verticalOrder(root);

//        System.out.println("vertical sum : ");
//        HashMap<Integer,Integer> hashMap =new HashMap<>();
//        verticalSum(root,0,hashMap);
//        for (Map.Entry<Integer,Integer> entry: hashMap.entrySet()) {
//            System.out.println(entry.getKey());
//            System.out.println(entry.getValue());
//        }
        System.out.println("child sum check  : ");
        System.out.println(childSumProperty(root));
        connectAllAtSameLevel(root);


//        System.out.println("\npreorder : ");
//        printPreOrder(root);
//        System.out.println("\nleft view  : ");
//
//        leftView(root,0);
//        System.out.println("\nright view : ");
//        max = -1;
//        rightView(root,0);
//        System.out.println("\nbottom view : ");
//        bottomView(root);
//        System.out.println("\nLevel order : ");
//        levelOrder(root);
//        System.out.println();
//        Node node = lca(root,9,8);
//        System.out.println(node.data);

      // System.out.println("Mirror pre order");


       // mirrorTreePreorder(root);

//        System.out.println("inorder : ");
//       // printInorder(root);
//        System.out.println("\npreorder : ");
//        printPreOrder(root);


        int in[] = {3,6,7,8,12,14,18};
        int pre[] = {8,6,3,7,12,14,18};
//        Node node = createTree(in,pre,0,6,0);
//
//        System.out.println("inorder : ");
//        printInorder(node);
//        System.out.println("\npreorder : ");
//        printPreOrder(node);

       // mirrorTree(root);
       // printInorder(root);
        //System.out.println();
        //printPreOrder(root);
        /*
        sumTree(root);
        printInorder(root);
        System.out.println();
        printPreOrder(root);
        System.out.println();*/

        //spiralOrder(root);
    }

}
