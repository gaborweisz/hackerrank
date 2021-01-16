package java.mixed;

import java.util.*;

/**
 * Created by gabor on 2019.04.13..
 */
class Series{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();

            System.out.println(calcSeries(a,b,n));
        }
        in.close();
    }

    private static String calcSeries(int a, int b, int n){

        String series = "";
        for (int j=1; j<=n; j++){

            series += calcElement(a,b,j) + " ";
        }

        return series;

    }

    private static int calcElement(int a, int b, int n){
        int pow2 = 1;
        int element = a;
        for (int i = 0; i <n; i++){
            element += pow2 * b;
            pow2 *= 2;
        }
        return  element;
    }
}