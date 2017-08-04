package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 02/07/16.
 */
public class dynamiccoin {

    static long fact(long n){
        long total=1;
        for (int i = 1; i <= n; i++) {
            total *=i;
        }
        return total;
    }
    static long getValue( int arr[], int m, int n )
    {
        long  a,b;
        long[][] mat= new long[n+1][m];
        int l=1;
        for (int i=0; i<m; i++)
                {
               if(i>0 && arr[i] == arr[i-1]) {
                   mat[0][i] = mat[0][i-1];
                   l++;
               } else {

                       mat[0][i] = l;

               }
        }
        for (int i = 1; i < n+1; i++)
        {
            long p =1;
            for (int j = 0; j < m; j++)
            {
                if(j>0 && arr[j] == arr[j-1]){
                    mat[i][j] =  mat[i][j-1] ;
                    p++;
                    continue;
                }
                a = (i-arr[j] >= 0)? mat[i - arr[j]][j]: 0;
                if(p>1){
                    b = fact(p);
                    p=1;
                } else {
                    b = (j >= 1) ? mat[i][j - 1] : 0;
                }
                System.out.print(a+" "+b);
                mat[i][j] = (long)(a + b);
            }
            System.out.println();
        }
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }

        return mat[n][m-1]%(100000007);
    }
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        long cou=0;
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int a = sc.nextInt();
        //int b = sc.nextInt();
        for(int i=a;i<=a;i++){
            cou += getValue(arr,n,i);
            System.out.println(cou);
            cou = cou % (100000007);
        }
        System.out.println("ans : "+cou);
    }
}