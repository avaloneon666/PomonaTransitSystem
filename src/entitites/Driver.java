package entitites;

public class Driver
{
	private String DriverName;
	private int driverTelephoneNumber;

	public Driver(String DriverName, int driverTelephoneNumber)
	{
		this.DriverName = DriverName;
		this.driverTelephoneNumber = driverTelephoneNumber;

	}

	public String getDriverName()
	{
		return DriverName;
	}

	public void setDriverName(String DriverName)
	{
		this.DriverName = DriverName;
	}

	public int getDriverTelephoneNumber()
	{
		return driverTelephoneNumber;
	}

	public void setDriverTelephoneNumber(int driverTelephoneNumber)
	{
		this.driverTelephoneNumber = driverTelephoneNumber;
	}
}
