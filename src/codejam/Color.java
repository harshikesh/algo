//package codejam;
//
//import java.util.Scanner;
//import java.util.Stack;
//
///**
// * Created by harshikesh.kumar on 22/04/17.
// */
//public class Color {
//
//    static final String anstoken = "Case #";
//    static final String anstoken2 = ": ";
//
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int test = sc.nextInt();
//
//        String[] color = {"R" , "O" , "Y" , "G" , "B" , "V"};
//        for (int i = 1; i <= test; i++) {
//            int N = sc.nextInt();
//            int arr[] = new int[6];
//            arr[0] = sc.nextInt();
//            arr[1]= sc.nextInt();
//            arr[2] = sc.nextInt();
//            arr[3] = sc.nextInt();
//            arr[4] = sc.nextInt();
//            arr[5] = sc.nextInt();
//            boolean flag = true;
//            String ans ="";
//            while (flag){
//                flag = false;
//                for (int j = 0; j < 6; j++) {
//                    if(arr[j]>0){
//                        flag  = true;
//                        ans += color[j];
//                        if(j>-1 && j<2){
//                            j = 3;
//                        } else if(j==2) {
//                            j = 3;
//                        } else{
//                            j
//                        }
//                    }
//                }
//            }
//            System.out.println(anstoken+i+anstoken2+ans);
//        }
//    }
//}
