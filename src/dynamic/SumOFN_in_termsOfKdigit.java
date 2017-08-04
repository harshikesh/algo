package dynamic;

/**
 * Created by harshikesh.kumar on 04/06/16.
 */
public class SumOFN_in_termsOfKdigit {



    /* Divide S in K parts 0 may be present */
    public static long PartionwithZero(int S, int K) {
        long DP_Table[][] = new long[K][];
        for (int i = 0; i < K; i++)
            DP_Table[i] = new long[S + 1];
        for (int i = 0; i < S + 1; i++)
            DP_Table[0][i] = 1;
        for (int i = 0; i < K; i++)
            DP_Table[i][0] = 1;

        for (int i = 1; i < K; i++) {
            for (int j = 1; j < S + 1; j++)
                DP_Table[i][j] = DP_Table[i - 1][j] + DP_Table[i][j - 1];
        }


      for(int i=0;i<K;i++) { for(int j=0;j<S+1;j++)
      System.out.print(DP_Table[i][j]+" "); System.out.println(); }
        return DP_Table[K - 1][S];
    }

    public static void main(String[] args) {
        System.out.print(PartionwithZero(6,6));
    }
}
