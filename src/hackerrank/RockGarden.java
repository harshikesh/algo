package hackerrank;

import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 25/02/17.
 */
public class RockGarden {

    static double matval[][] = null;

    static class Point{
        int x;
        int y;
    }
    static void combinationUtil(Point arr[], Point data[], int start,
                                int end, int index, int r)
    {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                System.out.print(data[j].x+""+data[j].y+" ");
            System.out.println("");
            return;
        }

        for (int i=start; i<=end && end-i+1 >= r-index; i++)
        {
            data[index] = arr[i];
            combinationUtil(arr, data, i+1, end, index+1, r);
        }
    }

    static void printCombination(Point arr[], int n, int r)
    {
        Point data[]=new Point[r];
        combinationUtil(arr, data, 0, n-1, 0, r);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        double mat[][] = new double[13][13];
        matval = new double[13][13];
        Point parr[] = new Point[169];
        int k =0;
        for (int i = 0; i <= 12; i++) {
            for (int j = 0; j <= 12; j++) {
                double val = findDistance(i,j);
                if(isInteger(val)){
                    matval[i][j]= -2;
                } else {
                    Point p = new Point();
                    p.x = i-12;
                    p.y = j-12;
                    parr[k++] = p;
                    matval[i][j] = val;
                }
            }
        }
        printCombination(parr,k,7);


        mat[x][y] = matval[x][y];
        //boolean find = findLocation(0, mat,1,mat[x][y]);
        if(false){
            for (int i = 0; i <= 12; i++) {
                for (int j = 0; j <= 12; j++) {
                    if(mat[i][j] != 0.0){
                        System.out.print((i-12)+" "+ (j-12));
                        System.out.println();
                    }
                }
            }
        }
    }

    private static boolean findLocation(int j,double mat[][],int count,double sum) {

        if(j > 12){
            return  false;
        }
        if(count > 12){
            return false;
        }
//        if(count == 12 && (sum - (int)sum <= Math.pow(10,-12))){
//            System.out.println(sum);
//            return true;
//        }


        for (int i = 0; i <= 12; i++) {

            if( i == 0 && j ==0){
                continue;
            }
           System.out.println( count);
                if(mat[i][j] == 0.0 &&  !(matval[i][j] == -2)) {
                    mat[i][j] = matval[i][j];
                    if(count + 1 == 12 && (sum+mat[i][j] - (int)(sum+mat[i][j]) <= Math.pow(10,-12))){
                        return true;
                    }
                    boolean f = findLocation(j+1, mat, count + 1, sum+mat[i][j]);
                    if(f){
                        return true;
                    }
                        //sum -= mat[i][j];
                        mat[i][j] = 0.0;
                }
            }
        return false;
    }

    private static boolean isInteger(double val){
        return (val - (int)val <= Math.pow(10,-9));
    }
    private static double findDistance(int x, int y) {
        double dist  = Math.abs(x*x+y*y);
        return Math.sqrt(dist);
    }
}
