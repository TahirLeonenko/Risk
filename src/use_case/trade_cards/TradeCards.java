package use_case.trade_cards;

import use_case.UseCaseDataClass;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;

public class TradeCards implements TradeCardsInterface{
    @Override
    public void getOptions(UseCaseDataClass ucdc) {
        Hashtable<String, Integer> cards = ucdc.getPlayer().getCards();

    }

    // this method assumes the card numbers are betwen 1-3
    @Override
    public boolean cardsTradable(int card1, int card2, int card3) {
        if(card1 == card2 && card1 == card3){
            return true;
        }
        // only situation in which the card numbers sum to 6 is if they're all 2 (which is taken care
        // by above if statement) or if each number is different (one 1, one 2, one 3)
        return card1 + card2 + card3 == 6;
    }

    // this method assumes that cards size is 3 and that they are tradable (cardsTradable should be
    // called before it uses this method)
    @Override
    public int tradeCards(UseCaseDataClass ucdc, Hashtable<String, Integer> cards) {
        Enumeration<String> cardKeys = cards.keys();
        ArrayList<Integer> cardTroops = new ArrayList<>();
        //adds the integers to cardTroops. Also removes the cards from player
        for(int i = 0; i < cards.size(); i++) {
            String cardKey = cardKeys.nextElement();
            cardTroops.add(cards.get(cardKey));

            ucdc.getPlayer().removeCard(cardKey);
        }
        //checks if the value of the cards are all the same
        boolean allSame = true;
        for(int i = 0; i < cards.size() - 1; i++){
            if (!cardTroops.get(i).equals(cardTroops.get(i + 1))) {
                allSame = false;
                break;
            }
        }
        // if the value of the cards are the same then trading them gives the value of
        // the card * 2. If they're each different, it's 8.
        if (allSame){
            return cardTroops.get(0) * 2;
        }
        return 8;
    }
}
