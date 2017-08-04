package datastructure;

/**
 * Created by harshikesh.kumar on 12/02/17.
 */
public class NegativeSign {

    public static void main(String[] args) {



    }
    boolean divideArray(int arr[])
    {
        int n = arr.length;
        int sum = 0;
        for (int i = 0; i < n; i++)
            sum += arr[i];

        int tempSum = 0;

        for (int i = 0; i < n; i++)
        {
            if (2 * tempSum + arr[i] == sum)
            {
                //printSubArray(arr, 0, i - 1);
                //printSubArray(arr, i + 1, n - 1);
                return true;
            }
            tempSum += arr[i];
        }
        return false;
    }
}
