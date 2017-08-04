package hackerearth;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 14/01/17.
 */
public class SmpleGames2 {
        public static void main(String args[] ) throws Exception {
            Scanner s = new Scanner(System.in);
            int len = 0;
            long[] ar =null;
                len = s.nextInt();
                ar = new long[len];
                for(int n=0;n<len;n++){
                    ar[n] = s.nextInt();
                }

            long a = insertionASort(ar);
            long d = insertionDSort(ar);
            System.out.println(a<d?a:d);

        }
    public static long insertionASort(long array[]) {
        int n = array.length;
        long count=0;
        for (int j = 1; j < n; j++) {
            long key = array[j];
            int i = j-1;
            boolean flag = false;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
                flag = true;
            }
            array[i+1] = key;
            if(flag){
                count++;
            }
        }
        return count;
    }
    public static long insertionDSort(long array[]) {
        int n = array.length;
        long count=0;
        for (int j = 1; j < n; j++) {
            long key = array[j];
            int i = j-1;
            boolean flag = false;
            while ( (i > -1) && ( array [i] < key ) ) {
                array [i+1] = array [i];
                i--;
                flag = true;
            }
            array[i+1] = key;
            if(flag){
                count++;
            }
        }
        return count;
    }
}
