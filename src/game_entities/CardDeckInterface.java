package game_entities;

import java.util.Hashtable;

public interface CardDeckInterface {
    public void addCard(String cardName, Integer troopNum);
    public void removeCard(String cardName);
    public Hashtable<String, Integer> pickCard();
}
