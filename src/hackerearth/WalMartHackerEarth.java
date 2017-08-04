package hackerearth;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import static hackerearth.Walmart.max;

/**
 * Created by harshikesh.kumar on 22/08/16.
 */

//7
//        6
//        1 5 9
//        2 5 5
//        3 6 1
//        4 6 3
//        5 7 7
//        6 7 4
public class WalMartHackerEarth {


    private static int[] countarray;
    private static int rootNode;

    private static int[] parent;
    private static int[] child;
    private static int[] value;
    private static int M;
    private static int N;
    static int maximum = 9999999;
    private static ArrayList<Integer> leafNodes = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc  = new Scanner(System.in);
        int[] arr;
         N  = sc.nextInt();
         M = sc.nextInt();
        parent = new int[M+1];
        child = new int[M+1];
        value = new int[M+1];
        countarray = new int[N+1];

        for (int i = 1; i <= M; i++) {
            child[i] = sc.nextInt();
            parent[i] = sc.nextInt();
            value[i] = sc.nextInt();
                countarray[child[i]] +=1;
                countarray[parent[i]] +=1;
            if(i == M){
                rootNode = parent[i];
            }
        }
        for (int i = 1; i <=N; i++) {
            if(countarray[i]==1){
                leafNodes.add(i);
            }
        }
        ArrayList<String> pathlist = calculate();
        System.out.println(maximum);
        for (String path: pathlist) {
           System.out.println(path);
        }
        
    }


    private static ArrayList<String> calculate() {
        int loopm = (M)/2;
        ArrayList<String> pathlist = new ArrayList<>();
        for (Integer l:leafNodes) {

            int count = value[l];
            int val  = value[l];
            String path=""+l;
            int p =-1;
            while(p != parent[M]){
            if(l%2 == 0){
                count = count + (val>value[l-1] ? val+value[l-1] : val*2);
            } else {
                count = count + (val>value[l+1] ? val+value[l+1] : val*2);
            }
                p = parent[l];
                if(p!=parent[M]) {
                    val = value[p];
                    count= count +val;
                }
                l = p;
                path = path+" -> "+p;
            }

            //System.out.println(count +" : path :"+ path);
            if(count <= maximum){
                if(count < maximum){
                    pathlist.clear();
                    pathlist.add(path);
                } else {
                    pathlist.add(path);
                }
                maximum = count;
            }
        }

        return pathlist;
    }

}
