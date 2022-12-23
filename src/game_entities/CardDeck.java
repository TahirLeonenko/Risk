package game_entities;

import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Random;

public class CardDeck implements CardDeckInterface{
    private Hashtable<String, Integer> cards;

    @Override
    public void addCard(String cardName, Integer troopNum) {
        cards.put(cardName, troopNum);
    }

    @Override
    public void removeCard(String cardName) {
        cards.remove(cardName);
    }

    @Override
    public Hashtable<String, Integer> pickCard() {
        Enumeration<String> cardNames = cards.keys();
        Hashtable<String, Integer> card = new Hashtable<String, Integer>();
        String cardString = cardNames.nextElement();
        card.put(cardString, cards.get(cardString));
        //hashtable doesn't maintain insertion order so picking the first card is already random
        return card;
    }
}
