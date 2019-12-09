package Interface;

import entitites.*;

import java.util.List;

public interface ScheduleInterface {

    void createTripTable();
    void createTripOfferingTable();
    void createBusTable();
    void createStopTable();
    void createActualTripStopInfoTable();
    void createTripStopInfoTable();
    void createDriverTable();
    List<Bus> displayBuses();
    List<Driver> displayDrivers();
    List<Trip> displayTrips();
    List displayTripwithStartandStopLoc(Trip trip);

    void addDriver(Driver driver);
    void deleteBus(int BusID);

    void addBus(Bus bus);
    List<TripStopInfo> showStops(Trip trip);
    void showWeeklyScheduleByDriverAndDate(Driver driver, TripOffering tripOffering);

    void deleteTripOffering(TripOffering tripOffering);

    void addTripOffering(TripOffering tripOffering);

    void changeDriver(TripOffering tripOffering);

    void changeBus(TripOffering tripOffering);

    void recordActualData(Trip trip, updateSchedule updateSchedule);
}
