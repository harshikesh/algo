package codejam;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by harshikesh.kumar on 15/04/17.
 */
public class Cake {

    static final String anstoken = "Case #";
    static final String anstoken2 = ": ";


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = getIntgerInput(br);

        for (int i = 0; i < test; i++) {
           String str[] = getSplitString(br);
            int r = Integer.parseInt(str[0]);
            int c = Integer.parseInt(str[1]);
            String mat[][] = new String[r][c];
            int row = 999;
            int col=0;
            for (int j = 0; j < r; j++) {
                String s[] = br.readLine().split("");
                for (int k = 0; k < c; k++) {
                    if(!s[k].equals("?") && row > j){
                        row = j;
                        col = k;
                    }
                    mat[j][k] = s[k];
                }
            }

            for (int j = col-1; j >= 0; j--) {
             if(mat[row][j].equals("?")){
                 mat[row][j] = mat[row][j+1];
             }
            }
            for (int j = col+1; j <c; j++) {
                if(mat[row][j].equals("?")){
                    mat[row][j] = mat[row][j-1];
                }
            }


            for (int j = row-1; j >= 0; j--) {
                boolean empty = true;
                int coll = 0;
                for (int k = 0; k < c; k++) {
                    if(!(mat[j][k].equals("?"))){
                        empty =false;
                        coll = k;
                    }
                }
                if(empty){
                    for (int k = 0; k < c; k++) {
                        mat[j][k] =  mat[j+1][k];
                    }
                } else{
                    for (int k = coll+1; k < c; k++) {
                        if(mat[j][k].equals("?"))
                        mat[j][k] =  mat[j][k-1];
                    }
                    for (int k = coll-1; k >=0; k--) {
                        if(mat[j][k].equals("?"))
                        mat[j][k] =  mat[j][k+1];
                    }
                }
            }

            for (int j = row+1; j < r; j++) {
                boolean empty = true;
                int coll = 0;
                for (int k = 0; k < c; k++) {
                    if(!(mat[j][k].equals("?"))){
                        empty =false;
                        coll = k;
                    }
                }
                if(empty){
                    for (int k = 0; k < c; k++) {
                        mat[j][k] =  mat[j-1][k];
                    }
                } else{
                    for (int k = coll+1; k < c; k++) {
                        if(mat[j][k].equals("?"))
                            mat[j][k] =  mat[j][k-1];
                    }
                    for (int k = coll-1; k >=0; k--) {
                        if(mat[j][k].equals("?"))
                            mat[j][k] =  mat[j][k+1];
                    }
                }
            }

            System.out.println(anstoken+(i+1)+anstoken2);
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    System.out.print(mat[j][k]);
                }
                System.out.println();
            }
        }

    }

    public static int getIntgerInput(BufferedReader br) throws IOException {
        return Integer.parseInt(br.readLine());
    }

    public static String[] getSplitString(BufferedReader br) throws IOException {
        return br.readLine().split(" ");
    }
}
