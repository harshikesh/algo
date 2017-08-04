package hackerearth;

/**
 * Created by harshikesh.kumar on 13/01/17.
 */
/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;

public class SimpleGames {
    /* IMPORTANT: Multiple classes and nested static classes are supported */
        static ArrayList<Long> arr1 ;
        static int N ;
        public static void main(String args[] ) throws Exception {

            Scanner s = new Scanner(System.in);
            N = s.nextInt();
            arr1 = new ArrayList<>();
            long min = 999999;
            for (int i = 0; i < N; i++) {
                arr1.add(s.nextLong());
            }
            long as = getminAsc();
            long ds =getminDesc();
            if(as>ds){
                min = ds;
            } else {
                min = as;
            }
            System.out.println(min);
        }

        static long getminAsc(){
            ArrayList<Long> arr = new ArrayList<>(arr1);
            long asc = 0;
            for(int j=0;j<N;j++){
                long max = 0;
                int index = 0;
                long size = arr.size();

                for (int i = 0; i < size; i++) {
                    if(max < arr.get(i)){
                        max = arr.get(i);
                        index = i;
                    }
                }
                if(index != size-1){
                    asc++;
                }
                arr.remove(index);
            }
            return asc;
        }
        static long getminDesc(){
            ArrayList<Long> arr = new ArrayList<>(arr1);
            long desc = 0;
            for(int j=0;j<N;j++){
                long min = 999999999;
                int index = 0;
                long size = arr.size();

                for (int i = 0; i < size; i++) {
                    if(min > arr.get(i)){
                        min = arr.get(i);
                        index = i;
                    }
                }
                if(index != 0){
                    desc++;
                }
                arr.remove(index);
            }
            return desc;
        }
}
