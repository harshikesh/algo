package hackerearth;

/**
 * Created by harshikesh.kumar on 22/05/17.
 */
public class MissingNumber {
    public static void main(String[] args) {

        int arr[] = {1,1,2,2,3,4,3,5,5,6,6,7,7,8,8};

        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor = xor ^ arr[i];
        }
        System.out.println(xor);
    }
}
