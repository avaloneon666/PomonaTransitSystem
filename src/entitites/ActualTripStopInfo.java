package entitites;

public class ActualTripStopInfo
{
	private int tripNumber, stopNumber, numberOfPassengerIn, numberOfPassengerOut;
	private String Date, ScheduledStartTime, ScheduledArrivalTime, ActualStartTime, ActualArrivalTime;

	public ActualTripStopInfo(int tripNumber, int stopNumber, int numberOfPassengerIn, int numberOfPassengerOut, String Date, String ScheduledStartTime, String ScheduledArrivalTime, String ActualStartTime, String ActualArrivalTime)
	{
		this.tripNumber = tripNumber;
		this.stopNumber = stopNumber;
		this.numberOfPassengerIn = numberOfPassengerIn;
		this.numberOfPassengerOut = numberOfPassengerOut;
		this.Date = Date;
		this.ScheduledStartTime = ScheduledStartTime;
		this.ScheduledArrivalTime = ScheduledArrivalTime;
		this.ActualStartTime = ActualStartTime;
		this.ActualArrivalTime = ActualArrivalTime;
	}

	public int getTripNumber()
	{
		return tripNumber;
	}

	public void setTripNumber(int tripNumber)
	{
		this.tripNumber = tripNumber;
	}

	public int getStopNumber()
	{
		return stopNumber;
	}

	public void setStopNumber(int stopNumber)
	{
		this.stopNumber = stopNumber;
	}

	public int getNumberOfPassengerIn()
	{
		return numberOfPassengerIn;
	}

	public void setNumberOfPassengerIn(int numberOfPassengerIn)
	{
		this.numberOfPassengerIn = numberOfPassengerIn;
	}

	public int getNumberOfPassengerOut()
	{
		return numberOfPassengerOut;
	}

	public void setNumberOfPassengerOut(int numberOfPassengerOut)
	{
		this.numberOfPassengerOut = numberOfPassengerOut;
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

	public String getActualStartTime()
	{
		return ActualStartTime;
	}

	public void setActualStartTime(String actualStartTime)
	{
		ActualStartTime = actualStartTime;
	}

	public String getActualArrivalTime()
	{
		return ActualArrivalTime;
	}

	public void setActualArrivalTime(String actualArrivalTime)
	{
		ActualArrivalTime = actualArrivalTime;
	}
}
