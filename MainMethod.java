/**
 * Dylan Klingensmith
 * Perfect Shuffles
 * AP Computer Science 
 * 8/28/19
 */

public class MainMethod {

    public static void main(String[] args) {
        
        PerfectShuffle newDeck = new PerfectShuffle(8);
        int numberOfShuffles = newDeck.perfectOutShuffle();
        System.out.println(numberOfShuffles);
        
        
    }

}
