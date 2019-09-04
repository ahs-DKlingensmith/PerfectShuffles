/*
 * PerfectShuffle class
 */

public class PerfectShuffle {

    //Establish attributes
    private int[] deck;

    //The PerfectShuffle constructor accepts an integer array as the deck's
    //values and copies the contents of the deck
    public PerfectShuffle(int input) {

        deck = new int[input];

        for (int x = 0; x < input; x++) {
            deck[x] = x;
        }

    }

    //The inShuffle method accepts an integer array as the deck, splits the 
    //deck into two, and, starting with the bottom half, removes the bottom
    //"card" from each deck and moves it to the top
    public int[] inShuffle(int[] input) {

        int[] topDeck = new int[input.length / 2];
        int[] bottomDeck = new int[input.length / 2];

        for (int x = 0; x < input.length / 2; x++) {

            topDeck[x] = input[x];
            bottomDeck[x] = input[x + (input.length / 2)];

        }

        boolean useTopDeck = false;
        int trackTopDeck = 0;
        int trackBottomDeck = 0;

        int[] shuffledDeck = new int[input.length];

        for (int x = 0; x < input.length; x++) {

            if (useTopDeck) {

                shuffledDeck[x] = topDeck[trackTopDeck];
                useTopDeck = false;
                trackTopDeck++;

            } else if (!useTopDeck) {

                shuffledDeck[x] = bottomDeck[trackBottomDeck];
                useTopDeck = true;
                trackBottomDeck++;

            }

        }

        return shuffledDeck;

    }

    //The outShuffle method accepts an integer array as the deck, splits the 
    //deck into two, and starting with the top half, removes the bottom
    //"card" from each deck and moves it to the top
    public int[] outShuffle(int[] input) {

        int[] topDeck = new int[input.length / 2];
        int[] bottomDeck = new int[input.length / 2];

        for (int x = 0; x < input.length / 2; x++) {

            topDeck[x] = input[x];
            bottomDeck[x] = input[x + (input.length / 2)];

        }

        boolean useTopDeck = true;
        int trackTopDeck = 0;
        int trackBottomDeck = 0;

        int[] shuffledDeck = new int[input.length];

        for (int x = 0; x < input.length; x++) {

            if (useTopDeck) {

                shuffledDeck[x] = topDeck[trackTopDeck];
                useTopDeck = false;
                trackTopDeck++;

            } else if (!useTopDeck) {

                shuffledDeck[x] = bottomDeck[trackBottomDeck];
                useTopDeck = true;
                trackBottomDeck++;

            }

        }

        return shuffledDeck;

    }

    public int perfectInShuffle() {

        int[] matchDeck = new int[deck.length];

        for (int x = 0; x < matchDeck.length; x++) {

            matchDeck[x] = deck[x];

        }

        boolean perfectlyShuffled = false;

        int[] shuffledDeck = this.inShuffle(deck);
        int numberOfShuffles = 1;

        while (!perfectlyShuffled) {

            int checkDeck = 0;
            shuffledDeck = this.inShuffle(shuffledDeck);

            for (int x = 0; x < deck.length; x++) {

                if (shuffledDeck[x] == matchDeck[x]) {
                    checkDeck++;
                }

            }

            if (checkDeck == deck.length) {
                perfectlyShuffled = true;
            }

            numberOfShuffles++;

        }

        return numberOfShuffles;

    }

    public int perfectOutShuffle() {

        int[] matchDeck = new int[deck.length];

        for (int x = 0; x < matchDeck.length; x++) {

            matchDeck[x] = deck[x];

        }

        boolean perfectlyShuffled = false;

        int[] shuffledDeck = this.outShuffle(deck);
        int numberOfShuffles = 1;

        while (!perfectlyShuffled) {

            int checkDeck = 0;
            shuffledDeck = this.outShuffle(shuffledDeck);

            for (int x = 0; x < deck.length; x++) {

                if (shuffledDeck[x] == matchDeck[x]) {
                    checkDeck++;
                }

            }

            if (checkDeck == deck.length) {
                perfectlyShuffled = true;
            }

            numberOfShuffles++;

        }

        return numberOfShuffles;

    }

    public int[] moveTopCard(int pos) {

        String binaryString = Integer.toBinaryString(pos);
        int[] newDeck = new int[deck.length];

        for (int x = 0; x < newDeck.length; x++) {
            newDeck[x] = deck[x];
        }

        for (int x = 0; x < binaryString.length(); x++) {

            if (binaryString.charAt(x) == '1') {

                newDeck = this.inShuffle(newDeck);

            } else if (binaryString.charAt(x) == '0') {

                newDeck = this.outShuffle(newDeck);

            }
        }
        
        return newDeck;

    }

}
