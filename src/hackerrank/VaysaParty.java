package hackerrank;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 10/07/16.
 */
public class VaysaParty {

        static int N;
        static boolean visited[];
        static int arr[];
        public static int getdfs(int mat[][],int k){

            Queue<Integer> qmain = new LinkedList<>();
            Queue<Integer> qu = new LinkedList<>();
            qmain.add(k);
            qu.add(k);
            while(!qu.isEmpty()) {
                int temp = qu.poll();
                visited[temp] = true;
                for (int i = 1; i <= N; i++) {
                    if (mat[temp][i] == 1 && !visited[i]) {
                        qu.add(i);
                        qmain.add(i);
                    }
                }
            }
            int max = 0;
            int count=1;
            while(!qmain.isEmpty()){
                int sd = qmain.poll();
                if(arr[sd]==max){
                    count++;
                }
                if(arr[sd]>max){
                    max = arr[sd];
                }
            }

            return count;
        }

        static void DFS(int mat[][])
        {
            int sum =1;
             visited = new boolean[N+1];
            for (int k = 1; k <=N; ++k)
                if (visited[k] == false ){
                    visited[k] =true;
                   int c =  getdfs(mat,k);
                   sum *=  c;
                }
            System.out.println(sum);
        }
        public static void main(String args[] ) throws Exception {
            Scanner sc = new Scanner(System.in);
             N = sc.nextInt();
            int M = sc.nextInt();
            arr = new int[N+1];

            for (int i = 1; i <= N; i++) {
                int c = sc.nextInt();
                arr[i] = c;
            }
            int mat[][] = new int[N+1][N+1];
            for (int i = 0; i < M; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                mat[a][b] = 1;
                mat[b][a] = 1;
            }
            DFS(mat);
        }

}
