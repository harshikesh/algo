package dynamic;

/**
 * Created by harshikesh.kumar on 11/05/17.
 */
public class PermutationString {

    public static void main(String[] args) {

        getPermutation("","ABC");
    }

    public static void getPermutation(String str, String perm) {

        if(perm.length()==0){
            System.out.println(str);
            return ;
        }

        for (int i = 0; i < perm.length(); i++) {
            getPermutation(str+perm.charAt(i),perm.substring(0,i)+perm.substring(i+1));
        }
    }
}
