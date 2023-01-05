package use_case.place_units;

import use_case.UseCaseDataClass;

public interface PlaceUnitsInterface {

    public void getOptions(UseCaseDataClass pudc);

    public void updateTerritorySoldiers(UseCaseDataClass pudc, String territory, int soldiers);
}
