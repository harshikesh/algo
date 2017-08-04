package codechef;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 27/07/17.
 */
public class SUMPAIR {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            long arr[] = new long[a];
            for (int j = 0; j <a; j++) {
                arr[j] =sc.nextLong();
            }

            Arrays.sort(arr);

            int j=arr.length-1;
            long sum =0;

            while (j>0){

                if(arr[j]-arr[j-1] < b ){
                    sum+=arr[j]+arr[j-1];
                   j--;
                }
                j--;
            }
            System.out.println(sum);
        }

    }
}
