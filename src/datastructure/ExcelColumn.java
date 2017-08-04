package datastructure;

/**
 * Created by harshikesh.kumar on 15/06/16.
 */
public class ExcelColumn {


    static int alphaToDecimal(char input[]){
        int ret = 0;
        int a, b=1;
        int i, j;
        for (i=input.length-1; i>=0; i--) {
            a = input[i] - 'A' + 1;
            ret =ret +(a*b);
            b *= 'Z'-'A' + 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        char arr[] =  {'D','A'};
       // System.out.println('Z'-'A');
        System.out.print(alphaToDecimal(arr));
    }
}
