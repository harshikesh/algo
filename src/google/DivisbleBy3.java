package google;

import java.math.BigInteger;
import java.util.*;
import java.util.regex.Matcher;

/**
 * Created by harshikesh.kumar on 08/08/17.
 */
public class DivisbleBy3  {

    public static void main(String[] args) {

//        int a = 999999999;
        int arr[] = {2,3,4,6,7,8,8,3,9,7,2,4,7};
        int arr1[] = {0};
        long a = findArr(arr1);
        System.out.println(a);
    }

    private static long findArr(int[] arr) {

        Arrays.sort(arr);
        List<Integer> mod1 = new LinkedList<>();
        List<Integer> mod2 = new LinkedList<>();
        List<Integer> mod3 = new LinkedList<>();

        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum = sum + arr[i];
            if (arr[i] % 3 == 1) {
                mod1.add(arr[i]);
            } else if (arr[i] % 3 == 2) {
                mod2.add(arr[i]);
            } else {
                mod3.add(arr[i]);
            }
        }

            if(sum %3 == 1){
                if(mod1.size() !=0){
                    sum -= mod1.remove(0);
                } else if(mod2.size() !=0) {
                    sum -= mod2.remove(0);
                    if(mod2.size() != 0)
                    sum -= mod2.remove(0);
                }
            } else if(sum %3 == 2){
                if(mod2.size() !=0){
                    sum -= mod2.remove(0);
                } else if(mod1.size() !=0) {
                    sum -= mod1.remove(0);
                    if(mod1.size()!=0)
                    sum -= mod1.remove(0);
                }
            }
        if(sum%3 != 0 ){
            return -1;
        }
        ArrayList<Integer> array = new ArrayList<>();
        array.addAll(mod1);
        array.addAll(mod2);
        array.addAll(mod3);
        Collections.sort(array);

        int finalValue = 0;
        int j =0 ;
        for (Integer a : array) {
            finalValue += a * (Math.pow(10,j));
            j++;
        }
        return  finalValue;
    }

}
