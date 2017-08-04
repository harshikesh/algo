package codechef;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 28/07/17.
 */
public class GRANAMA {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(br.readLine());



        for (int i = 0; i < a; i++) {
            String str[] = br.readLine().split(" ");
            int count[] = new int[27];
            int count2[] = new int[27];

            for (int j = 0; j < str[0].length(); j++) {
                count[str[0].charAt(j)-'a']++;
            }

            for (int j = 0; j < str[1].length(); j++) {
                count2[str[1].charAt(j)-'a']++;
            }

            boolean flag = true;
            for (int j = 0; j < 27; j++) {
                if(count[j] == 0 && count2[j]==0){
                    continue;
                }
                if((count[j] == 0 && count2[j]!=0)||(count2[j] == 0 && count[j]!=0)){
                    flag =true;
                    break;
                }

                if(count[j] != count2[j]){
                  flag =false;
                }
            }
            if(!flag){
                System.out.println("NO");
            } else {
                System.out.println("YES");
            }
        }


    }
}
