package game_entities;

import java.util.ArrayList;

public interface BoardGraph<Territory> {
    /*
     * This gives the list of territories that are neighbouring the player's territory that aren't owned by the player
     * (territories that can be attacked)
     */
    public ArrayList<Territory> getEnemyNeigbours(Territory territory);

    /*
     * This is the complete list of allied territories that has a path from the given territory.
     */
    public ArrayList<Territory> getAlliedNeighbours(Territory territory);

}
