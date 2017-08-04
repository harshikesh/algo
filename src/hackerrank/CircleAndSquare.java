package hackerrank;

import java.util.Scanner;

/**
 * Created by harshikesh.kumar on 22/02/17.
 */
public class CircleAndSquare {
    static  double square =0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int w = in.nextInt();
        int h = in.nextInt();
        double circleX = in.nextInt() * 1.0;
        double circleY = in.nextInt() * 1.0;
        double radius = in.nextInt() * 1.0;
        double x1 = in.nextInt();
        double y1 = in.nextInt();
        double x2 = in.nextInt();
        double y2 = in.nextInt();
//        20 16
//        9 6 5
//        16 14 8 14

        double diaognal = Math.sqrt((y2-y1)*(y2-y1) + (x2-x1)*(x2-x1));
        square = (diaognal * diaognal)/(double)2;

        double xc = (x1 + x2)/2  ; double yc = (y1 + y2)/2  ;
        double xd = (x1 - x2)/2  ; double yd = (y1 - y2)/2  ;

        double x3 = xc - yd  ;  double y3 = yc + xd;
        double x4 = xc + yd  ;  double y4 = yc - xd;

        boolean mat[][]= new boolean[h][w];

        for (int i = 0; i < h; i++) {
            double y = i*1.0 ;
            for (int j = 0; j < w; j++) {
                double x = j*1.0 ;
                mat[i][j] = isInsideCircle(x,y,radius,circleX,circleY);
                if(!mat[i][j]) {
                    mat[i][j] = isInsideRectanglev2(x, y, x1, y1, x2, y2, x3, y3, x4, y4);
                }
            }
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                System.out.print(mat[i][j]?"#":".");
            }
            System.out.println();
        }


    }

    private static boolean isInsideRectanglev2(double x, double y, double x1, double y1, double x2, double y2, double x3, double y3, double x4, double y4) {

        double sum = triangleArea(x1,y1,x3,y3,x,y) + triangleArea(x2,y2,x3,y3,x,y) +  triangleArea(x2,y2,x4,y4,x,y) + triangleArea(x4,y4,x1,y1,x,y);
//       if(sum == 32.0)
//        System.out.println(sum + "  sq "+ square);
        if (sum - square <= 10e-7) {
            return true;
        }
        return false;
    }


    private static double triangleArea(double x1, double y1, double x2, double y2, double x3, double y3) {
        return Math.abs((x1*(y2-y3) + x2*(y3-y1)+ x3*(y1-y2))/(double)2);
    }

    static boolean isInsideCircle(double x,double y, double radius, double circleX,double circleY){

        if((((x-circleX)*(x-circleX)) + ((y-circleY)*(y-circleY))) - radius*radius <= 10e-7 ){
            return true;
        }
        return false;
    }

}
