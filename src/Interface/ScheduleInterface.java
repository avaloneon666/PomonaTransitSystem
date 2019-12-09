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
    List<TripOffering> displayTripOfferings();
    List displayTripwithStartandStopLoc(Trip trip);

    void addDriver(Driver driver);
    void deleteBus(int BusID);

    void addBus(Bus bus);
    List<TripStopInfo> showStops(Trip trip);

    void changeDriver(int DriverID, TripOffering tripOffering);

    void deleteTripOffering(TripOffering tripOffering);

    List<TripOffering> showWeeklyScheduleByDriverAndDate(Driver driver, String Date);

    void addTripOffering(TripOffering tripOffering);

    void changeBus(int BusID, TripOffering tripOffering);

    void recordActualData(Trip trip, updateSchedule updateSchedule);
}
