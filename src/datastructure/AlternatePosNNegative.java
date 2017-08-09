package datastructure;

/**
 * Created by harshikesh.kumar on 15/06/16.
 */
public class AlternatePosNNegative {
    static void alternatePosNeg(int arr[]){
        int i =0,j = 1 ;
        while(i<arr.length && j<arr.length) {
            while(i<=arr.length-1 && arr[i]<0){
                i += 2;
            }
            while( j<=arr.length-1  && arr[j]>0){
                j += 2;
            }
            if(i<arr.length && j<arr.length) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        for (int k = 0; k < arr.length ; k++) {

            System.out.print(arr[k]+", ");
        }
    }

    static void negativepositive(int arr[]){
        int i =0,j = arr.length-1 ;
        while(i<j) {
            while(i<arr.length-1 && arr[i]<0){
                i++;
            }
            while( j>0  && arr[j]>0){
               j--;
            }
            if(i<j) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }

        }
        for (int k = 0; k < arr.length ; k++) {

            System.out.print(arr[k]+", ");
        }
    }

    public static void main(String[] args) {
        int arr[] = {2,3,5,-2,-6,7,-3,-1};
        //-2 -6 -6 -1 5 3
        alternatePosNeg(arr);
    }
}
