package backend.blackjack;

/**
 * This class rapper-sent a logic of the game
 */
public class Logic {
    private final boolean[][] usedCards;

    /**
     * This constructor initializes a logic
     */
    public Logic() {
        usedCards = new boolean[4][13];

        reset();
    }

    /**
     * This method reset logic data of used card
     */
    public void reset() {
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                usedCards[i][j] = false;
            }
        }
    }

    /**
     * This method returns a card
     *
     * @return return card
     */
    public Card getCard() {
        Card card = new Card();
        int suit = card.getSuit();
        int number = card.getNumber();

        while (usedCards[suit - 1][number - 1]) {
            card = new Card();
            suit = card.getSuit();
            number = card.getNumber();
        }

        usedCards[suit - 1][number - 1] = true;

        return card;
    }

    /**
     * This returned used card
     *
     * @return array of used card of boolean
     */
    public boolean[][] getUsedCards() {
        return usedCards;
    }
}