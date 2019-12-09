import Workers.ScheduleWorker;
import entitites.Bus;
import entitites.Driver;

import java.util.List;
import java.util.Scanner;

public class PTSMain
{
	public static void main(String[] args)
	{
		System.out.println("Hello, I am CL4P-TR4P");
		System.out.println("What would you like to do?");
		System.out.println("1. Display Bus Drivers");
		System.out.println("2. Display Buses");
		System.out.println("3. Delete a Bus"); // Requirement Number 7.
		System.out.println("4. Add a Driver");// Requirement Number 5.
		System.out.println("5. Add a Bus");// Requirement Number 6.
		System.out.println("6. Display the Stops of a Given Trip");// Requirement Number 3.
		System.out.println("7. Insert Post-Trip Data into Trip Information");// Requirement Number 8.
		System.out.println("8. Display the Schedule of all  Trips for a given Start Location and Destination Name");// Requirement Number 1.
		Scanner input = new Scanner(System.in);
		int userInputOne= input.nextInt();
		if(userInputOne==1)
		{
			displayBuses();
		}
		else if(userInputOne==2)
		{

			displayDrivers();
		}







	}

	private static void displayDrivers() {
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Driver> drivers = scheduleWorker.displayDrivers();
		for (Driver driver : drivers)
		{
			System.out.println(driver.getDriverID() + "," + driver.getDriverName() + "," + driver.getDriverTelephoneNumber());
		}

	}

	private static void displayBuses() {

		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Bus> buses = scheduleWorker.displayBuses();
		for (Bus bus : buses)
		{
			System.out.println(bus.getBusID() + "," + bus.getModel() + "," + bus.getYear());
		}
	}
}

