package hackerearth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 23/10/16.
 *//* IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.*/
//imports for BufferedReader
import java.io.BufferedReader;
import java.io.InputStreamReader;

//import for Scanner and other utility  classes
import java.util.*;


class TestClass {


    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
			*/
        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int N = Integer.parseInt(line);
        char[] farr = br.readLine().toCharArray();
        char[] sarr = br.readLine().toCharArray();
        int Q = Integer.parseInt(br.readLine());
        for (int i = 0; i < Q; i++) {
            String [] str = br.readLine().split(" ");
            int l =  Integer.parseInt(str[0]);
            int r =  Integer.parseInt(str[1]);

            int ch[] =new int[26];
            int chcount[] =new int[26];
            int sum =0;
            int zero =0,one =0,mixed =0;
            for (int j = l-1; j < r; j++) {
                if(sarr[j] == '0'){
                    chcount[farr[j] -'a'] +=1;
                    zero++;
                }else {
                    one++;
                    chcount[farr[j] -'a'] +=1;
                }
                ch[farr[j] -'a'] += 1;
                if(ch[farr[j] -'a'] >1 && chcount[farr[j] -'a'] == 2 ){
                    chcount[farr[j] -'a'] =0 ;
                    mixed += 2;
                }

            }

            for (int j = 0; j <26; j++) {
                if(ch[j] >=2){
                    sum = sum + ((ch[j] *(ch[j]-1))/2);
                }
            }

            sum = sum + ((zero *(zero-1))/2);
            sum = sum + ((one *(one-1))/2);
            sum = sum - ((mixed *(mixed-1))/2);
            System.out.println(sum);
        }

    }
}
