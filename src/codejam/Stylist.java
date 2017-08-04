package codejam;

/**
 * Created by harshikesh.kumar on 08/04/17.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Stylist {


    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());
        for (int i = 0; i < test; i++) {
            String str[] = br.readLine().split(" ");
            int N = Integer.parseInt(str[0]);
            int M = Integer.parseInt(str[1]);
            char[][] mat = new char[N][N];
            int points = 0;
            for (int j = 0; j < M; j++) {
                String row[] = br.readLine().split(" ");
                int x = Integer.parseInt(row[1]);
                int y = Integer.parseInt(row[2]);
                mat[x-1][y-1] = row[0].charAt(0);
                if (mat[x-1][y-1] == 'o') {
                    points += 2;
                } else {
                    points += 1;
                }
            }


            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    //
                    isValid(mat, j, k, N);
                    if (mat[j][k] == '0') {
                        mat[j][k] = 'o';
                        points+=2;
                        if(!isValid(mat,j,k,N)){
                            mat[j][k] = '0';
                            points-=2;
                        } else{
                            continue;
                        }
                        mat[j][k] = '+';
                        points+=1;
                        if(!isValid(mat,j,k,N)){
                            mat[j][k] = '0';
                            points-=2;
                        }

                    } else {
                        char temp = mat[j][k];
                        mat[j][k] = 'o';
                        points+=1;
                        if(!isValid(mat,j,k,N)){
                            mat[j][k] = temp;
                            points-=1;
                        } else{
                            continue;
                        }
                    }
                }
            }

            System.out.print(anstoken + (i + 1) + anstoken2);
            System.out.println(points);

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    System.out.print(mat[j][k] + " ");
                }
                System.out.println();
            }
            System.out.println();
        }
    }

    private static boolean isValid(char[][] mat, int j, int k, int N) {

        int count = 0;
        //row
        for (int i = 0; i < N; i++) {
            if (mat[j][i] == 'x' || mat[j][i] == 'o') {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }
        count = 0;
        for (int i = 0; i < N; i++) {
            if (mat[i][k] == 'x' || mat[i][k] == 'o') {
                count++;
            }
            if (count == 2) {
                return false;
            }
        }

        HashMap<Character,Integer> hash = new HashMap<>();
        HashMap<Character,Integer> hash2 = new HashMap<>();
        for (int i = 0; i < N; i++) {
            for (int l = 0; l < N; l++) {
                if(i+l == j+k){
                    if((hash.containsKey('+') || hash.containsKey('o')) && (mat[i][l] == '+' || mat[i][l] =='o')){
                        return false;
                    } else {
                        hash.put(mat[i][l],1);
                    }
                }
                if(i-l == j-k){
                    if((hash2.containsKey('+') || hash2.containsKey('o')) && (mat[i][l] == '+' || mat[i][l] =='o')){
                        return false;
                    } else {
                        hash2.put(mat[i][l],1);
                    }
                }
            }
        }
        return true;

    }
}
