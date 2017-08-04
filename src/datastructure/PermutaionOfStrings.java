package datastructure;

/**
 * Created by harshikesh.kumar on 06/03/17.
 */
public class PermutaionOfStrings {

    static int count =1;
    public static void main(String[] args) {
        String s = "abc";
        generatePerm("",s);
    }

    private static void generatePerm(String pre ,String s) {

        System.out.println(pre+"");
        if(s.length() == 0){
           // System.out.println(pre+""+ count++);
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            generatePerm(pre+s.charAt(i),s.substring(0,i)+s.substring(i+1));
        }
    }
}
