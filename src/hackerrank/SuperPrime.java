package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 24/02/17.
 */
public class SuperPrime {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long first = in.nextLong();
        long last = in.nextLong();
        int arr[] = {0,0,1,1,0,1,0,1,0,0};
        // your code goes here
        long count = 0;
        if(first == 1 || first == 2){
            count = 2;
            first = 5;
        }
        for (long i = first; i <= last; i++) {

            if(i % 2 == 0){
                continue;
            }
            boolean flag = false;
            long i_temp = i;
            try {
                while (i_temp > 0) {
                    int temp = (int)(i_temp % 10);
                    if (arr[temp] == 0) {
                        flag = true;
                        break;
                    }
                    i_temp = i_temp / 10;
                }
            }catch (Exception e){
                System.out.println("error" + i);
                e.printStackTrace();
            }

            if(flag){
                continue;
            }

            if(isPrime(i,4))
                count++;

        }
        System.out.println(count);
    }

    static  long power(long x, long  y, long p)
    {
        long res = 1;
        x = (long)x % p;

        while (y > 0)
        {

            if ((y & 1) == 1)
                res = (res*x) % p;

            y = y>>1;
            x = (x*x) % p;
        }
        return res;
    }

    static boolean miiller_prime(long d, long n)
    {

        long a = 2 + ((long)Math.random() % (n - 4));


        long x = power(a, d, n);

        if (x == 1  || x == n-1)
            return true;

        while (d != n-1)
        {
            x = (x * x) % n;
            d *= 2;

            if (x == 1)      return false;
            if (x == n-1)    return true;
        }


        return false;
    }


    static boolean isPrime(long n, long k)
    {
        if (n <= 1 || n == 4)  return false;
        if (n <= 3) return true;

        long d = n - 1;
        while (d % 2 == 0)
            d /= 2;

        for (int i = 0; i < k; i++)
            if (miiller_prime(d, n) == false)
                return false;

        return true;
    }


    static boolean isPrime1(long current){

        long sqr_root = (long) Math.sqrt(current);
        boolean is_prime = true;
        for (int i = 2; i <= sqr_root; i++) {
            if (current % i == 0) {

                return false;
            }
        }
        return true;
    }
}
