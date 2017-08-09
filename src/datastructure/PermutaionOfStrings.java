package datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by harshikesh.kumar on 06/03/17.
 */
public class PermutaionOfStrings {

    static int count =1;
    public static void main(String[] args) {
        String s = "abc";
        generatePerm("",s);
    }

    private static void generatePerm(String pre ,String s) {

        System.out.println(pre+"");
        if(s.length() == 0){
           // System.out.println(pre+""+ count++);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            generatePerm(pre+s.charAt(i),s.substring(0,i)+s.substring(i+1));
        }
    }

    public static <T> List<ArrayList<T>> checkPerm(List<T> listData) {
        List<ArrayList<T>> result = new ArrayList<ArrayList<T>>();
        result.add(new ArrayList<T>());
        for (int i = 0; i < listData.size(); i++) {
            ArrayList<ArrayList<T>> current = new ArrayList<ArrayList<T>>();

            for (ArrayList<T> l : result) {
                for (int j = 0; j < l.size() + 1; j++) {
                    l.add(j, listData.get(i));
                    ArrayList<T> temp = new ArrayList<T>(l);
                    current.add(temp);
                    l.remove(j);
                }
            }
            result = new ArrayList<ArrayList<T>>(current);
        }
        return result;
    }
}
