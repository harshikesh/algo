package hackerearth;

/**
 IMPORTANT: Multiple classes and nested static classes are supported */

/*
 * uncomment this if you want to read input.
//imports for BufferedReader*/
        import java.io.BufferedReader;
        import java.io.InputStreamReader;

//import for Scanner and other utility  classes
        import java.util.*;


class AmazonFlex {
    public static void main(String args[] ) throws Exception {
        /*
         * Read input from stdin and provide input before running
         * Use either of these methods for input
*/

        //Scanner
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        for (int i = 0; i < N; i++) {
            int num = s.nextInt();
            String ans = "IMPOSSIBLE";
            int arr[] = new int[num];
            int sum =0;
            for (int j = 0; j < num; j++) {
                arr[j] = s.nextInt();

            }
            int max =0;
            for (int j = 0; j <num-1; j++) {
                sum += getDecimal(addBinaryDigit(Integer.toBinaryString(arr[j]),Integer.toBinaryString(arr[j+1])));
               max = max > sum ? max:sum;
            }
            sum = max;
            System.out.println(sum);
            if(sum%2 == 0){

                System.out.println(findPartiion(arr,num,sum));
            }

            System.out.println("Case #"+(i+1)+": "+ans);
        }

    }

    static boolean findPartiion(int arr[], int n,int sum)
    {
        int i, j;

        if (sum%2 != 0)
            return false;

        boolean part[][] = new boolean[sum/2+1][n+1];

        for (i = 0; i <= n; i++)
            part[0][i] = true;

        for (i = 1; i <= sum/2; i++)
            part[i][0] = false;

        for (i = 1; i <= sum/2; i++)
        {
            for (j = 1; j <= n; j++)
            {
                part[i][j] = part[i][j-1];
                if (i >= arr[j-1])
                    part[i][j] = part[i][j] || part[getDecimal(flip(addBinaryDigit(Integer.toBinaryString(i) , Integer.toBinaryString(-arr[j-1]))))][j-1];
            }
        }
        return part[sum/2][n];
    }

    private static String flip(String s) {
        String  temp ="";
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1'){
                temp += '0';
            } else {
                temp += '1';
            }
        }
        return temp;
    }

    static String addBinaryDigit(String num1,String num2){
        int length;
        String temp = "";
        if(num1.length()<num2.length()){
            length = num1.length();
            temp = num2.substring(0,num2.length()-num1.length());
            num2= num2.substring(num2.length()-num1.length());
        }else {
            length = num2.length();
            temp = num1.substring(0,num1.length()-num2.length());
            num1 = num1.substring(num1.length()-num2.length());
        }


        for(int i=0;i<length;i++){
            if(num1.charAt(i) == '1' || num2.charAt(i) =='1'){
                if(num1.charAt(i) == '1' && num2.charAt(i) =='1')
                temp = temp + "0";
                else {
                    temp = temp + "1";
                }
            } else {
                temp = temp + "0";
            }

        }
        return temp;
    }

    static int getDecimal(String bin){
        return Integer.parseInt(bin,2);
    }

}
