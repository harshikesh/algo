package hackerrank;

/**
 * Created by harshikesh.kumar on 08/07/17.
 */
public class RotateArray {


    public static void main(String[] args) {
        int a[] = {1,2,4,3,5};int rotate[] = {6,9,12};
        int res[] =getMaxElementIndices(a,rotate);
        for (int i = 0; i <res.length; i++) {
            System.out.println(res[i]);
        }
    }

    static int[] getMaxElementIndices(int a[] ,int rotate[]){

        long max = 0;
        int maxInd = 0;
        int size =a.length;
        for (int i = 0; i < a.length; i++) {
            if(max <a[i] ){
                max  = a[i];
                maxInd = i;
            }
        }
        int res [] =new int[rotate.length];
        for (int i = 0; i < rotate.length; i++) {
            rotate[i] = rotate[i] % size;
            res[i] = (maxInd - rotate[i] + size) % size;
        }
        return res;
    }
}
