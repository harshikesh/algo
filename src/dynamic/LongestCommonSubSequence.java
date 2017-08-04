package dynamic;

/**
 * Created by harshikesh.kumar on 02/06/16.
 */
public class LongestCommonSubSequence {

    //Recursion

    static String getLongest2(String s1 ,String s2){

        if(s1 ==null || s2 == null || s1.length()==0 || s2.length()==0){
            return "";
        }

        if( s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
            return  getLongest2(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1))+s1.charAt(s1.length()-1) ;
        } else {
            String s = getLongest2(s1.substring(0, s1.length() - 1), s2);
            String t = getLongest2(s1,s2.substring(0,s2.length()-1));
            return s.length()>t.length()?s:t;
        }
    }

    static int getLongest(String s1 ,String s2){

        if(s1 ==null || s2 == null || s1.length()==0 || s2.length()==0){
            return 0;
        }

       if( s1.charAt(s1.length()-1) == s2.charAt(s2.length()-1)){
           return 1 + getLongest(s1.substring(0,s1.length()-1),s2.substring(0,s2.length()-1));
       }

        return  max(getLongest(s1.substring(0,s1.length()-1),s2),getLongest(s1,s2.substring(0,s2.length()-1)));
    }

    static int dynamicApproach(char[] c1, char[] c2, int N, int M){

        int mat[][] = new int[N+1][M+1];
        for(int i=0;i<=N;i++){
            for (int j = 0; j <=M; j++) {

                if(i==0 || j==0){
                    mat[i][j]=0;
                    continue;
                }

                if(c1[i-1] ==c2[j-1]) {
                    mat[i][j] = mat[i-1][j-1] + 1;
                } else {
                    mat[i][j] = max(mat[i-1][j],mat[i][j-1]);
                }
            }
        }
        for(int i=0;i<=N;i++){
            for (int j = 0; j <=M; j++) {
                System.out.print(mat[i][j]+" ");

            }
            System.out.println();
        }

                return mat[N][M];
    }

    private static int max(int substring, int substring1) {
        return substring>substring1?substring:substring1;
    }

    public static void main(String[] args) {
        String str = "ABCDEFGH";
        String str1 = "KBDGHI";
//            System.out.println(str.charAt(str.length()-1));
            System.out.println(getLongest(str,str1));
            System.out.println(getLongest2(str,str1));
            System.out.println(dynamicApproach(str.toCharArray(),str1.toCharArray(),str.length(),str1.length()));
    }

}
