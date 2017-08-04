package hackerrank;

/**
 * Created by harshikesh.kumar on 18/08/16.
 */
public class Swap {

    public static void main(String[] args) {
        int arr[] = {2,3,5,7};
        int arr1[] = {2,5,3,7};

        int mat[][] = new int[arr.length+1][arr.length+1];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                mat[i][j] = arr[i];
            }
        }
    }
}
