package hackerrank;

/**
 * Created by harshikesh.kumar on 18/07/17.
 */
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class GCD {

    static int array1[] = new int [1000000];
    static int array2[] = new int [1000000];
    static int maximumGcdAndSum(int[] A, int[] B) {
        // Complete this function
        int max =0;
        for (int i = 0; i < A.length; i++) {
            if(max < A[i]){
                max = A[i];
            }
            array1[A[i]] = 1;
        }
        for (int i = 0; i < B.length; i++) {
            if(max < B[i]){
                max = B[i];
            }
            array2[B[i]] = 1;
        }

        for (int i = max; i >=1 ; i--) {
            boolean s1=false,s2=false;
            int sum =0 ;
            int j = max - (max % i);
            for (; j >=i ; j-=i) {
                if(j%i ==0){
                    if(!s1 && array1[j] ==1  ){
                        s1 =true;
                        sum += j;
                    }
                    if(!s2 && array2[j] ==1){
                        s2 =true;
                        sum += j;
                    }
                    if(s1&&s2){
                        return sum;
                    }
                }
            }

        }
        return 7/0;
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();


        for (int i = 0; i < 100; i++) {

            int n = 500000;
            int[] A = new int[n];
            Random r = new Random();
            for (int A_i = 0; A_i < n; A_i++) {
                // A[A_i] = in.nextInt();
                int rr= r.nextInt(100000);
                    A[A_i] = rr;

            }
            int[] B = new int[n];
            for (int B_i = 0; B_i < n; B_i++) {
//            B[B_i] = in.nextInt();
                int rr= r.nextInt(929299);
                B[B_i] =rr;
            }
            int res = maximumGcdAndSum(A, B);
            System.out.println(res);
        }
    }
}
