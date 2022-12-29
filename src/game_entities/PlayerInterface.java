package game_entities;

import java.util.HashSet;
import java.util.Hashtable;

public interface PlayerInterface {

    public HashSet<String> getTerritories();

    public Hashtable<String, Integer> getCards();

    public String getName();

    public void addTerritory(String territory);

    public void removeTerritory(String territory);

    public void addCard(String cardName, Integer troopNum);

    public void removeCard(String cardName);

}
