/**
 * Created by harshikesh.kumar on 21/01/17.
 */
public class PowerFun {

    private int internalNum=-1;


    public static void main(String[] args) {
        int[] values = {1,100,2,4,5};
        int k = 3;
        int[] sumValue = new int[k+1];
        int maxProduct = 0;
        int maxProductKValue=-1;
        for(int i=0;i<=k;i++)
        {
            int prodValue =values[i]*values[values.length-k-1];
            if(prodValue>maxProduct)
            {
                maxProduct = prodValue;

            }
        }
        System.out.println(maxProduct);

    }


}
