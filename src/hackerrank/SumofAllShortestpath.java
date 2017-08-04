package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;


/**
 * Created by harshikesh.kumar on 25/06/16.
 */
public class SumofAllShortestpath {

    static int V=0,E;
    static void calculate (int graph[][]) {

        BigInteger dist[][] = new BigInteger[V][V];


        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                dist[i][j] = BigInteger.valueOf(graph[i][j]);
            }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {


                    if (dist[i][k].add(dist[k][j]).compareTo( dist[i][j]) < 0)
                        dist[i][j] = dist[i][k].add(dist[k][j]);
                }
            }
        }
        BigInteger sum =  new BigInteger("0");

        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                if(dist[i][j].compareTo(BigInteger.valueOf(999999)) < 0)
                {
                 //   System.out.print(dist[i][j]);
                   sum = sum.add(dist[i][j]);
                //System.out.print(sum);
                    }
            }
        }
        System.out.println(sum.toString(2));
    }


    static long min(long a ,long b){
        return a>b?b:a;
    }
    static void calculate (long graph[][]) {

        long dist[][] = new long[V][V];


        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++) {
                dist[i][j] = (long)graph[i][j];
            }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {

                for (int j = 0; j < V; j++) {
                    if(i==j){
                        continue;
                    }
                    if (dist[i][k] !=-1 && dist[k][j] != -1){
                        long total = dist[i][k] + dist[k][j];
                        if(dist[i][j] != -1){
                            dist[i][j] = min(dist[i][j],total);
                        } else{
                            dist[i][j] = total;
                        }

                    }
                }
            }
        }
        long sum=0;

        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                System.out.print(dist[i][j]+" ");
                if(dist[i][j] != -1)
                    sum +=dist[i][j];
            }
            System.out.println();
        }
        System.out.println(Long.toBinaryString(sum));
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        long mat[][] = new long[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                mat[i][j] =-1;

        for (int i = 0; i < E; i++) {
            int a, b;
            long c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextLong();
            c = (int) Math.pow(2,c);
            mat[a-1][b-1]=c;
            mat[b-1][a-1]=c;
        }
        calculate(mat);
    }
    }
