package hackerrank;

/**
 * Created by harshikesh.kumar on 24/07/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Week34exp {
    static int[] c;
    static int n;
    static Map<Integer, Integer> sum;
    static int []path;
    static int mat[][];
    static Object[][] ans ;
    public static boolean found = false;
    private static void proessAll() {
            ans = new  Object[n+1][n+1];;
        for (int i = 1; i < n; i++) {
            for (int j = i+1; j <=n; j++) {
                found =false;
                sum = new TreeMap<>();
                path = new int[n+1];
                boolean visited[] = new boolean[n + 1];
                path[i] =-1;
                dfs(i, j, visited);
                sum.put(c[j], 1);
                int f = path[j];
                while (f!=-1){
                    if (sum.containsKey(c[f])) {
                        sum.put(c[f], sum.get(c[f]) + 1);
                    } else {
                        sum.put(c[f], 1);
                    }
                    f = path[f];
                }
                ans[i][j] =sum;
                ans[j][i] =sum;
            }
        }
//        System.out.println("done");
    }

    public static boolean dfs( int u, int v, boolean visited[]) {
        visited[u] = true;
        if (u == v) {
            return true;
        }
        for (int i = 1; i <= n; i++) {
            if (mat[u][i] == 1 && !visited[i]) {
                path[i] = u;
                dfs( i, v, visited);
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        int q = in.nextInt();
        c = new int[n+1];
        mat = new int[n + 1][n + 1];
        for (int c_i = 0; c_i < n; c_i++) {
            c[c_i+1] = in.nextInt();
        }
        for (int a0 = 0; a0 < n - 1; a0++) {
            int u = in.nextInt();
            int v = in.nextInt();
            mat[u][v] = 1;
            mat[v][u] = 1;
        }

        proessAll();

        for (int a0 = 0; a0 < q; a0++) {
            int u = in.nextInt();
            int v = in.nextInt();
            int k = in.nextInt();
            Map<Integer, Integer> temp =  ( TreeMap<Integer, Integer>) ans[u][v];
            Set<Map.Entry<Integer, Integer>> set = temp.entrySet();
            List<Map.Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer, Integer>>(set);
            Collections.sort( list, new Comparator<Map.Entry<Integer, Integer>>()
            {
                public int compare( Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2 )
                {
                    if((o2.getValue()).compareTo(o1.getValue()) == 0){
                      return -1;
                    }
                    return (o2.getValue()).compareTo(o1.getValue());
                }
            } );

            int ans = 0;
            int count = 0;
            int prev =0;
            for (Map.Entry<Integer, Integer> entry : list) {
                int key = entry.getKey();
                int value = entry.getValue();
              //  if(value != prev ){
              //      prev =value;
                    count++;
              //  }
                if(k == count){
                ans = key;
                }
                if(count>k){
                    break;
                }
            }
            System.out.println(ans);
        }
        in.close();
    }

}
