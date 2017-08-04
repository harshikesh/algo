package datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 25/05/17.
 */
public class Dijkstra {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int mat[][] = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            mat[a][b] = c;
            mat[b][a] = c;
        }
        findDistance(mat,1,n+1);
    }

    private static void findDistance(int[][] mat,int start,int size) {

        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[mat[0].length+1];
        int[] dist = new int[mat[0].length+1];
        queue.add(start);

        while (!queue.isEmpty()){

            int node = queue.remove();
            visited[node] =true;

            for (int i = 1; i < size; i++) {

                int totalDist = dist[node] + mat[node][i];
                if(!visited[i] &&  mat[node][i] != 0){
                    visited[i] = true;
                    queue.add(i);
                    dist[i] = totalDist;
                } else if(mat[node][i] != 0) {
                    dist[i] = totalDist < dist[i] ? totalDist : dist[i];
                }
            }
        }
        for (int i = 0; i < size; i++) {
            System.out.println(dist[i]);
        }

    }
}
