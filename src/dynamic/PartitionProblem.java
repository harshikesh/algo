package dynamic;

/**
 * Created by harshikesh.kumar on 07/05/17.
 */
public class PartitionProblem {

    public static void main(String[] args) {

        int arr[] = {1,3,3,4,6};

        int sum =0;
        for (int i = 0; i < arr.length; i++) {
            sum+= arr[i];
        }

        System.out.println(findPartition(arr,arr.length,0,sum));

    }

    private static int findPartition(int[] arr,int i,int tempSum,int sum) {


        if(i==0){
            return Math.abs((sum-tempSum)-tempSum);
        }

        return Math.min(findPartition(arr,i-1,tempSum+arr[i-1],sum),
        findPartition(arr,i-1,tempSum,sum));


    }
}
