package datastructure;

/**
 * Created by harshikesh.kumar on 13/07/16.
 */
public class findNumberInfiniteSortedArray {

    static int findPos(int arr[], int key){

        int low = 0;
        int h = 1;

        int val  = arr[low];

        while(val < key)
        {
            low = h;
            h = h*2;
            val = arr[h];
        }
        return find(arr,low,h,key);
    }

    private static int find(int[] arr, int low, int h, int key) {
        System.out.println(low +"- low " +"high  - "+h );

        while(low<=h) {
            int mid = low + (h-low)/2;
            if (key == arr[mid]) {
                return mid;
            } else if (key > arr[mid]) {
                low = mid+1;
            } else {
                h = mid-1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

        int arr[] = {1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77};
        System.out.println(findPos(arr,9));
    }
}
