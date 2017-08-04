package datastructure;

/**
 * Created by harshikesh.kumar on 13/02/17.
 */

import java.util.*;
import java.lang.*;
import java.io.*;

class PartitionSum {
    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];
            int sum = 0;
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
                sum += arr[i];
            }

            System.out.println(subsetUtil(arr, n, sum) ? "YES" : "NO");
        }
    }

    private static boolean subsetUtil(int arr[], int n, int sum) {

        int halfsum = sum / 2;

        Arrays.sort(arr);

        for (int a: arr) {
            System.out.print( a+" ");
        }
        int i = arr[n - 1], j = 0;
        int tempsum = arr[n - 1];
        while (tempsum < halfsum) {
            tempsum += arr[j];
            j++;
        }
        if (halfsum == tempsum) {
            return true;
        }
        return false;
    }
}
