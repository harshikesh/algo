package codejam;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */
public class Quali2 {
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int test = sc.nextInt();
        for (int i = 0; i < test; i++) {
            long number = sc.nextLong();
            String temp = Long.toString(number);
            int[] digits = new int[temp.length()];
            for (int j = 0; j < temp.length(); j++)
            {
                digits[j] = temp.charAt(j) - '0';
            }

            System.out.print("Case #"+(i+1)+": ");
            if(digits.length == 1){
                System.out.print(digits[0]);
                System.out.println();
                continue;
            }
            int index = -1;
            for (int k = digits.length-1; k > 0; k--) {
                if( digits[k-1] == digits[k])
                    index = k-1;
                else
                    break;
            }
            for (int k = digits.length-1; k > 0; k--) {
                if( digits[k-1] > digits[k]) {
                    index = k-1;
                    while (k-2 >= 0 && digits[k-2] == digits[k-1]){
                        index = k-2;
                        k=k-1;
                    }
              }
            }

            if(index == -1){
                for (int j = 0; j < digits.length-1; j++) {
                    System.out.print(digits[j]);
                }
                System.out.print(digits[digits.length-1]-1);
            } else {
                for (int j = 0; j < index; j++) {
                    System.out.print(digits[j]);
                }
                System.out.print(digits[index]-1 == 0 ? "" :digits[index]-1);
                for (int j = index+1; j < digits.length; j++) {
                    System.out.print("9");
                }
            }
            System.out.println();
        }
    }
}
