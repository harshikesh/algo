package Strings;

/**
 * Created by harshikesh.kumar on 13/07/16.
 */
public class LongestStringWRepated {


    public static void main(String[] args) {
        String str = "geeksforgeeks";
        System.out.println(getMaxValue(str));
    }

    private static int getMaxValue(String str) {

        int visited[] = new int[256];
        int max = 0;
        int count =0;

        for (int i = 0; i < 256; i++) {
            visited[i] = -1;
        }


        for (int i = 0; i < str.length(); i++) {
            int temp = visited[str.charAt(i)];
            if(temp == -1 || temp <i-count){
                count ++;
            }
            else {
                if(count >max) {
                    max = count;
                }
                count = i - temp;
            }
            visited[str.charAt(i)] = i;
        }
        return max;
    }
}
