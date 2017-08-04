package dynamic;

/**
 * Created by harshikesh.kumar on 03/06/16.
 */
public class LongestSequence {

//N square

    static void longestSeq(int arr[],int len){
        int lis[] = new int[arr.length];

        for (int i = 1; i <len ; i++) {
            for (int j = 0; j < i; j++) {
                if(arr[i] > arr[j] && lis[i] < lis[j]+1){
                    lis[i] = lis[j]+1;
                }
            }
        }

        for (int i = 0; i <len ; i++) {
            System.out.print(lis[i]+" ");
        }
        System.out.println();
    }

    //N log n

    static void longestSeqNlogN (int arr[],int len){
        int lis[] = new int[arr.length];
        int l =1;
        lis[0] = arr[0];
        for (int i = 1; i <len ; i++) {

            int k =arr[i];

            if (lis[0] > k){
                lis[0] = k;
            } else if (lis[l-1] < k){
                lis[l++] = k;
            } else {
                lis[ceilM(lis,0,l-1,k)] = k;
            }
        }
        for (int i = 0; i <len ; i++) {
            System.out.print(lis[i]+" ");
        }
        System.out.println();
        System.out.println(l);
    }

    private static int ceilM(int[] arr, int i, int r, int k) {
        while (r - i > 1) {
            int mid = (i + (r))/2;
            if(arr[mid]>k) {
                r = mid;
            } else {
                i = mid;
            }
            System.out.println(" "+i+" "+mid+" "+r );
        }
        System.out.println(r);
        return r;
    }


    public static void main(String[] args) {
        int arr[] =  {4,6,7,3,28,2,67,42,31,32,33};
        int len = arr.length;
        //longestSeq(arr,len);
        longestSeqNlogN(arr,len);
    }
}
