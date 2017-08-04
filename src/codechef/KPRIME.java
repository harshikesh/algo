package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by harshikesh.kumar on 28/07/17.
 */
public class KPRIME {
    static int N = 0;
    public static void main(String[] args) throws IOException {

       // long tes = System.currentTimeMillis();
        int max = 100000;
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int arr[] = new int[max+1];

        for (int p=2; p<=99999; p++)
        {
            if (arr[p] == 0)
            {   arr[p] = 1;
                for (int i=p*2; i<=max; i += p) {
                    arr[i]++;
                }
            }
        }

        int mat[][] = new int[6][max+1];
//        for (int i = 2; i < arr.length; i++) {
//            mat[arr[i]][i] = 1;
//        }

        for (int i = 1; i < 6; i++) {
            for (int j = 2; j < mat[0].length; j++) {
                if(arr[j] == i) {
                    mat[i][j] = mat[i][j - 1]+1;
                } else {
                    mat[i][j] = mat[i][j - 1];
                }
            }
        }


        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int ans = mat[k][b]-mat[k][a-1];
            System.out.println(ans);
            }
    }
}
/*1790
26018
18385
9781
11239
2150
2968
990
18203
1799
6538
*/