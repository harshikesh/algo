package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 04/04/17.
 */
public class A120161 {
    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int index = 0; index < n; index++) {
            String s = br.readLine();
            String word ="";
            for (int i = 0; i < s.length(); i++) {
                if(word.length()>0 && s.charAt(i) >= word.charAt(0)){
                    word = s.charAt(i) + word;
                } else {
                    word = word + s.charAt(i);
                }
            }
           print(index+1,word);
        }

    }

    public static void print(int i,String word){
        System.out.println("Case #"+i+": "+word);
    }
}
