package Graph;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by harshikesh.kumar on 02/06/16.
 */

//Dijsktra and prims are same
public class Dijkstra {

    static int V;
    static int E;

    static void dijkstra(int arr[][], int src) {
        int distance[] = new int[V];
        int path[] = new int[V];
        for (int i = 0; i < V; i++) {
            distance[i] = -1;
        }

        Queue q = new LinkedList<>();
        q.add(src);
        distance[src] = 0;
        while (!q.isEmpty()) {
            int v = (Integer) q.remove();
            //Add vertex in queue
            for (int u = 0; u < V; u++) {
                //Add distance if it is not found yet and add the vertex in queue
                //else check the minimum
                int total_dist = distance[v] + arr[v][u];
                if ((distance[u] == -1) && arr[v][u] != 0) {
                    distance[u] = total_dist;
                    q.add(u);
                    path[u] = v;
                } else if (arr[v][u] != 0 && distance[u] > total_dist) {
                    distance[u] = total_dist;
                    path[u] = v;
                }
            }
        }
        for (int i = 0; i < V; i++) {
            System.out.println(i + "  " + distance[i]);
        }
        System.out.println();
    }


    public static void main(String[] args) {
        V = 9;
        int graph[][] = {{0, 4, 0, 0, 0, 0, 0, 8, 0},
                {4, 0, 8, 0, 0, 0, 0, 11, 0},
                {0, 8, 0, 7, 0, 4, 0, 0, 2},
                {0, 0, 7, 0, 9, 14, 0, 0, 0},
                {0, 0, 0, 9, 0, 10, 0, 0, 0},
                {0, 0, 4, 0, 10, 0, 2, 0, 0},
                {0, 0, 0, 14, 0, 2, 0, 1, 6},
                {8, 11, 0, 0, 0, 0, 1, 0, 7},
                {0, 0, 2, 0, 0, 0, 6, 7, 0}
        };
        dijkstra(graph, 0);

    }



/*//    Vertex   Distance from Source
    0                0
            1                4
            2                12
            3                19
            4                21
            5                11
            6                9
            7                8
            8                14*/
}
