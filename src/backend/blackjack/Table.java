package backend.blackjack;
import java.util.ArrayList;

public class Table {
    private ArrayList<Card> player;
    private ArrayList<Card> dealer;
    private Logic logic;
    private boolean playerTurn;
    private boolean dealerTurn;
    private int bet;

    public Table(int puntata){
        player = new ArrayList<Card>();
        dealer = new ArrayList<Card>();
        logic = new Logic();
        this.bet = puntata;
        playerTurn = true;
        dealerTurn = false;
    }

    public int getbet(){
        return bet;
    }

    public void reset(){
        player.clear();
        dealer.clear();
        logic.reset();
    }

    public void deal(){
        player.add(logic.getCard());
        dealer.add(logic.getCard());
        player.add(logic.getCard());
        dealer.add(logic.getCard());
    }

    public int hitPlayer(){
        player.add(logic.getCard());

        if(getPlayerValue() > 21){
            playerTurn = false;
            dealerTurn = false;
        }

        return win();
    }

    public int Double(){
        bet *= 2;
        player.add(logic.getCard());

        return win();
    }

    public int stand(){
        playerTurn = false;
        dealerTurn = true;

        return win();
    }

    public int hitDealer(){
        if(getDealerValue() < 17){
            dealer.add(logic.getCard());
        }
        else{
            dealerTurn = false;
        }

        return win();
    }

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

    public int getDealerValue(){
        int value = 0;

        for(Card card : dealer){
            value += card.getValue();
        }

        return value;
    }

    public void resetDeck(){
        int count = 0;

        for(boolean[] suit : logic.getUsedCards()){
            for(boolean card : suit){
                if(card){
                    count++;
                }
            }
        }

        if(count > 40){
            //logic.reset();
            throw new RuntimeException("Deck reset");
        }
    }


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
        if(playerTurn == false && dealerTurn == false && getPlayerValue() > getDealerValue()){
            return 1;
        }
        if(playerTurn == false && dealerTurn == false && getPlayerValue() < getDealerValue()){
            return 2;
        }
        if(playerTurn == false && dealerTurn == false && getPlayerValue() == getDealerValue()){
            return 3;
        }

        return -1;
    }

    public int win(){
        if(check() == 0){
            return bet;
        }
        if(check() == 1){
            return bet * 1;
        }
        if(check() == 2){
            return bet * -1;
        }
        if(check() == 3){
            return 0;
        }

        return 69420;
    }

    public boolean getPlayerTurn(){
        return playerTurn;
    }

    public boolean getDealerTurn(){
        return dealerTurn;
    }

    public void setDealerTurn(boolean A){
        dealerTurn=A;
    }

    public ArrayList<Card> getDealerCard(){
        return this.dealer;
    }
    public ArrayList<Card> getPlayerCard(){
        return this.player;
    }

    public int forfeit(){
        playerTurn=false;
        dealerTurn=false;
        return bet/-2;
    }
}