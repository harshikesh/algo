package Strings;

/**
 * Created by harshikesh.kumar on 20/06/16.
 */
public class KMP {


    static int[] prep;

    static void preProcessing(char arr[])
    {
        int i =0;
        int len = arr.length;
        prep = new int[len];
        prep[0] = 0;

        for (int j=1; j < len;) {
            if(arr[i] == arr[j]){
                // increament i and put the i in preprocessing place.
                i++;
                prep[j] = i;
                j++;
            }else{
                if(i!=0) {
                    //previous of i-1 should be saved in i
                    i = prep[i - 1];
                } else{
                    //increment j after pushing preprocessing array with 0.
                    prep[j] = 0;
                    j++;
                }
            }
        }
        for (int j = 0; j <len ; j++) {
            System.out.print(prep[j]+", ");
        }
    }

    static void kmp(char text[] , char match[]){

        preProcessing(match);

        int i=0, j=0;

        while(i<text.length) {
            if (text[i] == match[j]) {
                i++;
                j++;
                if(j==match.length){
                    System.out.println("found at index : "+ (i-j));
                    j = prep[j-1];
                    //continue;
                }
            } else{
                if(j!=0) {
                    j = prep[j - 1];
                } else {
                    i++;
                }
            }
        }
    }

    public static void main(String[] args) {
        char text[] = "ABABDABACDABABCABAB".toCharArray();
        char pat[] = "ABABCABAB".toCharArray();
        kmp(text,pat);
    }
}
