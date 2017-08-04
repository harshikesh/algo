package Strings;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 11/02/17.
 */
public class Permutation {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String string = reader.readLine();
        permutation(string);
    }

    private static void permutation(String string) {
        permutationUtil("", string);
    }

    private static void permutationUtil(String s, String string) {
        int l = string.length();
        if (l == 0) {
            System.out.println(s);
            return;
        }
        // System.out.println(s+" valid "+ string);
        for (int i = 0; i < l; i++) {
            permutationUtil(s + string.charAt(i), string.substring(0, i) + string.substring(i + 1, l));
        }
    }
}
