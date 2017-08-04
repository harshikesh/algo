package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by harshikesh.kumar on 26/06/16.
 */
public class ABCxor {

    static String hexToBin(String s) {
        return new BigInteger(s, 16).toString(2);
    }

    static int calculate(int a ,int b,int c){

        if(a>=b && a>=c){
            return a;
        }
        else if(b>=c && b>=a){
            return b;
        }
        else if(c>=a && c>=b){
            return c;
        }
        return 0;
    }
    static void calcluate(String a,String b, String c,int k,int len){
        int count=0;
        char aa[]= new char[len],bb[]=new char[len];
        for (int j = 0; j < len; j++) {
            if(c.charAt(j) == '1'){
                if(a.charAt(j)=='1' || b.charAt(j) == '1'){
                    bb[j] = b.charAt(j);
                    aa[j] = a.charAt(j);
                    continue;
                }else {
                    count++;
                    bb[j] = '1';
                    aa[j] = '0';
                }
            } else {
                if(a.charAt(j)!='0'  ){
                    count++;
                }
                if(b.charAt(j) !='0'){
                    count++;
                }
                bb[j] = '0';
                aa[j] = '0';
            }
        }

        if(count<k){
            for (int j = 0; j < len; j++) {
                if(c.charAt(j) == '1'){
                    if(a.charAt(j)=='1' && b.charAt(j) != '1' && count+2<=k){
                        bb[j] = 1;
                        aa[j] = 0;
                        count +=2;
                        continue;
                    }
                }
            }
        }
        if(count > k){
            //  System.out.println(count +" " +k);
            System.out.println(-1);
            return;
        }
       // aa = new StringBuffer(aa).reverse().toString();
       // bb = new StringBuffer(bb).reverse().toString();
        int decimal = Integer.parseInt(new String(aa),2);
        String hexStr = Integer.toString(decimal,16);
        System.out.println(hexStr);
        decimal = Integer.parseInt(new String(bb),2);
        hexStr = Integer.toString(decimal,16);

        System.out.println(hexStr);
    }
    public static void main(String[] args) throws IOException {
        int N,k;
        String a,b,c;
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
         N = Integer.parseInt(in.readLine());
        for (int i = 0; i < N; i++) {
            k = Integer.parseInt(in.readLine());
            a = hexToBin(in.readLine());
            b = hexToBin(in.readLine());
            c = hexToBin(in.readLine());
            int  alen = a.length();
            int blen = b.length();
            int clen = c.length();

            int len = calculate(alen,blen,clen);

            while(alen<len){
               String temp = "0";
                temp = temp+a;
                a=temp;
                alen++;
            }  while(blen<len){
               String temp = "0";
                temp = temp+b;
                b=temp;
                blen++;
            }  while(clen<len){
               String temp = "0";
                temp = temp+c;
                c=temp;
                clen++;
            }
                calcluate(a,b,c,k,len);
          //  System.out.println(a);
        }
    }
}

//8
//        58
//        18
//        42
//        -1