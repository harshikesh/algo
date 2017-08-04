package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 19/06/17.
 */
public class Micro {

    public static void main(String[] args) throws IOException {

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String strarray[] = new String[N];
        for (int i = 0; i < N; i++) {
            String str =  br.readLine();
            strarray[i] = str;
        }

       int arr[] = findManyString(strarray);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

    static int[] findManyString(String[] strings){

        int arr[] = new int[strings.length];
        for (int i = 0; i < strings.length; i++) {
           String str = strings[i];

            char chararr[]  = str.toCharArray();
            int j =0;

            if(!Character.isLetter(chararr[j])){
                continue;
            }
            int count =0;
            int countbefore =0;
            int countAfter = 1;
           while (j<chararr.length){
              countbefore = countAfter;
               countAfter = 0;
               j++;
               while(j<chararr.length && Character.isLetterOrDigit(chararr[j])){
                   countbefore ++;
                   j++;
               }
               if(chararr[j] == ':'){
                   while (j<chararr.length && chararr[j] == ':'){
                       j++;
                   }
               } else {
                   break;
               }

               if(chararr[j] == '/'){
                   j++;
               } else {
                   break;
               }
               if(Character.isLetterOrDigit(chararr[j])) {
                   while (j < chararr.length && Character.isLetterOrDigit(chararr[j])) {
                       j++;
                   }
               } else {
                    break;
               }

               if(chararr[j] == '\\'){
                   j++;
               } else {
                   break;
               }

               if(Character.isLetterOrDigit(chararr[j])) {
                   while (j < chararr.length && Character.isLetterOrDigit(chararr[j])) {
                       j++;
                       countAfter ++;
                   }
               } else {
                   break;
               }

            count += countAfter*countbefore;
           }
            arr[i] =count;

        }
        return arr;
    }
}
