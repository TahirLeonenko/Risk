package use_case.place_units;

import presenters.place_units.PlaceUnitsPresenterInterface;
import use_case.UseCaseDataClass;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Hashtable;

public class PlaceUnits implements PlaceUnitsInterface{
    private final PlaceUnitsPresenterInterface presenter;
    private Hashtable<HashSet<String>, Integer> continents;

    public PlaceUnits(PlaceUnitsPresenterInterface presenter) {
        this.presenter = presenter;
    }

    @Override
    public void getOptions(UseCaseDataClass pudc) {
        HashSet<String> territories = pudc.getPlayer().getTerritories();
        int totalSoldiers = getTroopsPerTurn(territories);
        presenter.showOptions(pudc, totalSoldiers);
    }

    @Override
    public void updateTerritorySoldiers(UseCaseDataClass pudc, String territory, int soldiers) {
        int troopsSoFar = pudc.getBoard().getTroops(territory);
        troopsSoFar += soldiers;
        pudc.getBoard().setTroops(territory, troopsSoFar);
        presenter.updateTroopVisuals(territory, troopsSoFar);
    }

    public int getTroopsPerTurn(HashSet<String> territories){
        int troopsSoFar = 0;
        //the amount of troops you get per turn from amount of territories is amount of territories
        // divided by 3 rounded down.
        troopsSoFar += territories.size()/3;
        //minimum troops per turn is 3
        if(troopsSoFar < 3){
            troopsSoFar = 3;
        }

        //adds the troop value of the continent if the player owns all the territories in the continent

        Enumeration<HashSet<String>> continentKey = continents.keys();
        for(int i = 0; i < continents.size(); i++){
            HashSet<String> continent =continentKey.nextElement();
            if(territories.containsAll(continent)){
                troopsSoFar  += continents.get(continent);
            }
        }
        return troopsSoFar;
    }

    public void setContinents(){
        //NA
        HashSet<String> northAmerica = new HashSet<>();
        northAmerica.add("Alaska");
        northAmerica.add("Northwest Territory");
        northAmerica.add("Greenland");
        northAmerica.add("Alberta");
        northAmerica.add("Ontario");
        northAmerica.add("Quebec");
        northAmerica.add("Western US");
        northAmerica.add("Eastern US");
        northAmerica.add("Central America");
        continents.put(northAmerica, 5);
        //SA
        HashSet<String> southAmerica = new HashSet<>();
        southAmerica.add("Argentina");
        southAmerica.add("Brazil");
        southAmerica.add("Peru");
        southAmerica.add("Venezuela");
        continents.put(southAmerica, 2);
        //Europe
        HashSet<String> europe = new HashSet<>();
        europe.add("Great Britain");
        europe.add("Iceland");
        europe.add("Northern Europe");
        europe.add("Scandinavia");
        europe.add("Southern Europe");
        europe.add("Ukraine");
        europe.add("Western Europe");
        continents.put(europe, 5);
        //Africa
        HashSet<String> africa = new HashSet<>();
        africa.add("Congo");
        africa.add("East Africa");
        africa.add("Egypt");
        africa.add("Madagascar");
        africa.add("North Africa");
        africa.add("South Africa");
        continents.put(africa, 3);
        //Asia
        HashSet<String> asia = new HashSet<>();
        asia.add("Afghanistan");
        asia.add("China");
        asia.add("India");
        asia.add("Irkutsk");
        asia.add("Japan");
        asia.add("Kamchatka");
        asia.add("Middle East");
        asia.add("Mongolia");
        asia.add("Siam");
        asia.add("Siberia");
        asia.add("Ural");
        asia.add("Yakutsk");
        continents.put(asia, 7);
        //Australia
        HashSet<String> australia = new HashSet<>();
        australia.add("Eastern Australia");
        australia.add("Indonesia");
        australia.add("New Guinea");
        australia.add("Western Australia");
        continents.put(australia, 2);


    }
}
