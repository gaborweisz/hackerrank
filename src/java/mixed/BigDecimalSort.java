package java.mixed;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by gabor on 2019.04.29..
 */
public class BigDecimalSort {
    public static void main(String []args){
        //Input
        Scanner sc= new Scanner(System.in);
        int n=sc.nextInt();
        String []s=new String[n+2];
        for(int i=0;i<n;i++){
            s[i]=sc.next();
        }
        sc.close();

       Arrays.sort(s, new Comparator<String>() {
           @Override
           public int compare(String o1, String o2) {

               if (o1 == null && o2 == null) return 0;
               if (o1 == null) return 1;
               if (o2 == null) return -1;

               BigDecimal bd1 = new BigDecimal(o1);
               BigDecimal bd2 = new BigDecimal(o2);

               return bd1.compareTo(bd2);
           }
       });

        //Output
        for(int i=0;i<n;i++)
        {
            System.out.println(s[i]);
        }
    }

    class Checker implements Comparator<Integer> {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o1.compareTo(o2);
        }

    }



}
