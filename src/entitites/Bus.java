package entitites;

public class Bus
{
	private int BusID, year;
	private String model;

	public Bus(int BusID, int year, String model)
	{
		this.BusID = BusID;
		this.year = year;
		this.model = model;
	}

	public int getBusID()
	{
		return BusID;
	}

	public void setBusID(int busID)
	{
		BusID = busID;
	}

	public int getYear()
	{
		return year;
	}

	public void setYear(int year)
	{
		this.year = year;
	}

	public String getModel()
	{
		return model;
	}

	public void setModel(String model)
	{
		this.model = model;
	}
}
