package hackerrank;

/**
 * Created by harshikesh.kumar on 27/03/17.
 */

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class NSE {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] p = new int[n];
        for (int p_i = 0; p_i < n; p_i++) {
            p[p_i] = in.nextInt();
        }
        int stmav = 1;
        int ltmav = 4;
        int stma_sum = 0;
        float dec_avg = 0;
        //int ltma_sum=0;
        float[] stma = new float[n - ltmav];
        float[] ltma = new float[n - ltmav];
        //stma array calculation
        for (int i = ltmav; i < n; i++) {
            for (int j = i - stmav; j <= i; j++) {
                stma_sum = stma_sum + p[j];
            }
            dec_avg = (float) stma_sum / (stmav + 1);
            dec_avg = dec_avg * 100;
            dec_avg = Math.round(dec_avg);
            dec_avg = dec_avg / 100;
            stma[i - ltmav] = dec_avg;
            stma_sum = 0;
        }
        //ltma array calculation
        for (int i = ltmav; i < n; i++) {
            for (int j = i - ltmav; j <= i; j++) {
                stma_sum = stma_sum + p[j];
            }
            dec_avg = (float) stma_sum / (ltmav + 1);
            dec_avg = dec_avg * 100;
            dec_avg = Math.round(dec_avg);
            dec_avg = dec_avg / 100;
            ltma[i - ltmav] = dec_avg;
            stma_sum = 0;
        }

        for (int i = 1; i < n - ltmav; i++) {
            if (stma[i - 1] > ltma[i - 1] && stma[i] <= ltma[i]) {
                System.out.println(i + ltmav + 1 + " " + stma[i] + " " + ltma[i]);
            } else if (stma[i - 1] < ltma[i - 1] && stma[i] >= ltma[i]) {
                System.out.println(i + ltmav + 1 + " " + stma[i] + " " + ltma[i]);
            } else if (stma[i - 1] == ltma[i - 1] && stma[i] != ltma[i]) {
                System.out.println(i + ltmav + 1 + " " + stma[i] + " " + ltma[i]);
            }
        }
    }
}
