package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 10/07/16.
 */
public class Stringw {
    static int binarySearch(int arr[],int n){
      int  first = 0;
        int last = arr.length - 1;
        int middle = (first + last)/2;

        while( first <= last )
        {
            if ( arr[middle] < n  )
                first = middle + 1;
            else if ( arr[middle] == n )
            {
                return middle+1;

            }
            else
            {
                last = middle - 1;
            }
            middle = (first + last)/2;
        }
        middle = (first+last+1)/2;
        return middle+1;
    }

    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int arr[] = new int[N];
        arr[0] = sc.nextInt();
        for (int i = 1; i < N; i++) {
            int c = sc.nextInt();
            arr[i] = c + arr[i-1];
        }
        int Q = sc.nextInt();
        for (int i = 0; i < Q; i++) {
            int a = sc.nextInt();

                System.out.println(binarySearch(arr,a));


        }
    }

}
