package entitites;

public class Driver {
    private String DriverName;
    private int driverTelephoneNumber, driverID;


    public Driver(String DriverName, int driverTelephoneNumber, int driverID)
    {
        this.DriverName = DriverName;
        this.driverTelephoneNumber=driverTelephoneNumber;
        this.driverID=driverID;
    }

    public String getDriverName() {
        return DriverName;
    }

    public void setDriverName(String DriverName) {
        this.DriverName = DriverName;
    }

    public int getDriverTelephoneNumber() {
        return driverTelephoneNumber;
    }

    public void setDriverTelephoneNumber(int driverTelephoneNumber) {
        this.driverTelephoneNumber = driverTelephoneNumber;
    }

    public int getDriverID() {
        return driverID;
    }

    public void setDriverID(int driverID) {
        this.driverID = driverID;
    }
}
