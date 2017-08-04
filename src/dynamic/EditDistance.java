package dynamic;

/**
 * Created by harshikesh.kumar on 02/06/16.
 */
public class EditDistance {


    static int editDist(char c1[],char c2[],int N,int M){

        if(M==0){
            System.out.println(" N "+ N);
            return  N;
        }
        if(N ==0){
            System.out.println(" M " + M);
            return  M;
        }

        if(c1[N-1] == c2[M-1]){
            return editDist(c1,c2,N-1,M-1);
        }

        return  1 + Math.min(Math.min(editDist(c1,c2,N-1,M),editDist(c1,c2,N,M-1)),editDist(c1,c2,N-1,M-1));

    }

    static int dynamicEditDist(char c1[],char c2[],int m,int n){

        // Create a table to store results of subproblems
        int dp [][] = new int [m+1][n+1];

        // Fill d[][] in bottom up manner
        for (int i=0; i<=m; i++)
        {
            for (int j=0; j<=n; j++)
            {
                // If first string is empty, only option is to
                // isnert all characters of second string
                if (i==0)
                    dp[i][j] = j;  // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j==0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (c1[i-1] == c2[j-1])
                    dp[i][j] = dp[i-1][j-1];

                    // If last character are different, consider all
                    // possibilities and find minimum
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j-1],  // Insert
                            dp[i-1][j]),  // Remove
                            dp[i-1][j-1]); // Replace
            }
        }
        for(int i=0;i<=m;i++){
            for (int j = 0; j <=n; j++) {
                System.out.print(dp[i][j]+" ");

            }
            System.out.println();
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        String str = "dog";
        String str1 = "dg";

        System.out.println(dynamicEditDist(str.toCharArray(),str1.toCharArray(),str.length(),str1.length()));
    }
}
