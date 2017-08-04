package codejam;

/**
 * Created by harshikesh.kumar on 06/06/17.
 */
public class palin2 {

    public static void main(String[] args) {
        String str = "aaaaaaaa";
        System.out.println(coArray(str));

    }
   static int coArray(String s )
    {
        char str[] = s.toCharArray();
        int n = str.length;
        int arr[] = new int[n];

        int len = 0;
        int i =1;
        arr[0] = 0;
        while (i < n)
        {
            if (str[i] == str[len]) {
                len++;
                arr[i] = len;
                i++;
            }
            else
            {
                if (len != 0)
                {
                    len = arr[len-1];
                }
                else {
                    arr[i] = 0;
                    i++;
                }
            }
        }
        return n/(n-arr[n-1]);
    }



}
