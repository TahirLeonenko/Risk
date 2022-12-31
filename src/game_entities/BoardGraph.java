package game_entities;

import java.util.ArrayList;

public interface BoardGraph{
    /*
     * This gives the list of territories that are neighbouring the player's territory that aren't owned by the player
     * (territories that can be attacked)
     */

    public void addTerritory(String territoryName);

    public void addEdge(String territoryName1, String territoryName2);

    public ArrayList<String> getEnemyNeighbours(String territoryName);

    /*
     * This is the complete list of allied territories that has a path from the given territory.
     */
    public ArrayList<String> getAlliedNeighbours(String territoryName);

    public void setOwner(String territoryName,String player);

    public void setTroops(String territoryName, int troops);
    public String getOwner(String territoryName);

    public int getTroops(String territoryName);

}
