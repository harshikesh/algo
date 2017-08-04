package datastructure;

/**
 * Created by harshikesh.kumar on 20/12/16.
 */
public class Track {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("kabbbaaccd".toCharArray(), "kabbbaaccd".length()));
    }

    public static char[] removeDuplicates(char[] str, int length) {
        int i, k = 0;
        int len = length;
        boolean flag = true;
        while (flag) {
            flag = false;
            k=0;
            for (i = 1; i < len - 1; i++) {
                if (str[i - 1] == str[i] ) {
                    if(str[i] == str[i + 1]){
                        flag = true;
                        while (str[i] == str[i + 1])
                            i++;
                    }
                        str[k] = str[i-1];
                        k++;

                } else {
                        str[k] = str[i-1];
                        k++;
                }
            }
        }
        return str;
    }
}
