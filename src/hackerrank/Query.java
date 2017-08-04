package hackerrank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by harshikesh.kumar on 09/07/17.
 */
public class Query {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M  = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());
        int Q  = Integer.parseInt(br.readLine());
        int a = 1000000000;
        int b = 900000000;

        System.out.println(a*b);
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String str = br.readLine();
            arrayList.add(str);
        }

        for (int i = 0; i < Q; i++) {
            int count =0;
            String str = br.readLine();
            int index = str.indexOf("?");
            String start = str.substring(0,index);
            String last = str.substring(index+1);
            for (int j = 0; j < arrayList.size(); j++) {
                if(arrayList.get(j).startsWith(start) && arrayList.get(j).endsWith(last)){
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
