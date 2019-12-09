package entitites;

public class TripOffering
{
	private int tripNumber, BusID;
	private String Date, ScheduledStartTime, ScheduledArrivalTime, driverName;

	public TripOffering() {
	}

	public TripOffering(int tripNumber, int BusID, String Date, String ScheduledStartTime, String ScheduledArrivalTime, String DriverName)
	{
		this.tripNumber = tripNumber;
		this.BusID = BusID;
		this.Date = Date;
		this.ScheduledStartTime = ScheduledStartTime;
		this.ScheduledArrivalTime = ScheduledArrivalTime;
		this.driverName = DriverName;
	}

	public int getTripNumber()
	{
		return tripNumber;
	}

	public void setTripNumber(int tripNumber)
	{
		this.tripNumber = tripNumber;
	}

	public int getBusID()
	{
		return BusID;
	}

	public void setBusID(int busID)
	{
		BusID = busID;
	}

	public String getDate()
	{
		return Date;
	}

	public void setDate(String date)
	{
		Date = date;
	}

	public String getScheduledStartTime()
	{
		return ScheduledStartTime;
	}

	public void setScheduledStartTime(String scheduledStartTime)
	{
		ScheduledStartTime = scheduledStartTime;
	}

	public String getScheduledArrivalTime()
	{
		return ScheduledArrivalTime;
	}

	public void setScheduledArrivalTime(String scheduledArrivalTime)
	{
		ScheduledArrivalTime = scheduledArrivalTime;
	}

	public String getDriverName()
	{
		return driverName;
	}

	public void setDriverName(String driverName)
	{
		this.driverName = driverName;
	}
}
