package backend.blackjack;
import java.util.ArrayList;

/**
 * This class represents a table of game with abstract action then send an instruction what used to gui
 */
public class Table {
    private final ArrayList<Card> player;
    private final ArrayList<Card> dealer;
    private final Logic logic;
    private boolean playerTurn;
    private boolean dealerTurn;
    private int bet;

    /**
     * This constructor grate card and set turn and bet
     * @param puntata passing a bet
     */
    public Table(int puntata){
        player = new ArrayList<>();
        dealer = new ArrayList<>();
        logic = new Logic();
        this.bet = puntata;
        playerTurn = true;
        dealerTurn = false;
    }

    /**
     * This method returns a bet of user
     * @return int of a bet
     */
    public int getbet(){
        return bet;
    }

    /**
     * This method adds card 2 for dealer and user
     */
    public void deal(){
        player.add(logic.getCard());
        dealer.add(logic.getCard());
        player.add(logic.getCard());
        dealer.add(logic.getCard());
    }

    /**
     * This method represents a hit of player
     * @return int if user win
     */
    public int hitPlayer(){
        player.add(logic.getCard());

        if(getPlayerValue() > 21){
            playerTurn = false;
            dealerTurn = false;
        }

        return win();
    }

    /**
     * This method represents a double action of user
     * @return int if user win
     */
    public int Double(){
        bet *= 2;
        player.add(logic.getCard());

        return win();
    }

    /**
     * This method represents stand action of user
     */
    public void stand(){
        playerTurn = false;
        dealerTurn = true;

        win();
    }

    /**
     * This method represents a hit action fo dealer
     */
    public void hitDealer(){
        if(getDealerValue() < 17){
            dealer.add(logic.getCard());
        }
        else{
            dealerTurn = false;
        }

        win();
    }

    /**
     * This method gets a value of game of player
     * @return int of value
     */
    public int getPlayerValue(){
        int value = 0;

        for(Card card : player){

            if(card.getNumber() == 1){
                if(value + 11 > 21){
                    value += 1;
                } else {
                    value += 11;
                }
            }
            else{
                value += card.getValue();
            }
        }

        return value;
    }

    /**
     * This method gets a value of game of dealer
     * @return int of value
     */
    public int getDealerValue(){
        int value = 0;

        for(Card card : dealer){
            value += card.getValue();
        }

        return value;
    }


    /**
     * This method checks a situation for determined a winner
     * @return int value to appeasement situation
     */
    public int check(){
        if(getPlayerValue() == 21 && getDealerValue() == 21){
            return 0;
        }
        if(getPlayerValue() == 21){
            return 1;
        }
        if(getDealerValue() == 21){
            return 2;
        }
        if(getPlayerValue() > 21){
            return 2;
        }
        if(getDealerValue() > 21){
            return 1;
        }
        if(!playerTurn && !dealerTurn && getPlayerValue() > getDealerValue()){
            return 1;
        }
        if(!playerTurn && !dealerTurn && getPlayerValue() < getDealerValue()){
            return 2;
        }
        if(!playerTurn && !dealerTurn && getPlayerValue() == getDealerValue()){
            return 3;
        }

        return -1;
    }

    /**
     * This method used to calculate a win
     * @return int of value of reward
     */
    public int win(){
        if(check() == 0){
            return bet;
        }
        if(check() == 1){
            return bet;
        }
        if(check() == 2){
            return bet * -1;
        }
        if(check() == 3){
            return 0;
        }

        return 69420;
    }

    /**
     * This set turn for dealer
     * @param A true or false
     */
    public void setDealerTurn(boolean A){
        dealerTurn=A;
    }

    /**
     * This method returns an array list of card for dealer
     * @return ArrayList of card dealer
     */
    public ArrayList<Card> getDealerCard(){
        return this.dealer;
    }

    /**
     * This method returns an array list of card for player
     * @return ArrayList of card player
     */
    public ArrayList<Card> getPlayerCard(){
        return this.player;
    }

    /**
     * This method stops game with forfeit
     * @return int 1/2 of a bet
     */
    public int forfeit(){
        playerTurn=false;
        dealerTurn=false;
        return bet/-2;
    }
}