package hackerrank;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 23/02/17.
 */
public class BigSorting {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        String[] unsorted = new String[n];
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){

            unsorted[unsorted_i] = in.next();
        }

        Arrays.sort(unsorted); /*new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        })*/;
        for(int unsorted_i=0; unsorted_i < n; unsorted_i++){
            System.out.println(unsorted[unsorted_i]);
        }
        // your code goes here
    }
}
