package Graph;

/**
 * Created by harshikesh.kumar on 29/07/16.
 */
public class RatMazeShortestPath {
    private static final int N = 5;
    static int sol[][] = new int[5][5];

    public static void main(String args[]) {
        int matrix[][] = new int[][]{{1, 1, 1, 0, 0},
                {1, 0, 1, 1, 0},
                {1, 0, 0, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 0, 0, 0, 1}
        };
        // size of maze 5*5
        solveMaze(matrix, 5);
       // solveMazeUtil(matrix,0,0,sol);
        printSolution(N);

    }

    private static void solveMaze(int[][] matrix, int n) {
        if (solveMazeUtil1(matrix, 0, 0, n, 0)) {
            System.out.println("path exist");
        }

      //  printSolution(n);
    }

    private static void printSolution(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(sol[i][j]+ " ");
            }
            System.out.println();
        }
    }


    private static boolean solveMazeUtil1(int[][] matrix, int i, int j, int n, int count) {


        if (i == n - 1 && j == n - 1) {
            sol[n-1][n-1] = 2;
            System.out.println("Path found" + count);
            return true;
        }
//        int x[] = {-1, -1, -1, 0, 0, 1, 1, 1};
//        int y[] = {-1, 0, 1, -1, 1, 0, -1, 1};

        if (isSafe(matrix, i, j, n)  ) {
            System.out.println(i+"   "+j);
            sol[i][j] = 1;
                if((count != 1) && solveMazeUtil1(matrix, i + 1, j + 0, n, -1)) {
                    return true;
                }
//            if(solveMazeUtil1(matrix, i + -1, j + 1, n, 0)) {
//                return true;
//           }
// if(solveMazeUtil1(matrix, i + -1, j + -1, n, 0)) {
//                return true;
//            }
            if((count != 2) && solveMazeUtil1(matrix, i + 0, j + -1, n, -2)) {
                return true;
            }if(count != -2 &&solveMazeUtil1(matrix, i + 0, j + 1, n, 2)) {
                return true;
            }
//            if(solveMazeUtil1(matrix, i + 1, j + -1, n, 0)) {
//                return true;
//            }
//            if(solveMazeUtil1(matrix, i + 1, j + 1, n, 0)) {
//                return true;
//            }
            if(count != -1 &&solveMazeUtil1(matrix, i + -1, j + 0, n, 1)) {
                return true;
            }

                sol[i][j] =0;
                return false;
        }
        return false;
    }

   static boolean solveMazeUtil(int maze[][], int x, int y,
                          int sol[][])
    {
        // if (x,y is goal) return true
        if (x == N - 1 && y == N - 1)
        {
            sol[x][y] = 1;
            return true;
        }

        // Check if maze[x][y] is valid
        if (isSafe(maze, x, y,N) == true)
        {
            // mark x,y as part of solution path
            sol[x][y] = 1;

            /* Move forward in x direction */
            if (solveMazeUtil(maze, x + 1, y, sol))
                return true;

            /* If moving in x direction doesn't give
               solution then  Move down in y direction */
            if (solveMazeUtil(maze, x, y + 1, sol))
                return true;

            /* If none of the above movements work then
               BACKTRACK: unmark x,y as part of solution
               path */
            sol[x][y] = 0;
            return false;
        }

        return false;
    }

    private static boolean isSafe(int[][] matrix, int i, int j, int n) {
        if(i>=0 && i<n && j>=0 && j<n && matrix[i][j]==1){
            return true;
        }
        return false;
    }

}
