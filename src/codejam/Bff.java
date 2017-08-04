package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 12/04/17.
 */
public class Bff {
    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = getIntgerInput(br);


        for (int i = 0; i < test; i++) {
            int M = getIntgerInput(br);
            String s[] =getSplitString(br);
            int bf [] = new int[M+1];
            for (int j = 0; j < s.length; j++) {
                bf[j+1] = Integer.parseInt(s[j]);
            }
            int max =0;
            for (int j = 1; j <= M; j++) {
                int start = j;
                int temp = bf[start];
                int visited[] = new int[M+1];
                visited[start] = 1;
                int count = 1;
                while (true) {
                    if(visited[temp] == 1){
                        break;
                    }
                    count++;
                    visited[temp] = 1;
                    int t =temp;
                    temp = bf[temp];
                    if(t == bf[temp]){
                        max =  max > count+1 ? max:count+1;
                        visited[temp] = 1;
                        for (int k = 1; k <= M; k++) {
                            int tem = k;
                            if(visited[tem] != 1){
                                int co = 0;
                                while (visited[tem] != 1){
                                    co++;
                                    visited[tem] = 1;
                                    if(bf[tem] ==temp){
                                        count =  count +co;
                                        max =  max > count ? max:count;
                                        break;
                                    }
                                    tem = bf[tem];
                                }
                            }
                        }
                        break;
                    }
                    if(temp == start){
                       max =  max > count ? max:count;
                        break;
                    }
                }
            }
            System.out.println(anstoken+i+anstoken2+max);
        }

    }

    public static int getIntgerInput(BufferedReader br) throws IOException {
       return Integer.parseInt(br.readLine());
    }

    public static String[] getSplitString(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}
