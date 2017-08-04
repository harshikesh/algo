package hackerearth;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 16/10/16.
 */

public class WorksApp {
    static Object[][] finalObject;

    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int row = cin.nextInt();
        int column = cin.nextInt();
        int totalMatrix = cin.nextInt();

        finalObject = new Object[row][column];


        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int[] counterArray = {0, 0};
                finalObject[i][j] = counterArray;
            }
        }

        for (int i = 0; i < totalMatrix; i++) {
            int[][] tempMatrix = new int[row][column];
            for (int j = 0; j < row; j++) {
                for (int k = 0; k < column; k++) {
                    tempMatrix[j][k] = cin.nextInt();
                }
            }
            findSmallestNoOfPixel(tempMatrix, row, column);
        }

        int totalPoint = row * column;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                int[] tempMark = (int[]) finalObject[i][j];
                if (tempMark[0] == totalMatrix || tempMark[1] == totalMatrix) {
                    totalPoint--;
                }
            }
        }
        int border = (int) Math.ceil(log(totalMatrix, 2));
        if (totalPoint <= border) {
            border = 0;
        }
        System.out.println(border);
    }

    public static int findSmallestNoOfPixel(int[][] tempMatrix, int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int[] mark = (int[]) finalObject[i][j];
                if (tempMatrix[i][j] == 1) {
                    mark[1] = mark[1] + 1;
                } else {
                    mark[0] = mark[0] +1 ;
                }
                finalObject[i][j] = mark;
            }
        }
        return 0;
    }

    static public double log(double value, double base) {

        return Math.log(value) / Math.log(base);
    }
}
