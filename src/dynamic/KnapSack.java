package dynamic;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by harshikesh.kumar on 03/06/16.
 */

//https://www.youtube.com/watch?v=8LusJS5-AGo
public class KnapSack {

    static int[] weight;
    //ArrayList
    static  int[] val;
    static HashMap<Integer,Integer> hash = new HashMap<>();
    static void maxValueWithFixedWeight(int total,int wt){
        int valMatrix[][] = new int[total][wt+1];
        //total value to be obtained by total weight 0 is 0
        for (int i = 0; i < total; i++) {
            valMatrix[i][0] = 0;
        }
        for (int i = 0; i <= wt; i++) {
            if(i >= weight[0]){
                valMatrix[0][i] = val[0];
            }
        }

        for (int i = 1; i < total; i++) {
            for (int j = 1; j <= wt; j++) {

                if(j<weight[i]){
                    valMatrix[i][j] = valMatrix[i-1][j];
                } else {
                    valMatrix[i][j] = Math.max(val[i]+valMatrix[i-1][(j-weight[i])],valMatrix[i-1][j]);
                }
            }
        }
      //  System.out.println(valMatrix[val.length-1][wt]);
        printMatrix(valMatrix);
    }

    static void printMatrix(int mat[][]){
        for (int i = 0; i < val.length; i++) {
            for (int j = 0; j < mat[i].length ; j++) {
                System.out.print(mat[i][j]);
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        val = new int[]{1,4,5,7};
        weight = new int[]{1,3,4,5};
        for (int i = 0; i < val.length; i++) {
            hash.put(weight[i],val[i]);
        }
        maxValueWithFixedWeight(val.length,7);
        System.out.println(recursionKnapSack(val.length,7,0,0,val,weight));
    }

    static int recursionKnapSack(int i,int W,int tempWeight,int val,int value[],int weight[]){


        if(i==0 || W == 0){
            return 0;
        }

        if(weight[i-1] > W){
            return recursionKnapSack(i-1,W,tempWeight,val,value,weight);
        }

        return Math.max(value[i-1]+recursionKnapSack(i-1,W-weight[i-1],tempWeight,val,value,weight),
        recursionKnapSack(i-1,W,tempWeight,val,value,weight));
    }


}
