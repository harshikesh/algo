package codejam;

/**
 * Created by harshikesh.kumar on 06/06/17.
 */
public class SortVersion {

    public static void main(String[] args) {
        String version[] = {"0.0.0","0","0.0","1.113","0.0.0.1","2.0.0","1.2","2","0.1","1.2.1","1.1.1","2.0"};
        String [] v =answer(version);
        for (String str:v) {
            System.out.println(str);
        }
    }

    static String[] answer(String l[]){

        String t;
        for (int i = 1; i < l.length; i++) {
            for(int j = i ; j > 0 ; j--){
                if(compare(l[j],l[j-1])<0){
                    t = l[j];
                    l[j] = l[j-1];
                    l[j-1] = t;
                }
            }
        }
        return l;

    }

    public static int compare(String v1, String v2) {
        String[] arr1 = v1.split("\\.");
        String[] arr2 = v2.split("\\.");
        int size = 0;
        if (arr1.length < arr2.length)
            size = arr1.length;
        else {
            size = arr2.length;
        }
        int i=0;
        for (i = 0; i < size; i++)
        {
            if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]))
                return -1;
            if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
                return 1;

        }
        if(arr1.length > i){
            return 1;
        }
        if(arr2.length > i){
            return -1;
        }
        return 0;
    }
}
