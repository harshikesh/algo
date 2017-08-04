package hackerearth;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by harshikesh.kumar on 20/05/17.
 */
public class Grab2 {

    public static void main(String[] args) {

        int T[] = {9 ,1 ,4 ,9 ,0 ,4,8,9,0,1};
        Grab2 g =new Grab2();
        g.solution(T);
    }

    public int[] solution(int[] T) {
        // write your code in Java SE 8
        int size = T.length;
        int mat[][] =new int[size][size];
        for (int i = 0; i <size; i++) {
            mat[i][T[i]] = 1;
            mat[T[i]][i] = 1;
        }

        boolean visited[] = new boolean[size];

        int val[] = bfs(mat,1,visited);

        for(int i =0 ;i<T.length;i++){
            System.out.print(val[i]+" ");
        }

        return null;

    }

    class City{
        int num;
        int dist;
        City(int n,int d){
            num = n;
            dist =d;
        }
    }

    private int[] bfs(int[][] mat,int cap, boolean[] visited) {
        int val[] = new int[mat[cap].length];
        Queue<City> queue =new LinkedList<>();
        City c =new City(cap,0);
        queue.add(c);
        visited[cap] =true;
       while (!queue.isEmpty()){
           City temp = queue.remove();
           for (int i = 0; i < mat[temp.num].length; i++) {
               if(mat[temp.num][i] !=  0 && !visited[i]){
                   visited[i] =true;
                   City city1 =new City(i,temp.dist+1);
                   queue.add(city1);
                   val[temp.dist]++;
               }
           }
       }
        return val;
    }
}
