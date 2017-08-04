package hackerearth;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 27/07/17.
 */
public class Rivigo {

    static int mat[][] ;
    static int val[] ;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();


            mat =new int[N+1][N+1];
            val = new int[N+1];
            for (int j = 1; j <= N; j++) {
                val[j] =sc.nextInt();
            }
            int n1=0;
            for (int j = 0; j < N-1; j++) {
                int a  =sc.nextInt();
                if(j==0){
                    n1 =a;
                }
                int b  =sc.nextInt();
                mat[a][b] =1;
            }

            for (int j = 0; j < Q; j++) {
                int a  =sc.nextInt();
                int b  =sc.nextInt();

                // long ans = findMax(a,b,N,n1);
                long ans = findMaxrecur(a,b-1,N,1,false);

                System.out.println(ans);

            }


        }

    }


    private static long findMaxrecur(int match, int dist, int n,int n1,boolean flag) {
       int sum=0;
        if(n1 == match && dist == 0){
            return val[n1];
        }
        if(dist == 0 && flag){
            return val[n1];
        }
        if(dist == 0 && !flag){
            return 0;
        }

        if(n1 == match){
            flag = true;
        }

        for (int i = 1; i <= n; i++) {
            if(mat[n1][i] ==1) {
                sum += findMaxrecur(match,dist-1,n,i,flag);
            }
        }
        return sum;
    }

    private static long findMax(int match, int dist, int n,int n1) {

        class Node{
            int h;
            int data;
            int num;

            Node(int height,int val,int n){
                data = val;
                h = height;
                num = n;
            }
        }
        Queue<Node> q = new LinkedList<>();
        Node node = new Node(0,val[n1],n1);

        q.add(node);

        long sum = 0;
        while (!(q.isEmpty())){

            Node temp = q.poll();

            if(temp.h>dist){
                break;
            }
            for (int i = 1; i <= n; i++) {
                if(mat[temp.num][i] == 1 && temp.h == dist-1 && temp.num == match){
                    sum += temp.data;
                    break;
                } else if(mat[temp.num][i] == 1 && temp.h == dist-2 && temp.num == match){
                    sum += val[i];
                } else if(mat[temp.num][i] == 1 ){
                    q.add(new Node(temp.h+1,val[i],i));
                }
            }

        }
        return sum;
    }
}
