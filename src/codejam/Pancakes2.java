package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */
public class Pancakes2 {

    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 1; i <= test; i++) {
            String temp[] = br.readLine().split(" ");
           String str [] = temp[0].split("");
           int pansize = Integer.parseInt(temp[1]);
            int val =findValue(str, str.length, pansize);
            System.out.println(anstoken + i + anstoken2 + (val==-1?"IMPOSSIBLE":val));
        }
    }

    private static int findValue(String[] str, int size,int pansize) {
        boolean flag = false;
        for (int i = 0; i < size; i++) {
            if(str[i].equals("-")){
                flag = true;
                break;
            }
        }
        if(!flag){
         return 0;
        }

        int flip = 0;
        int index =0;
        for (; index < size;) {
            while(index < size && str[index].equals("+")){
                index++;
            }
            for (int i = index; i < index+pansize && index+pansize <= size; i++) {
                if(str[i].equals("-")){
                    str[i] = "+";
                } else {
                    str[i] = "-";
                }
            }
            if(index+pansize > size){
                break;
            }
            flip++;
            flag = false;
            for (int i = 0; i < size; i++) {
                if(str[i].equals("-")){
                    flag = true;
                    index = i;
                    break;
                }
            }
            if(!flag){
                return flip;
            }
        }
        for (int i = 0; i < size; i++) {
            if(str[i].equals("-")){
                return -1;
            }
        }
        return flip;
    }
}
