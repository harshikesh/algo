package datastructure;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 11/02/17.
 */
public class BuildingBlocks3dRain {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int height = row*col;
        int arr[] = new int[height];
        for (int i = 0; i < height; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(GetWaterLevel(row,col,arr));
    }
    public static int GetWaterLevel(int row,int col,int height[]){

        int water[][] = new int[row][col];
        int maxrow[][] = new int[row][col];
        int minrow[][] = new int[row][col];
        int maxcol[][] = new int[row][col];
        int mincol[][] = new int[row][col];

        int count =0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                water[i][j] = height[count++];
            }
        }

        // filling first column
        for (int i = 0; i < row; i++) {
            maxrow[i][0] = water[i][0];
        }
        // filling first column
        for (int i = 0; i < row; i++) {
            minrow[i][col-1] = water[i][col-1];
        }

        // filling first row
        for (int i = 0; i < col; i++) {
            maxcol[0][i] = water[0][i];
        }
        // filling first row
        for (int i = 0; i < col; i++) {
            mincol[row-1][i] = water[row-1][i];
        }

        //max row
        for (int i = 0; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if(water[i][j] > maxrow[i][j-1]){
                maxrow[i][j] = water[i][j];
                } else {
                    maxrow[i][j] = maxrow[i][j-1];
                }
            }
        }
        // min row
        for (int i = 0; i < row; i++) {
            for (int j = col -2; j >= 0; j--) {
                if(water[i][j] > minrow[i][j+1]){
                    minrow[i][j] = water[i][j];
                } else {
                    minrow[i][j] = minrow[i][j+1];
                }
            }
        }
        // max col
        for (int i = 1; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if(water[i][j] > maxcol[i-1][j]){
                    maxcol[i][j] = water[i][j];
                } else {
                    maxcol[i][j] = maxcol[i-1][j];
                }
            }
        }
        // min col
        for (int i = row-2; i >= 0; i--) {
            for (int j = 0; j < col; j++) {
                if(water[i][j] > mincol[i+1][j]){
                    mincol[i][j] = water[i][j];
                } else {
                    mincol[i][j] = mincol[i+1][j];
                }
            }
            }

        int volume =0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                volume += (Math.min(Math.min(mincol[i][j],minrow[i][j]),Math.min(maxcol[i][j],maxrow[i][j]))- water[i][j]);
            }
        }
        return volume;
    }
}
