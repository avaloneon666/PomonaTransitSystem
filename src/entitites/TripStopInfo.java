package entitites;

public class TripStopInfo {
    private int tripNumber, stopNumber,sequenceNumber,drivingTime;
    public TripStopInfo(){}
    public TripStopInfo(int tripNumber, int stopNumber, int sequenceNumber, int drivingTime){
        this.tripNumber=tripNumber;
        this.drivingTime=drivingTime;
        this.sequenceNumber=sequenceNumber;
        this.stopNumber=stopNumber;
    }

    public int getTripNumber() {
        return tripNumber;
    }

    public void setTripNumber(int tripNumber) {
        this.tripNumber = tripNumber;
    }

    public int getStopNumber() {
        return stopNumber;
    }

    public void setStopNumber(int stopNumber) {
        this.stopNumber = stopNumber;
    }

    public int getSequenceNumber() {
        return sequenceNumber;
    }

    public void setSequenceNumber(int sequenceNumber) {
        this.sequenceNumber = sequenceNumber;
    }

    public int getDrivingTime() {
        return drivingTime;
    }

    public void setDrivingTime(int drivingTime) {
        this.drivingTime = drivingTime;
    }
}
