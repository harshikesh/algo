package dynamic;

import java.util.Scanner;


/**
 * Created by harshikesh.kumar on 10/02/17.
 */
public class SubSetSum {

    public static void main(String[] args) {
        //code
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        int sum = sc.nextInt();
        while (test-- > 0) {
            int n = sc.nextInt();

            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            subsetUtil(arr, n, sum);
        }
    }

    private static boolean subsetUtil(int arr[], int n, int sum) {

        int data[] = new int[n];
        return findSubset(arr, 0, n, sum, 0,data,0);
    }

    private static boolean findSubset(int[] arr, int i, int n, int sum, int tempSum,int data[],int index) {

//        if (tempSum == sum) {
//            return true;
//        }
        if(i >= n) {
            return false;
        }
        for (int j = 0; j < i; j++) {
            System.out.println(arr[j]);
        }
        System.out.println();
        tempSum += arr[i];
        data[index] = arr[i];
        findSubset(arr, i+1,n, sum, tempSum, data, index+1);
        findSubset(arr, i+1, n, sum, tempSum, data, i);
        return false;
    }
}
