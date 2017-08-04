package datastructure;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by harshikesh.kumar on 25/05/17.
 */
public class TopoSort {

    public static void main(String[] args) {

        Scanner sc =new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int arr[][] = new int[n+1][n+1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            arr[a][b] = 1;
        }
        int vis[] =new int[n+1];
        getTopSort(arr,vis);
    }



    private static void getTopSort(int[][] arr,int vis[]) {
        Stack<Integer> st = new Stack<>();
        for (int i = 0; i <arr[0].length; i++) {
            if(vis[i] == 0){
                topoUtil(arr,vis,i,st);
            }
        }
        int size = st.size();
        for (int i = 0; i < size; i++) {
            System.out.println(st.pop());
        }
    }

    private static void topoUtil(int[][] arr, int[] vis,int j,Stack st) {
        vis[j] = 1;
        for (int i = 0; i < arr[0].length; i++) {
           if(arr[j][i] == 1 && vis[i] == 0){
               topoUtil(arr,vis,i,st);
           }
        }
        st.push(j);
    }
}
