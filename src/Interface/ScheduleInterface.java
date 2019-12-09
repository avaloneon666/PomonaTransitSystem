package Interface;

import entitites.*;

public interface ScheduleInterface {

    void createTripTable();
    void createTripOfferingTable();
    void createBusTable();
    void createStopTable();
    void createActualTripStopInfoTable();
    void createTripStopInfoTable();
    void createDriverTable();

    void displayTripwithStartandStopLoc(Trip trip, TripOffering tripOffering);
    void addDriver(Driver driver);
    void deleteBus(Bus bus);
    void addBus(Bus bus);
    void showStops(TripStopInfo tripStopInfo);
    void showWeeklySchedulebyDriverandDate(Driver driver, TripOffering tripOffering);
    void recordActualData(ActualTripStopInfo actualTripStopInfo, Trip trip);








}
