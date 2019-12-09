package entitites;

public class entireTripSchedule {
    private String StartLocation, StopLocation,ScheduledStartTime,ScheduledArrivalTime,DriverID,BusID;

    public entireTripSchedule() {

    }

    public entireTripSchedule(String startLocation, String stopLocation, String scheduledStartTime, String scheduledArrivalTime, String driverID, String busID) {
        this.StartLocation = startLocation;
        this.StopLocation = stopLocation;
        this.ScheduledStartTime = scheduledStartTime;
        this.ScheduledArrivalTime = scheduledArrivalTime;
        this.DriverID = driverID;
        this.BusID = busID;
    }

    public String getStartLocation() {
        return StartLocation;
    }

    public void setStartLocation(String startLocation) {
        StartLocation = startLocation;
    }

    public String getStopLocation() {
        return StopLocation;
    }

    public void setStopLocation(String stopLocation) {
        StopLocation = stopLocation;
    }

    public String getScheduledStartTime() {
        return ScheduledStartTime;
    }

    public void setScheduledStartTime(String scheduledStartTime) {
        ScheduledStartTime = scheduledStartTime;
    }

    public String getScheduledArrivalTime() {
        return ScheduledArrivalTime;
    }

    public void setScheduledArrivalTime(String scheduledArrivalTime) {
        ScheduledArrivalTime = scheduledArrivalTime;
    }

    public String getDriverID() {
        return DriverID;
    }

    public void setDriverID(String driverID) {
        DriverID = driverID;
    }

    public String getBusID() {
        return BusID;
    }

    public void setBusID(String busID) {
        BusID = busID;
    }
}
