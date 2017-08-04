package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

/**
 * Created by harshikesh.kumar on 08/07/17.
 */
public class ConsecutiveSum {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

//        while (true) {
//            String str = br.readLine();
//            if(str.equalsIgnoreCase("")){break;
//            }
//            System.out.println(str);
//        }
        System.out.println(consucutive(6456788796l));
    }

    private static int consucutive(long num) {
        HashSet<String> hashSet = new HashSet<>();
        long start = System.currentTimeMillis();
        int count =0;
        long i =1 ,j =2;
        long sum = 0;
        long n = j-i +1;
        sum = ((i+j)*n)>>1;
        while (i<j && j<=(num/2 +1) ){

            if(sum  == num ){
                count++;
                sum -= i;
                if(j-i == 1){
                    break;
                }
                i++;
            } else {
                if(sum>num){
                    sum -= i;
                    i++;
                } else {
                    j++;
                    sum += j;
                }
            }
        }
        System.out.println((System.currentTimeMillis()-start)/1000.0);
        return count;
    }
}
