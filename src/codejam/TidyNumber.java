package codejam;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TidyNumber {


    static final String anstoken= "Case #";
    static final String anstoken2= ": ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            long num = Long.parseLong(br.readLine());
            String numstring = Long.toString(num);
            int[] dig = new int[numstring.length()];
            for (int j = 0; j < numstring.length(); j++) {
                dig[j] = numstring.charAt(j) - '0';
            }
            System.out.print(anstoken + (i + 1) +anstoken2);

            if (dig.length == 1) {
                System.out.println(dig[0]);
                continue;
            }

            int buff = -1;
            for (int k = dig.length - 1; k > 0; k--) {
                if (dig[k - 1] > dig[k]) {
                    buff = k - 1;
                    while (k - 2 >= 0 && dig[k - 2] == dig[k - 1]) {
                        buff = k - 2;
                        k = k - 1;
                    }
                }
            }

            if (buff == -1) {
                for (int j = 0; j < dig.length; j++) {
                    System.out.print(dig[j]);
                }
            } else {
                for (int j = 0; j < buff; j++) {
                    System.out.print(dig[j]);
                }

                // check if 1
                System.out.print(dig[buff] == 1 ? "" : dig[buff] - 1);

                // Print all 9
                for (int j = buff + 1; j < dig.length; j++) {
                    System.out.print("9");
                }
            }
            System.out.println();
        }
    }
}
