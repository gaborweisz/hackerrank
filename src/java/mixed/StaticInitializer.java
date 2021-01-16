package java.mixed;

import java.util.*;

/**
 * Created by gabor on 2019.04.13..
 */
public class StaticInitializer {

    static int H;
    static int B;
    static  boolean flag = false;
    static  Scanner sc = new Scanner(System.in);;

    static {
        H = sc.nextInt();
        B = sc.nextInt();

        if (H <= 0 || B <= 0) System.out.print("java.lang.Exception: Breadth and height must be positive");
        else flag = true;
    }

    public static void main(String[] args){
        if(flag){
            int area=B*H;
            System.out.print(area);
        }

    }//end of main

}//end of class
