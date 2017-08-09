/**
 * Created by harshikesh.kumar on 04/08/17.
 */
/* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class CC {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input

        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);*/

        //Scanner
        String str  = "\u20B9 ";
        System.out.println(str);

        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        HashMap<Long,Integer> map =new HashMap<>();
        for (int i = 0; i < N; i++) {
            long a = s.nextLong();
            for(int j=0;j<a;j++){
                long k =s.nextLong();
                map.put(k, map.get(k)!=null? map.get(k)+1:1);
            }
            while(true){

                if(map.containsKey(a)){
                    a =a -map.get(a);
                } else {
                    break;
                }
            }
            if(a>0){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }



        //  System.out.println("Hello World!");
    }
}
