package datastructure;

import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by harshikesh.kumar on 09/01/17.
 */
public class PermutaionEts<E> {
    private E[] arr;
    private int[] ind;

    public static void main(String[] args) {


        PermutaionEts p =new PermutaionEts();
        Object[] str = {"rr","s","a","r","l"};
        p.perm(str);
    }

   void  perm(E[] arr){
        this.arr = arr.clone();
        ind = new int[arr.length];
        //convert an array of any elements into array of integers - first occurrence is used to enumerate
        Map<E, Integer> hm = new HashMap<E, Integer>();
        for(int i = 0; i < arr.length; i++){
            Integer n = hm.get(arr[i]);
            if (n == null){
                System.out.println("null");
                hm.put(arr[i], i);
                n = i;
            }
            ind[i] = n.intValue();
        }
        Arrays.sort(ind);//start with ascending sequence of integers


        //output = new E[arr.length]; <-- cannot do in Java with generics, so use reflection
        //output = (E[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
    }
}
