package entitites;

public class updateSchedule
{
    private int numberOfPassengerIn, numberOfPassengerOut;
    private String ActualStartTime,ActualArrivalTime;

    public updateSchedule() {
    }

    public updateSchedule(int numberOfPassengerIn, int numberOfPassengerOut, String actualStartTime, String actualArrivalTime) {
        this.numberOfPassengerIn = numberOfPassengerIn;
        this.numberOfPassengerOut = numberOfPassengerOut;
        this.ActualStartTime = actualStartTime;
        this.ActualArrivalTime = actualArrivalTime;
    }

    public int getNumberOfPassengerIn() {
        return numberOfPassengerIn;
    }

    public void setNumberOfPassengerIn(int numberOfPassengerIn) {
        this.numberOfPassengerIn = numberOfPassengerIn;
    }

    public int getNumberOfPassengerOut() {
        return numberOfPassengerOut;
    }

    public void setNumberOfPassengerOut(int numberOfPassengerOut) {
        this.numberOfPassengerOut = numberOfPassengerOut;
    }

    public String getActualStartTime() {
        return ActualStartTime;
    }

    public void setActualStartTime(String actualStartTime) {
        ActualStartTime = actualStartTime;
    }

    public String getActualArrivalTime() {
        return ActualArrivalTime;
    }

    public void setActualArrivalTime(String actualArrivalTime) {
        ActualArrivalTime = actualArrivalTime;
    }
}
