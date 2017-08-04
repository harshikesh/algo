package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by harshikesh.kumar on 09/04/17.
 */
public class Check {
        static final String anstoken = "Case #";
        static final String anstoken2 = ": ";

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int test = Integer.parseInt(br.readLine());
            Queue<Integer> q =new LinkedList<>();
            for (int i = 1; i <= test; i++) {
                q.add( Integer.parseInt(br.readLine()));

            }
            System.out.println(q.peek());
            System.out.println(q.peek());
    }
}
