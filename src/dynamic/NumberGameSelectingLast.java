package dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 12/05/17.
 */
public class NumberGameSelectingLast {

    public static void main(String[] args) throws IOException {


        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        for (int i = 0; i < test; i++) {
            String str = br.readLine();
            String array[] = str.split(" ");
            int a = Integer.parseInt(array[0]);
            String  word = array[1];
        }

    }

    static int getHighest(int arr[], int n){

return 0;

    }
}
