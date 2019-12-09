package entitites;

public class Stop
{
	private int stopNumber;
	private String StopAddress;

	public Stop(int stopNumber, String StopAddress)
	{
		this.stopNumber = stopNumber;
		this.StopAddress = StopAddress;
	}

	public int getStopNumber()
	{
		return stopNumber;
	}

	public void setStopNumber(int stopNumber)
	{
		this.stopNumber = stopNumber;
	}

	public String getStopAddress()
	{
		return StopAddress;
	}

	public void setStopAddress(String stopAddress)
	{
		this.StopAddress = stopAddress;
	}
}
