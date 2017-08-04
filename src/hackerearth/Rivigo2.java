package hackerearth;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 27/07/17.
 */
public class Rivigo2 {

    private int V;

    private LinkedList<Integer> adj[];

    Rivigo2(int v)
    {
        V = v;
        adj = new LinkedList[v+1];
        for (int i=1; i<=v; ++i)
            adj[i] = new LinkedList();
    }

    void addEdge(int v, int w)
    {
        adj[v].add(w);
    }

    private long findMaxrecur(int match, int dist,int n1,boolean flag) {
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

        Iterator<Integer> i = adj[n1].listIterator();
        while (i.hasNext())
        {
            int k = i.next();
            sum += findMaxrecur(match,dist-1,k,flag);
        }
        return sum;
    }



    static int val[] ;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int i = 0; i < T; i++) {
            int N = sc.nextInt();
            int Q = sc.nextInt();


            Rivigo2 g = new Rivigo2(N);

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
                g.addEdge(a,b);
            }

            for (int j = 0; j < Q; j++) {
                int a  =sc.nextInt();
                int b  =sc.nextInt();

                // long ans = findMax(a,b,N,n1);
              // long ans = findMaxrecur(a,b-1,N,1,false);
                long ans = g.findMaxrecur(a,b-1,1,false);
                System.out.println(ans);

            }


        }

    }

}
