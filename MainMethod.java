/**
 * Dylan Klingensmith
 * Perfect Shuffles
 * AP Computer Science
 * 8/28/19
 */

import java.util.*;

public class MainMethod {

    public static void main(String[] args) {
        
        PerfectShuffle s = new PerfectShuffle(52);
        System.out.println(s.perfectInShuffle());
        System.out.println(s.perfectOutShuffle());
        System.out.println(Arrays.toString(s.moveTopCard(14)));
        System.out.println(Arrays.toString(s.moveTopCard(4)));

    }

}




