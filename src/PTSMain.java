import Workers.ScheduleWorker;
import entitites.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PTSMain
{
	public static void main(String[] args)
	{
		System.out.println("Hello, I am CL4P-TR4P");
		System.out.println("What would you like to do?");
		System.out.println("1. Display Drivers");
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
		else if(userInputOne==3){

			deleteABus();
		}
		else if (userInputOne==4){
			addADriver();
		}
		else if (userInputOne==5){
			addABus();
		}
		else if(userInputOne==6){
			displayStopswithTripNumber();
		}
		else if(userInputOne==7){

			recordTripData();

		}
		else if(userInputOne==8){
			displayTripwithStartandStopLoc();
		}

	}

	private static void displayTripwithStartandStopLoc(){
		System.out.println("Current Trips:");
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Trip> trips = scheduleWorker.displayTrips();
		for (Trip trip : trips)
		{
			System.out.println(trip.getTripNumber() + "," + trip.getStartLocation() + "," + trip.getStopLocation());
		}
		Trip trip = new Trip();
		Scanner input = new Scanner(System.in);
		System.out.println("Please Enter Trip Number for More Information: ");
		trip.setTripNumber(input.nextInt());
		List<entireTripSchedule> entireTripSchedules= scheduleWorker.displayTripwithStartandStopLoc(trip);
		for(entireTripSchedule entireTripSchedule : entireTripSchedules)
		{
			System.out.println(entireTripSchedule.getTripNumber()+", "+entireTripSchedule.getStartLocation()+", "+entireTripSchedule.getStopLocation()+", "+entireTripSchedule.getScheduledStartTime()+", "+entireTripSchedule.getScheduledArrivalTime()+", "+entireTripSchedule.getDriverID()+", "+entireTripSchedule.getBusID());
		}




	}


	private static void recordTripData() {
		System.out.println("Current Trips:");
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		Scanner input = new Scanner(System.in);
		List<Trip> trips = scheduleWorker.displayTrips();
		for (Trip trip : trips)
		{
			System.out.println(trip.getTripNumber() + "," + trip.getStartLocation() + "," + trip.getStopLocation());
		}
		System.out.println("Enter Trip Number to Add to Record:");
		int TripNumber= input.nextInt();
		Trip trip= new Trip();
		updateSchedule updateSchedule= new updateSchedule();
		System.out.println("Please Enter Departure Time: ");
		updateSchedule.setActualStartTime(input.nextLine());
		System.out.println("Please Enter an Arrival Time:");
		updateSchedule.setActualArrivalTime(input.nextLine());
		System.out.println("Please Enter Number of Passengers In:");
		updateSchedule.setNumberOfPassengerIn(input.nextInt());
		System.out.println("Please Enter Number of Passengers Out:");
		updateSchedule.setNumberOfPassengerOut(input.nextInt());
		trip.setTripNumber(TripNumber);
		scheduleWorker.recordActualData(trip,updateSchedule);
	}

	private static void displayStopswithTripNumber() {
		System.out.println("Current Trips:");
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Trip> trips = scheduleWorker.displayTrips();
		for (Trip trip : trips)
		{
			System.out.println(trip.getTripNumber() + "," + trip.getStartLocation() + "," + trip.getStopLocation());
		}
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Trip Number to List Stops:");
		int TripNumber= input.nextInt();
		Trip trip= new Trip();
		trip.setTripNumber(TripNumber);
		List<TripStopInfo> TripStopInfos = scheduleWorker.showStops(trip);
		for(TripStopInfo tripStopInfo : TripStopInfos){
			System.out.println(tripStopInfo.getTripNumber()+", "+tripStopInfo.getDrivingTime()+", "+tripStopInfo.getStopNumber()+", "+tripStopInfo.getSequenceNumber());
		}
	}

	private static void addABus() {
		System.out.println("Current Buses:");
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Bus> buses = scheduleWorker.displayBuses();
		for (Bus bus : buses)
		{
			System.out.println(bus.getBusID() + "," + bus.getModel() + "," + bus.getYear());
		}
		System.out.println("Enter Bus Model:");
		Scanner input = new Scanner(System.in);
		String busModel= input.nextLine();
		System.out.println("Enter Bus Year");
		int Year= input.nextInt();
		Bus bus = new Bus();
		bus.setYear(Year);
		bus.setModel(busModel);
		scheduleWorker.addBus(bus);
	}

	private static void addADriver() {
		System.out.println("Current Drivers:");
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Driver> drivers = scheduleWorker.displayDrivers();
		for (Driver driver : drivers)
		{
			System.out.println(driver.getDriverID() + "," + driver.getDriverName() + "," + driver.getDriverTelephoneNumber());
		}
		System.out.println("Enter New Driver Name:");
		Scanner input = new Scanner(System.in);
		String DriverName= input.nextLine();
		System.out.println("Enter New Driver Telephone Number:");
		int DriverTelephone= input.nextInt();
		Driver driver = new Driver();
		driver.setDriverName(DriverName);
		driver.setDriverTelephoneNumber(DriverTelephone);
		scheduleWorker.addDriver(driver);
	}

	private static void deleteABus() {
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<Bus> buses = scheduleWorker.displayBuses();
		for (Bus bus : buses)
		{
			System.out.println(bus.getBusID() + "," + bus.getModel() + "," + bus.getYear());
		}
		System.out.println("Which Bus would you like to delete?");
		Scanner input = new Scanner(System.in);
		int BusId= input.nextInt();
		scheduleWorker.deleteBus(BusId);
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

