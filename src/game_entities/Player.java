package game_entities;

import java.util.HashSet;
import java.util.Hashtable;

public class Player implements PlayerInterface{
    private HashSet<String> territories;
    private Hashtable<String, Integer> cards;

    private final String name;

    public Player(String name) {
        this.name = name;
    }

    @Override
    public HashSet<String> getTerritories() {
        return territories;
    }

    @Override
    public Hashtable<String, Integer> getCards() {
        return cards;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void addTerritory(String territory) {
        territories.add(territory);
    }

    @Override
    public void removeTerritory(String territory) {
        territories.remove(territory);
    }

    @Override
    public void addCard(String cardName, Integer troopNum) {
        cards.put(cardName, troopNum);
    }

    @Override
    public void removeCard(String cardName) {
        cards.remove(cardName);
    }
}
