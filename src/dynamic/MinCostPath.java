package dynamic;

/**
 * Created by harshikesh.kumar on 02/06/16.
 */
public class MinCostPath {


    public static void main(String[] args) {
        int cost[][] = { {1, 2, 3},
            {4, 8, 2},
            {1, 5, 3} };

        findMinCostPath(cost);
    }

    private static void findMinCostPath(int[][] cost) {

        int size = 3;
        int mat[][] = new int[size][size];

        mat[0][0] = cost[0][0];
        for (int i = 1; i < size; i++) {
            // Sum in first row
            mat[0][i] = cost[0][i]+cost[0][i-1];
        }
        for (int i = 1; i < size; i++) {
            // Sum in first column
            mat[i][0] = cost[i][0]+cost[i-1][0];;
        }

        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                mat[i][j] = Math.min(Math.min(mat[i][j-1],mat[i-1][j]),mat[i-1][j-1])+cost[i][j];
            }
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println(mat[2][2]);

    }
}
