package presenters.place_units;

import use_case.UseCaseDataClass;

public interface PlaceUnitsPresenterInterface {

    public void showOptions(UseCaseDataClass pudc, int totalSoldiers);

    public void updateTroopVisuals(String territory, int troops);
}
