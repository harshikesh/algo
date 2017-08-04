import Strings.CustomThread;
import Strings.Lock;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 31/03/17.
 */
public class FileMulti {

    public static void main(String[] args) throws IOException {

        System.out.println("Enter number of threads");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());


        ArrayList<Integer> threadNumber = new ArrayList<>();
        ArrayList<String> messages = new ArrayList<>();
        ArrayList<Integer> lineNumber = new ArrayList<>();

        for (int i = 1; i <= num; i++) {
            String[] str = bufferedReader.readLine().split(" ");
            int thread = Integer.parseInt(str[0]);
            String message = str[1];
            int linenumber = Integer.parseInt(str[2]);
            threadNumber.add(thread);
            messages.add(message);
            lineNumber.add(linenumber);
        }

        HashMap<Integer,Object> hashMap = new HashMap<>();

        for (int i = 0; i < threadNumber.size(); i++) {
            int t =lineNumber.get(i);
            Object obj;
            if(hashMap.get(t) != null){
                obj = hashMap.get(t);
            } else {
                obj = new Lock(t);
                hashMap.put(t,obj);
            }
            CustomThread customThread = new CustomThread("Thread number "+i,lineNumber.get(i),obj,messages.get(i));
            customThread.run();
        }
        System.exit(0);
    }
}
