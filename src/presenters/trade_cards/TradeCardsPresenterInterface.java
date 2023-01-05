package presenters.trade_cards;

import use_case.UseCaseDataClass;

import java.util.Hashtable;

public interface TradeCardsPresenterInterface {

    public int showOptions(UseCaseDataClass ucdc, Hashtable<String, Integer> cards);

}
