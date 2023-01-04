package use_case.trade_cards;

import use_case.UseCaseDataClass;

import java.util.Hashtable;

public interface TradeCardsInterface {

    public void getOptions(UseCaseDataClass ucdc);

    public boolean cardsTradable(int card1, int card2, int card3);

    public int tradeCards(UseCaseDataClass ucdc, Hashtable<String, Integer> cards);
}
