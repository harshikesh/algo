package hackerrank;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 12/11/16.
 */
public class BigMod {


        public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            Scanner sc = new Scanner(System.in);
            int test = sc.nextInt();
            for(int i =0; i<test ;i++){
                long a =  sc.nextLong();
                long b = sc.nextLong();
                long d =  sc.nextLong();
                long m =  sc.nextLong();
                System.out.println(f(a,b,d,m));
            }
        }

        static BigInteger f(long a, long b,long d,long m) {
            long s = 0;
            if(a==b){
                return BigInteger.ZERO;
            }
            BigInteger bb = BigInteger.valueOf(b);
            BigInteger aa = BigInteger.valueOf(a);
            BigInteger dd = BigInteger.valueOf(d);
            BigInteger mm = BigInteger.valueOf(m);
            BigInteger ss = BigInteger.ZERO;

            BigInteger temp = bb.divide(aa);
            ss = aa.multiply(temp);
            if(dd.pow(temp.intValue()).compareTo(BigInteger.ONE) != 0 ) {
                ss.add(dd.pow(temp.intValue())).xor(BigInteger.ONE);
            } else {
               ss =  ss.xor(BigInteger.ONE);
            }
//            while (aa.compareTo(bb) < 0) {
//                ss = ss.add(aa.xor(BigInteger.ONE));
//                aa = aa.add(dd);
//            }

            return ss.mod(mm);
        }
}
