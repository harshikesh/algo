package hackerrank;

import java.math.BigInteger;

/**
 * Created by harshikesh.kumar on 02/11/16.
 */
public class PermutationNumber {
    static int factorial(int i){
        if(i == 0){
            return 1;
        }
        else {
            return i * factorial(i-1);
        }
    }

    static int getValue(int num){
        int n = num;
        int arr[] = new int[10];
        int count =0;
        int sum =1;
        while (n>0){
            arr[n%10] +=1;
            n = n /10;
            count++;
        }
        for (int i = 0; i < 10; i++) {
            sum *=factorial(arr[i]);
        }

        return factorial(count)/sum;
    }

    public static void main(String[] args) {
        System.out.println(getValue(99999));

    }
}
