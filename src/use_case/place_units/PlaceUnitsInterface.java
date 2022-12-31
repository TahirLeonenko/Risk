package use_case.place_units;

import game_entities.BoardGraph;
import game_entities.PlayerInterface;

public interface PlaceUnitsInterface {

    public void getOptions(PlaceUnitsDataClass pudc);

    public void updateTerritorySoldiers(PlaceUnitsDataClass pudc, String territory, int soldiers);
}
