package hackerearth;

/**
 * Created by harshikesh.kumar on 20/08/16.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;


class Wal2 {
    public static void main(String args[]) throws Exception {
        /*
         * Read input from stdin and provide input before running
*/
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 0;
        String str1 = "";
        String str2 = "";
        for (int i = 0; i < N; i++) {
            str1 += sc.nextInt();
        }

        for (int i = 0; i < N; i++) {
            str2 += sc.nextInt();
        }


        for (int i = 0; i < N; i++) {

            int in = search(i, str2, str1.charAt(i));
            str2 = str2.substring(0,i)  + str2.charAt(in) +str2.substring(i,in) +str2.substring(in+1);
            int t = in-i;
            count = count + t;
        }
        System.out.println(count);
    }

    private static int search(int index, String str2, char ch) {

        for (int i = index; i < str2.length(); i++) {
            if(str2.charAt(i) == ch){
                return i;
            }
        }
        return 0;
    }
}

