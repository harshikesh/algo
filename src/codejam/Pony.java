package codejam;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 22/04/17.
 */
public class Pony {


    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";
    static int V;
    static class Horse{
        Horse(int d,int s){
            distance =d;
            speed =s;
        }
     int distance =0;
        int speed =0;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {

            int N = sc.nextInt();
            int Q = sc.nextInt();
            V = N+1;
            HashMap<Integer,Horse> hashMap =new HashMap<>();

            for (int j = 1; j <= N; j++) {

                int D = sc.nextInt();
                int S = sc.nextInt();
                hashMap.put(j,new Horse(D,S));
            }

            double mat[][] =new double[N+1][N+1];
            for (int j = 1; j <N+1; j++) {
                for (int k = 1; k < N+1; k++) {
                    mat[j][k] = sc.nextInt()/((Integer) hashMap.get(j).speed*1.0);
                }
            }

            for (int j = 0; j < Q; j++) {
                int sou = sc.nextInt();
                int des = sc.nextInt();
                dijkstra(mat,sou,des);
            }
        }
    }
    static int dijkstra(double graph[][], int src,int dis) {
        double dist[] = new double[V];
        boolean sptSet[] = new boolean[V];
        int parent [] = new int [V];
        for (int i = 0; i < V; i++)
        {
            parent[0] = -1;
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }

        dist[src] = 0;

        // Find shortest path for all vertices
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet);

            sptSet[u] = true;

            // Update dist value of the adjacent vertices of the
            // picked vertex.
            for (int v = 1; v < V; v++)

                if (!sptSet[v] && graph[u][v] > 0 &&
                        dist[u] + graph[u][v] < dist[v]) {
                    parent[v]  = u;
                    dist[v] = dist[u] + graph[u][v];
                }
        }

        printSolution(dist, V, parent,src);
        return 0;
    }

    static int minDistance(double dist[], boolean sptSet[])
    {
        // Initialize min value
        double min = Integer.MAX_VALUE;int min_index=0;

        for (int v = 1; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    static void printPath(int parent[], int j)
    {
        // Base Case : If j is source
        if (parent[j]==0)
            return;

        printPath(parent, parent[j]);

        System.out.print(j+" ");
    }

    // A utility function to print the constructed distance
// array
    static int printSolution(double dist[], int n, int parent[],int src)
    {
        System.out.println("Vertex\t  Distance\tPath");
        for (int i = 1; i < V; i++)
        {
            System.out.print( src+" "+ i+" " +" "+dist[i]+" "+ src+" ");
            printPath(parent, i);
            System.out.println();
        }
        return 0;
    }
}
