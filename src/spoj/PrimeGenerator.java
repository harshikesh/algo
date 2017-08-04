package spoj;

import com.sun.xml.internal.stream.Entity;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 03/02/17.
 */
public class PrimeGenerator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        while (test-- > 0) {

            int m = sc.nextInt();
            int n = sc.nextInt();

            for (int i = m; i <= n; i++) {
                if (isPrime(i)) {
                    System.out.println(i);
                }
            }
        }
    }

    private static boolean isPrime(int k) {

        int n = (int) Math.sqrt(k);
        for (int i = 2; i <=n; i++) {
            if (k % i == 0) {
                return false;
            }
        }
        return true;

    }
}
