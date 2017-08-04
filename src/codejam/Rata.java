package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 15/04/17.
 */
public class Rata {


    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";


    static class Pair{
        int min;
        int max;
        int val;
    }
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();

        for (int i = 1; i <= test; i++) {


            int N = sc.nextInt();
            int P = sc.nextInt();

            int[] req = new int[N];
            for (int j = 0; j < N; j++) {
                req[j] = sc.nextInt();
            }
            Pair[][] given = new Pair[N][P];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < P; k++) {
                    int num = sc.nextInt();
                    Pair p = new Pair();
                    p.val = num/req[j];
                    p.max = ((num * 100) / 90) / req[j];
                    p.min = (num * 100) / 110 / req[j];
                    given[j][k] = p;
                }
            }


            for (int j = 0; j < N; j++) {
                Arrays.sort(given[j], new Comparator<Pair>() {
                    @Override
                    public int compare(Pair o1, Pair o2) {
                        return o1.min - o2.min;
                    }
                });
            }

//            for (int j = 0; j < N; j++) {
//                for (int k = 0; k < P; k++) {
//                    System.out.print(given[j][k].val + " ");
//                }
//                System.out.println();
//            }


            int kit = 0;
            for (int t = P-1; t >=0; t--) {
                int col = P-1;
                int count = 0;
                int temp = 9999999;
                ArrayList<Integer> arrayList = new ArrayList<>();
                for (int j = 0; j < N; j++) {
                    Pair pp = given[j][col];
                    for (int k = col; k >= 0; k--) {
                        Pair ps = given[j][k];
                        if(pp != null && ps !=null && ((pp.min >= given[j][k].min && pp.min <= given[j][k].max )||( pp.max <= given[j][k].max && pp.max >= given[j][k].min))){
                            arrayList.add(col);
                            count++;
                            col = k;
                            break;
                        }
                    }
                }
                if (count == N) {
                    int v =0;
                    for (Integer g:arrayList) {

                        given[v][g] = null;
                        v++;
                    }
                    kit++;
                    if(kit == P){
                        break;
                    }
                }
            }
            System.out.print(anstoken + (i) + anstoken2);
            System.out.print(Math.min(kit,P));
            System.out.println();
        }
    }

    public static int getIntgerInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static String[] getSplitString(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}
