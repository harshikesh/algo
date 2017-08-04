package hackerrank;

import java.util.Scanner;
import java.util.Stack;

/**
 * Created by harshikesh.kumar on 25/06/16.
 */
public class NumberOfEqualStacks {


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        int a, b, c;
        Scanner sc = new Scanner(System.in);
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        Stack<Integer> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        Stack<Integer> st3 = new Stack<>();
        Stack<Integer> st = new Stack<>();

        int suma = 0, sumb = 0, sumc = 0;
        for (int i = 0; i < a; i++) {
            int k = sc.nextInt();
            st.push(k);
            suma += k;
        }
        for (int i = 0; i < a; i++) {
            st1.push(st.pop());
        }
        st.clear();
        for (int i = 0; i < b; i++) {

            int k = sc.nextInt();
            st.push(k);
            sumb += k;
        }
        for (int i = 0; i < b; i++) {
            st2.push(st.pop());
        }
        st.clear();
            for (int i = 0; i < c; i++) {
            int k = sc.nextInt();
            st.push(k);
            sumc += k;
        }

        for (int i = 0; i < c; i++) {
            st3.push(st.pop());
        }
        st.clear();
        while (true) {

            if (suma == sumb && sumb == sumc) {
                break;
            }

            if (suma >= sumb && suma >= sumc) {
                suma -=st1.pop();

            } else if(sumb >= sumc && sumb >= suma){
                sumb  -= st2.pop();
            }
            else if(sumc >= sumb && sumc >= suma){
                sumc -= st3.pop();
            }
        }
        int sum =0;
        while (!st1.isEmpty()){
            sum = sum + st1.pop();
        }
        System.out.println(sum);
    }
}
