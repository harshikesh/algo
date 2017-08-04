package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

public class Solution {

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

                    if(i==j){
                        continue;
                    }

                    if (dist[i][k].compareTo(BigInteger.valueOf(-1)) > 0 && dist[k][j].compareTo(BigInteger.valueOf(-1)) > 0){
                        BigInteger total = dist[i][k].add(dist[k][j]);
                        if(dist[i][j].compareTo(BigInteger.valueOf(-1)) != 0){
                              if(dist[i][j].compareTo(total) < 0)
                           dist[i][j] =  dist[i][j] ;
                            else {
                                dist[i][j] =  total;
                            }
                        } else{
                           dist[i][j] = total; 
                        }
                          }
                }
            }
        }
        BigInteger sum =  new BigInteger("0");

        for (int i = 0; i < V; i++) {
            for (int j = i+1; j < V; j++) {
                //System.out.print(dist[i][j]+" ");
                if(dist[i][j].compareTo(BigInteger.valueOf(-1)) > 0)
                {
                   sum = sum.add(dist[i][j]);
                //System.out.print(sum);
                    }
            }
           // System.out.println();
        }
        System.out.println(sum.toString(2));
    }


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        E = sc.nextInt();
        int mat[][] = new int[V][V];

        for (int i = 0; i < V; i++)
            for (int j = 0; j < V; j++)
                mat[i][j] =-1;


        for (int i = 0; i < E; i++) {
            int a, b, c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();
            c = (int) Math.pow(2,c);
            mat[a-1][b-1]=c;
            mat[b-1][a-1]=c;
        }
        calculate(mat);
    }
    }