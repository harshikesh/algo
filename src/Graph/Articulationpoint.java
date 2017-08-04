package Graph;

/**
 * Created by harshikesh.kumar on 16/06/16.
 */
public class Articulationpoint {


    static int parent[];
    static int visitingTime[];
    static int lastTime[];
    static boolean visited[];
    static boolean ac[];
    static int time=0;
    static int V;

    static void init(int N){
        parent =  new int[N];
        for (int i = 0; i < N; i++) {
            parent[i] = -1;
        }
        lastTime =  new int[N];
        visitingTime =  new int[N];
        visited =  new boolean[N];
        ac = new boolean[N];
    }

    static int min(int a,int b){
        return a<b?a:b;
    }

   static void getArticulationPoint_Dfs(int mat[][],int u) {

       lastTime[u] = visitingTime[u] = time;
       visited[u] = true;
       time++;
       int child = 0;
       for (int i = 0; i < V; i++) {
           if (mat[u][i] == 1 && !visited[i]) {
               parent[i] = u;
               child++;
               getArticulationPoint_Dfs(mat, i);
               lastTime[u] = min(lastTime[i], lastTime[u]);
               if (parent[u] != -1 && lastTime[u] <= visitingTime[i]) {
                   ac[u] = true;
               }
               if ((parent[u] == -1) && (child > 1))
               { ac[u] = true;}
           } else if (parent[i] == -1) {
               lastTime[i] = min(lastTime[i], lastTime[u]);
           }
       }


   }

    public static void main(String[] args) {
        int graph[][] = {{0, 1, 1, 1, 0},
                { 1, 0, 0, 0, 0},
                { 1, 0, 0, 0, 0},
                { 1, 0, 0, 0, 1},
                { 0, 0, 0, 1, 0}};
        init(5);
        V =5;
        getArticulationPoint_Dfs(graph,0);
        for (int i = 0; i < 5; i++) {
            System.out.println(lastTime[i] + " " + visitingTime[i] + " " + parent[i]);
            if (ac[i]) {
             //   System.out.println(i);
            }
        }
    }
}
