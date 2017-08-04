package hackerearth;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 20/08/16.
 */
public class Walmart {
        static	char max ;
        public static void main(String args[] ) throws Exception {
            Scanner sc = new Scanner(System.in);
            long N = sc.nextLong();
            int swap = sc.nextInt();

            calculate(N,swap);
        }

        static void swap(int i,int j,char arr[]){
            for (int k = j; k >i; k--) {
                char temp = arr[k];
                arr[k] = arr[k-1];
                arr[k-1] = temp;
            }
        }
        static void calculate(long num,int k){

            if(k==0){
                return;
            }
            int index  = 0;
            char arr[] = String.valueOf(num).toCharArray();
            for (int i = 0; i < arr.length-1; i++) {
                max = arr[i];
                for (int j = i+1; j <= i+k; j++) {
                    if(arr[j]> max ){
                        max= arr[j];
                        index = j;
                    }
                }
                swap(i,index,arr);
                k = k-index+i;
                if(k==0){
                    break;
                }
            }
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]);
            }

        }

}
