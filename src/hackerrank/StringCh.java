package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * Created by harshikesh.kumar on 26/06/16.
 */
public class StringCh {

    @Override
    public String toString() {
        return super.toString();
    }


        public static void main(String[] args) throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(in.readLine());
            HashMap<String,Integer> has= new HashMap<>();
            for (int i = 0; i <n; i++) {
                int a = Integer.parseInt(in.readLine());
                String s= in.readLine();
                String ss= in.readLine();
                String str = s+ (new StringBuffer(ss).reverse()).toString();
                int count=0;
                long len = str.length();
                for (int j = 0; j < len; j++) {
                    String temp = str.substring(j) +str.substring(0,j);
                    if(!(has.containsKey(temp))){
                        has.put(temp,1);
                        count ++;
                    }
                }
                str = new StringBuffer(str).reverse().toString();
                for (int j = 0; j <len; j++) {
                    String temp = str.substring(j) +str.substring(0,j);
                    if(!(has.containsKey(temp))){
                        has.put(temp,1);
                      //  System.out.println(temp);
                        count ++;
                    }
                }
                String temp = "";
                boolean v = true;
                for (int j = 0; j < a; j++) {
                    if(v) {
                        temp += s.charAt(j) +""+  ss.charAt(j);
                        v = false;
                    } else {
                        temp += ss.charAt(j) +""+ s.charAt(j);
                        v=true;
                    }
                }
                if(!has.containsKey(temp)){
                    count++;
                }
                 v = false;
                temp = "";
                for (int j = 0; j < a; j++) {
                    if(v) {
                        temp = temp +""+  s.charAt(j) +""+ ss.charAt(j);
                        v = false;
                    } else {
                        temp = temp +""+  ss.charAt(j) +""+  s.charAt(j);
                        v=true;
                    }
                }
                if(!has.containsKey(temp)){
                    count++;
                }

                v = false;
                temp = "";
                for (int j = a-1; j >= 0; j--) {
                    if(v) {
                        temp += s.charAt(j) +""+  ss.charAt(j);
                        v = false;
                    } else {
                        temp += ss.charAt(j) +""+  s.charAt(j);
                        v=true;
                    }
                }
                if(!has.containsKey(temp)){
                    count++;
                }
                v = true;
                temp = "";
                for (int j = a-1; j >= 0; j--) {
                    if(v) {
                        temp += s.charAt(j) +""+  ss.charAt(j);
                        v = false;
                    } else {
                        temp += ss.charAt(j) +""+  s.charAt(j);
                        v=true;
                    }
                }
                if(!has.containsKey(temp)){
                    count++;
                }

                System.out.println(count);
            }

        }
}
//2.abdbad, 6.adabdb, 5.badabd, 3.bdbada, dababd, 1. dabdba, dbabad, and 4.dbadab