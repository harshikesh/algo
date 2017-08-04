package codejam;

import learnjava.Inter;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */
public class quali1 {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(bufferedReader.readLine());
        for (int i = 1; i <= test; i++) {
            String str[]  = bufferedReader.readLine().split(" ");
            String pancackes[] = str[0].split("");
            int  size = Integer.parseInt(str[1]);
            int pan[] = new int[pancackes.length];
            for (int j = 0; j < pancackes.length; j++) {
                if(pancackes[j].equals("+")){
                    pan[j] = 1;
                }
            }
            int flip = 0;
            System.out.print("Case #"+i+": ");
            boolean flag = false;
            for (int j = 0; j < pan.length-2; j++) {
                if(pan[j] == 0){
                    if(j+2 == pan.length-1 && pan[j+2] == 1){
                        flag =true;
                        break;
                    }
                    if(pan[j+1] == pan[j+2]){
                        flip++;
                        pan[j] = 1 - pan[j];
                        pan[j+1] = 1 - pan[j+1];
                        pan[j+2] = 1 - pan[j+2];
                    } else if(j+2 == pan.length-1){
                        flag =true;
                        break;
                    }
                }
            }
            if(!flag) {
                System.out.print(flip);
            } else {
                System.out.print("IMPOSSIBLE");
            }
            System.out.println();
        }
    }
}
