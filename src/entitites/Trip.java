package entitites;

public class Trip
{
	private int tripNumber;
	private String StartLocation, StopLocation;

	public Trip(int tripNumber, String StartLocation, String StopLocation)
	{
		this.tripNumber = tripNumber;
		this.StartLocation = StartLocation;
		this.StopLocation = StopLocation;

	}

	public int getTripNumber()
	{
		return tripNumber;
	}

	public void setTripNumber(int tripNumber)
	{
		this.tripNumber = tripNumber;
	}

	public String getStartLocation()
	{
		return StartLocation;
	}

	public void setStartLocation(String startLocation)
	{
		this.StartLocation = startLocation;
	}

	public String getStopLocation()
	{
		return StopLocation;
	}

	public void setStopLocation(String stopLocation)
	{
		this.StopLocation = stopLocation;
	}

}
