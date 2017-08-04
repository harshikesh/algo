package codejam;
import java.io.*;
import java.util.*;

public class lo {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter wr = new PrintWriter(System.out);
        int T = Integer.parseInt(br.readLine().trim());
        for(int t_i=0; t_i<T; t_i++)
        {
            String str[] = br.readLine().split(" ");
            long n = Long.parseLong(str[0]);
            int k = Integer.parseInt(str[1]);

            long out_ = solve(k, n);
            System.out.println(out_);
        }

        wr.close();
        br.close();
    }
    static long solve(int k, long n){
        // Write your code here
        long sum =0;
        long i = 1;
        long divisor = n /k;
        long mod = n %k;
        long f = k*divisor;
        int temp = k;
        while(temp<=f){
            sum = sum +(i*k);
            i++;
            temp += temp;
        }
        sum += ((mod)*i);
        return sum;

    }
}