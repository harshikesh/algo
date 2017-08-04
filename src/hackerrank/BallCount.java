package hackerrank;

import java.io.IOException;
import java.util.Scanner;

public class BallCount {

    static int min = Integer.MAX_VALUE;

    public static void ball_count(int[] input1, int input2, int input3) {
// Write code here
        printCombination(input1, input1.length, input3, input2);
    }

    static void combinationUtil(int arr[], int n, int r, int index,
                                int data[], int i, int su) {
        if (index == r) {
            int sum = 0;
            for (int j = 0; j < r; j++) {
                sum += data[j];
            }
            if (sum % su == 0) {
                min = sum < min ? sum : min;
            }
            return;
        }

        if (i >= n)
            return;
        data[index] = arr[i];
        combinationUtil(arr, n, r, index + 1, data, i + 1, su);

        combinationUtil(arr, n, r, index, data, i + 1, su);
    }

    static void printCombination(int arr[], int n, int r, int sum) {
        int data[] = new int[r];
        combinationUtil(arr, n, r, 0, data, 0, sum);
    }


    public static void main(String[] args) throws IOException {

        Scanner in = new Scanner(System.in);

        int output = 0;

        int ip1_size = 0;

        ip1_size = Integer.parseInt(in.nextLine().trim());

        int[] ip1 = new int[ip1_size];

        int ip1_item;

        for (int ip1_i = 0; ip1_i < ip1_size; ip1_i++) {

            ip1_item = Integer.parseInt(in.nextLine().trim());

            ip1[ip1_i] = ip1_item;

        }

        int ip2 = Integer.parseInt(in.nextLine().trim());

        int ip3 = Integer.parseInt(in.nextLine().trim());

        ball_count(ip1, ip2, ip3);

        System.out.println(min);
    }


}