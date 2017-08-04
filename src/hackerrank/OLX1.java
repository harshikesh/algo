package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 24/07/17.
 */
public class OLX1 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String tempString = br.readLine();
            String splitString[] = tempString.split(" ");

            String command = splitString[0];

            if(command.equalsIgnoreCase("S")){

            } else {

            }

        }

    }
}

//11
//        S 1 1 2
//        S 2 1.1 2
//        S 2 2.3 1
//        S 1 2.2 1
//        Q 1 1 2
//        Q 1 2 1
//        Q 2 1 2
//        Q 2 2 1
//        Q 1.2 1 -1
//        Q 1.2 -1 2
//        Q 1.2 -1 -1