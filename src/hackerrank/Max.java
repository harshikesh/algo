package hackerrank;

/**
 * Created by harshikesh.kumar on 19/08/16.
 */
public class Max {

    static int max = 0;
    public static void main(String[] args) {
        int n = 3576;
        int k = 3;
        max  = n;
        getMax(n,k);
        System.out.println(getMax(n,k));
        System.out.println(max);


    }

    private static int getMax(int n, int k) {

        if(k == 0){
            return max;
        }

        char arr[] = String.valueOf(n).toCharArray();
        for (int i = 0; i < arr.length-1; i++) {

            for (int j = i+1; j < arr.length; j++) {

                if (arr[i] < arr[j]) {
                    arr = swap(i, j, arr);
                    if (Integer.parseInt(new String(arr)) > max) {
                        max = Integer.parseInt(new String(arr));
                        getMax(max, k - 1);
                    }
                    arr = swap(i, j, arr);
                }
            }
        }
        return 0;
    }

    private static char[] swap(int i, int j, char[] arr) {

        char t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;

        return arr;
    }
}
