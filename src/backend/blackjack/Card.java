package backend.blackjack;
public class Card {
    private int value;
    private int number;
    private int suit;

    public Card(){
        number = (int) (Math.random() * 13);
        suit = (int) (Math.random() * 4);

        if (number > 10){
            value = 10;
        } else {
            value = number;
        }
    }

    public int getValue(){
        return value;
    }

    public int getNumber(){
        return number;
    }

    public int getSuit(){
        return suit;
    }
}
