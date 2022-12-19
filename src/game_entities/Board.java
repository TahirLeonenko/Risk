package game_entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class Board implements BoardGraph{

    private final Hashtable<String, Territory> territoryH = new Hashtable<>();

    @Override
    public void addTerritory(String territoryName) {
        if(!territoryH.containsKey(territoryName)){
            territoryH.put(territoryName, new Territory(territoryName));
        }
    }

    @Override
    public void addEdge(String territoryName1, String territoryName2) {
        if(territoryH.containsKey(territoryName1) && territoryH.containsKey(territoryName2)){
            Territory t1 = territoryH.get(territoryName1);
            Territory t2 = territoryH.get(territoryName2);
            t1.addNeighbour(t2);
            t2.addNeighbour(t1);
        }
    }

    @Override
    public ArrayList<String> getEnemyNeighbours(String territoryName) {
        return territoryH.get(territoryName).getEnemyNeighbours();
    }

    @Override
    public ArrayList<String> getAlliedNeighbours(String territoryName) {
        return territoryH.get(territoryName).getAlliedNeighbours(new HashSet<>());
    }

    @Override
    public void setOwner(String territoryName, String player) {
        territoryH.get(territoryName).setOwner(player);
    }

    @Override
    public void setTroops(String territoryName, int troops){
        territoryH.get(territoryName).setTroops(troops);
    }

    @Override
    public String getOwner(String territoryName) {
        return territoryH.get(territoryName).getOwner();
    }

    @Override
    public int getTroops(String territoryName, int troops){
        return territoryH.get(territoryName).getTroops();
    }


    public static class Territory{
        private final String name;
        private int troops;
        private String player;
        private final HashSet<Territory> neighbours;

        private Territory(String name) {
            this.name = name;
            this.neighbours = new HashSet<>();
        }

        public int getTroops() {
            return troops;
        }
        public String getOwner(){return player;}

        private void addNeighbour(Territory neighbour){
            neighbours.add(neighbour);
        }

        private ArrayList<String> getEnemyNeighbours(){
            ArrayList<String> enemyNeighbours = new ArrayList<>();
            for(Territory neighbour: neighbours){
                if(!neighbour.player.equals(this.player)){
                    enemyNeighbours.add(neighbour.name);
                }
            }
            return enemyNeighbours;
        }

        private ArrayList<String> getAlliedNeighbours(HashSet<String> checkedNeighbours) {
            ArrayList<String> allyNeighbours = new ArrayList<>();
            checkedNeighbours.add(this.name);
            for(Territory neighbour: neighbours){
                if(neighbour.player.equals(this.player) && !checkedNeighbours.contains(neighbour.player)){
                    allyNeighbours.add(neighbour.name);
                    allyNeighbours.addAll(this.getAlliedNeighbours(checkedNeighbours));
                }
            }
            return allyNeighbours;
        }

        private void setOwner(String player){
            this.player = player;
            this.troops = 0;
        }

        private void setTroops (int troops){
            this.troops = troops;
        }

    }
}
