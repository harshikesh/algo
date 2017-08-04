package codejam;

import datastructure.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */
public class Bathroom {
    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 1; i <= test; i++) {
            String temp[] = br.readLine().split(" ");
            int totalStalls = Integer.parseInt(temp[0]);
            int totalPeople = Integer.parseInt(temp[1]);

            System.out.print(anstoken + i + anstoken2 );
            if(totalStalls == totalPeople){
                System.out.print(0+" "+0);
                System.out.println();
                continue;
            }
            findAns(totalStalls,totalPeople);
            System.out.println();
        }
    }
    private static void findAns(int totalStalls, int totalPeople) {
        Queue<Integer> queue = new LinkedList<>();
        Queue<Integer> queue2 = new LinkedList<>();

        boolean odd = true;
       if(totalStalls %2 ==0 ){
           queue.add(totalStalls/2);
           odd = false;
       } else {
           queue.add((totalStalls+1)/2);
       }

        if(odd) {
            for (int i = 1; i < totalPeople; i++) {
                if(i%2 != 0 && queue.peek()!= 1){
                    int num = queue.peek();
                    queue.add((int) Math.ceil(num / 2));
                } else {
                    int num = queue.peek();
                    queue.add((int) Math.ceil((num + totalStalls)/ 2.0));
                    queue2.add(queue.remove());
                }
            }
        } else {
            for (int i = 1; i < totalPeople; i++) {
                if(i%2 == 0 && queue.peek()!= 1){
                    int num = queue.peek();
                    queue.add((int) Math.ceil(num / 2.0));
                    queue2.add(queue.remove());
                } else {
                    int num = queue.peek();
                    queue.add((int) Math.ceil((num + totalStalls)/ 2.0));
                }
            }
        }

        int size = queue.size();
        int elem = 0;

        Iterator itr = queue.iterator();
        while (itr.hasNext()){
            elem = (Integer) itr.next();
        }
        queue.addAll(queue2);
        int left = elem - 0;
        int right = totalStalls+1 - elem;
        itr = queue.iterator();
        while (itr.hasNext()){
            if (queue.peek()  > elem && (queue.peek() - elem) < right) {
                right = queue.peek() - elem;
            }
            if (elem > queue.peek()  && (elem - queue.peek()) < left) {
                left = elem - queue.peek();
            }
            itr.next();
        }
        System.out.print(""+Math.max(left-1,right-1)+" "+ Math.min(left-1,right-1));

    }

}
