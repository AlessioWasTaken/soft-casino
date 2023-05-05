package backend.blackjack;
public class Logic {
    private boolean [][] usedCards;

    public Logic(){
        usedCards = new boolean[4][13];

        reset();
    }

    public void reset(){
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++){
                usedCards[i][j] = false;
            }
        }
    }

    //ciao

    public Card getCard(){
        Card card = new Card();
        int suit = card.getSuit();
        int number = card.getNumber();

        while (usedCards[suit-1][number-1]){
            card = new Card();
            suit = card.getSuit();
            number = card.getNumber();
        }

        usedCards[suit-1][number-1] = true;

        return card;
    }

    public boolean[][] getUsedCards(){
        return usedCards;
    }
}