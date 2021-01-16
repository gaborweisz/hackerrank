package java.mixed;

import java.util.*;
/**
 * Created by gabor on 2019.04.13..
 */
public class LineReader {



        public static void main(String[] args) {
            Scanner sc=new Scanner(System.in);

            System.out.println("");
            int line = 0;
            while (sc.hasNext()) {
                System.out.println(++line + " " + sc.nextLine());
            }
        }

}
