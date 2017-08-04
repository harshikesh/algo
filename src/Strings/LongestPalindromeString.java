package Strings;

/**
 * Created by harshikesh.kumar on 13/07/16.
 */
public class LongestPalindromeString {


    static int longestPalin(String str)
    {
        int n = str.length();
        int i, j, index;
        int mat[][] = new int[n][n];

        for (i = 0; i < n; i++)
            mat[i][i] = 1;

        for (index=2; index<=n; index++)
        {
            for (i=0; i<n-index+1; i++)
            {
                j = i+index-1;
                if (str.charAt(i) == str.charAt(j) && index == 2)
                    mat[i][j] = 2;
                else if (str.charAt(i) == str.charAt(j))
                    mat[i][j] = mat[i+1][j-1] + 2;
                else
                    mat[i][j] = Integer.max(mat[i][j-1], mat[i+1][j]);
            }
        }

        return mat[0][n-1];
    }

}
