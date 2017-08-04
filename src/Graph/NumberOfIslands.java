package Graph;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 10/07/16.
 */
public class NumberOfIslands {

    public static void main (String[] args) throws java.lang.Exception
    {
        int M[][]=  new int[5][5];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                M[i][j] = sc.nextInt();
            }
        }
        System.out.println("Number of islands is: "+ countIslands(M));
    }

    static final int ROW = 5, COL = 5;

    static boolean isSafe(int M[][], int row, int col,
                   boolean visited[][])
    {

        return (row >= 0) && (row < ROW) &&
                (col >= 0) && (col < COL) &&
                (M[row][col]==0 && !visited[row][col]);
    }

    static void DFS(int M[][], int row, int col, boolean visited[][])
    {
        int rowNbr[] = new int[] {-1, -1, -1,  0, 0,  1, 1, 1};
        int colNbr[] = new int[] {-1,  0,  1, -1, 1, -1, 0, 1};

        visited[row][col] = true;

        for (int k = 0; k < 8; ++k)
            if (isSafe(M, row + rowNbr[k], col + colNbr[k], visited) )
                DFS(M, row + rowNbr[k], col + colNbr[k], visited);
    }

    // The main function that returns count of islands in a given
    //  boolean 2D matrix
    static int countIslands(int M[][])
    {
        boolean visited[][] = new boolean[ROW][COL];

        int count = 0;
        for (int i = 0; i < ROW; ++i)
        {
                if (M[i][0]==0  || M[i][COL-1] ==0){
                    return -1;
                }
        }
        for (int i = 0; i < COL; ++i)
        {
            if (M[0][i]==0 || M[ROW-1][i] ==0 ){
                return -1;
            }
        }


        for (int i = 0; i < ROW; ++i)
            for (int j = 0; j < COL; ++j)
                if (M[i][j]==0 && !visited[i][j]) {
                    DFS(M, i, j, visited);
                    ++count;
                }

        return count;
    }
}
