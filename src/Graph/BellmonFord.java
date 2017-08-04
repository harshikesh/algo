/**
 * Created by harshikesh.kumar on 02/06/16.
 *//*

public class BellmonFord {


    private static  int V ;



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
        bellmonFord(graph, 0);

    }

    private static void bellmonFord(int[][] graph, int src) {

        int[] dist =  new int[V];
        for(int i =0;i<V ;i++){
            dist[i] = 99999;
        }
        dist[src] = 0;

        for(int i=0;i<V-1;i++){
            for (int j = 0; j < E; j++) {
                if(dist[j]!= 9999 && dist[j] + graph[i][j] < dist[j]) {
                dist[j] =  dist[j] + graph[i][j];
                }
            }
        }
    }
}
*/
