package presenters.place_units;

import use_case.place_units.PlaceUnitsDataClass;

import java.util.HashSet;

public interface PlaceUnitsPresenterInterface {

    public void showOptions(PlaceUnitsDataClass pudc, int totalSoldiers);

    public void updateTroopVisuals(String territory, int troops);
}
