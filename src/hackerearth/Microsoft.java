package hackerearth;

/**
 * Created by harshikesh.kumar on 20/05/17.
 */
public class Microsoft {

    public static void main(String[] args) {
        int k = 2;
        char c = 'b';
        for (int i = 0; i < 27; i++) {

            System.out.println(((char)(((c-'a'+i+26)%26)+97)));
        }
    }
}
