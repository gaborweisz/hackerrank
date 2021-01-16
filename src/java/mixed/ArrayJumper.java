package java.mixed;
import java.util.*;

/**
 * Created by gabor on 2019.04.30..
 */
public class ArrayJumper {


    public static boolean solvable(int idx, int leap, int[] game) {
        int n = game.length;
        if (idx < 0 || game[idx] == 1) return false;
        if (idx == n-1 || idx + leap >= n) return true;

        boolean res =  leap > 0 ? solvable(idx + 1, leap, game) ||  solvable(idx + leap, leap, game) : solvable(idx + 1, leap, game);

        if (!res) {
            if (idx > 0 && game[idx-1] == 2) return false; //hopeless;
            if (idx > 0 && game[idx-1] == 0) game[idx-1] = 2; //flag it to show that we have already been here
            return solvable(idx - 1, leap, game);
        } else return true;

    }

    public static boolean canWin(int leap, int[] game) {
        if (leap >= game.length) return true;
        return solvable(0, leap,  game);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int q = scan.nextInt();
        while (q-- > 0) {
            int n = scan.nextInt();
            int leap = scan.nextInt();

            int[] game = new int[n];
            for (int i = 0; i < n; i++) {
                game[i] = scan.nextInt();
            }

            System.out.println( (canWin(leap, game)) ? "YES" : "NO" );
        }
        scan.close();
    }
}
