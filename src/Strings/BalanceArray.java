package Strings;

/**
 * Created by harshikesh.kumar on 13/07/16.
 */
public class BalanceArray {

    static int getbalancedIndex(int arr[]){
        int low =0;
        int high =arr.length-1;

        int lsum = 0;
        int rsum = 0;

        while(high>low) {
            if (lsum <= rsum) {
                lsum += arr[low];
                low++;
            } else {
                rsum += arr[high];
                high--;
            }
        }
        return high;

    }
    public static void main(String[] args) {

            int arr[] = {1,3,4,5,6,8};
        System.out.println(getbalancedIndex(arr));
    }
}
