package Strings;

/**
 * Created by harshikesh.kumar on 21/06/16.
 */
public class ReverseEachWord {

    static char str[];

    public static void main(String[] args) {
        String str1 = "Hello I am a Boy .";
        str = str1.toCharArray();
        reverseEachWord();
        System.out.println(reverse(str1));
    }

    static String s = "";

    private static void reverseEachWord() {

        int j = 0;
        for (int i = 0; i < str.length; i++) {

            if (str[i] == ' ') {
                System.out.print(i - j + " " + (i - 1) + "\n");
                reverse(i - j, i - 1);
                j = -1;
            }
            j++;
        }
        System.out.println(new String(str));
    }

    public static String reverse(String word) {

        if ((word == null) || (word.length() <= 1)) {
            return word;
        }
        return reverse(word.substring(1)) + word.charAt(0);
    }

    private static void reverse(int j, int len) {

        int p = j;
        int q = len;
        for (int i = j; i <= p + (len - p) / 2; i++, q--) {
            char temp = str[q];
            str[q] = str[i];
            str[i] = temp;
        }
    }
}
