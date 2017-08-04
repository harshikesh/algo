package codejam;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 06/04/17.
 */
public class Pancakes {

    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int test = scanner.nextInt();
        for (int i = 1; i <= test; i++) {
            String str[] = scanner.next().split("");
            System.out.println(anstoken + i + anstoken2 + findValue(str, str.length));
        }
    }

    private static int findValue(String[] str, int size) {
        int flip = 0;
        for (int i = 0; i < size;) {
            if(str[i].equals("+")) {
                while (i<size && str[i].equals("+")) {
                    i++;
                }
            } else {
                while ( i<size && str[i].equals("-")){
                    i++;
                }
            }
            if(i > size-1){
                break;
            }
            flip++;
        }

        if(str[size-1].equals("-")){
            flip++;
        }
        return flip;
    }
}
