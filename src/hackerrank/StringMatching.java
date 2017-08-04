package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 20/03/17.
 */
public class StringMatching {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int q = in.nextInt();
        String[] s = new String[n];
        for (int s_i = 0; s_i < n; s_i++) {
            s[s_i] = in.next();
        }
        int matrix[][] = new int[n][n];
        for (int s_i = 0; s_i < n; s_i++) {
            for (int j = 0; j < n; j++) {
                String a = s[s_i];
                String b = s[j];
                if(s_i!=j) {
                    if(matrix[j][s_i] == 0 )
                    matrix[s_i][j] = findcommon(a, b);
                    matrix[j][s_i] = matrix[s_i][j];
                }
            }
        }
        for (int a0 = 0; a0 < q; a0++) {
            int x = in.nextInt();
            int y = in.nextInt();
            System.out.println(matrix[x][y]);
            // your code goes here
        }
    }

    static int findcommon1(String a, String b) {

        int alength = a.length();
        int blength = b.length();
        int max = 0;
        for (int i = 0; i < alength; i++) {
            int count = 0;
            int temp = i;
            for (int j = 0; j < blength; j++) {
                if (temp <= a.length() -1 && a.charAt(temp) == b.charAt(j)) {
                    temp++;
                    count++;
                    max = max < count ? count : max;
                } else {
                    temp = i;
                }
            }

        }
        return max;

    }

    static int findcommon(String a, String b ) {

        int alength = a.length();
        int blength = b.length();
        int mat[][] = new int[alength+1][blength+1];
        int max = 0;
        for (int i = 0; i <= alength; i++) {
            for (int j = 0; j <= blength; j++) {
                if(i == 0 || j==0){
                    mat[i][j] = 0;

                }
                else if(a.charAt(i-1) == b.charAt(j-1)){
                    mat[i][j] = mat[i-1][j-1]+1;
                    max = max < mat[i][j] ?mat[i][j] : max;
                }

            }
        }
        return max;

    }
}
