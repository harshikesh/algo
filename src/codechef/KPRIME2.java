package codechef;

/**
 * Created by harshikesh.kumar on 28/07/17.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
/**
 * Created by harshikesh.kumar on 28/07/17.
 */
public class KPRIME2 {
    static int N = 0;
    public static void main(String[] args) throws IOException {

        // long tes = System.currentTimeMillis();
        int max = 100000;
        BufferedReader br  = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        int arr[] = new int[max+1];
        for (int p=2; p*p<=max; p++)
        {
            if (arr[p] == 0)
            {   arr[p] = 1;
                for (int i=p*2; i<=max; i += p)
                    arr[i] ++;
            }
        }

        for (int i = 0; i < N; i++) {
            String str[] = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);
            int k = Integer.parseInt(str[2]);
            int count = 0;
            for (int j = a; j <=b; j++) {
                if(arr[j] == k){
                    count++;
                }
            }
            System.out.println(count);
        }
        // System.out.println((System.currentTimeMillis()-tes)/(60.0*1000.0));
    }
}
