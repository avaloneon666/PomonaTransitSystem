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
		System.out.println("1. Display Buses");
		System.out.println("2. Display Drivers");
		System.out.println("3. Delete a Bus"); // Requirement Number 7.
		System.out.println("4. Add a Driver");// Requirement Number 5.
		System.out.println("5. Add a Bus");// Requirement Number 6.
		System.out.println("6. Display the Stops of a Given Trip");// Requirement Number 3.
		System.out.println("7. Insert Post-Trip Data into Trip Information");// Requirement Number 8.
		System.out.println("8. Display the Schedule of all  Trips for a given Start Location and Destination Name");// Requirement Number 1.
		System.out.println("9. Change Bus of a given trip offering");
		System.out.println("10. Delete a Trip Offering");
		System.out.println("11. Change Driver of a Trip Offering");
		System.out.println("12. Add a Trip Offering");
		System.out.println("13. Check Weekly Schedule of a Driver");
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
		else if(userInputOne==9){
			changeBus();
		}
		else if(userInputOne==10){
			deletetripOffering();
		}
		else if(userInputOne==11){
			changeDriver();
		}
		else if(userInputOne==12){
			addTripOffering();
		}
		else if(userInputOne==13){
			checkWeeklySchedule();


		}

	}

	private static void checkWeeklySchedule() {
		displayDrivers();
		Scanner input = new Scanner(System.in);
		ScheduleWorker scheduleWorker= new ScheduleWorker();
		Driver driver= new Driver();
		System.out.println("Please enter the Driver Name to Display Schedule ");
		driver.setDriverName(input.nextLine());
		System.out.println("Please enter a Date in the YYYY-MM-DD format otherwise you'll fuck up my shit");
		String Date = input.nextLine();
		List<TripOffering> tripOfferings= scheduleWorker.showWeeklyScheduleByDriverAndDate(driver, Date);
		System.out.println("Current Trip Offerings");
		for (TripOffering tripOffering : tripOfferings)
		{
			System.out.println(tripOffering.getDate()+", "+tripOffering.getDriverName()+", "+
					tripOffering.getBusID()+", "+tripOffering.getTripNumber()+", "+
					tripOffering.getScheduledStartTime()+", "+tripOffering.getScheduledArrivalTime());
		}
	}
	private static void addTripOffering() {
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		Scanner input = new Scanner(System.in);
		List<TripOffering> tripOfferings = scheduleWorker.displayTripOfferings();
		System.out.println("Current Trip Offerings");
		for (TripOffering tripOffering : tripOfferings)
		{
			System.out.println(tripOffering.getDate()+", "+tripOffering.getDriverName()+", "+
					tripOffering.getBusID()+", "+tripOffering.getTripNumber()+", "+
					tripOffering.getScheduledStartTime()+", "+tripOffering.getScheduledArrivalTime());
		}
		TripOffering tripOffering= new TripOffering();

		System.out.println("Enter the Trip Number for the Trip you want to Add");

		tripOffering.setTripNumber(input.nextInt());
		input.nextLine();
		System.out.println("Enter the Date of the Trip you want to Add");

		tripOffering.setDate(input.nextLine());

		System.out.println("Enter Scheduled Start Time of the Trip you want to ADD");

		tripOffering.setScheduledStartTime(input.nextLine());

		System.out.println("Enter Scheduled Arrival Time of the Trip you want to ADD");

		tripOffering.setScheduledArrivalTime(input.nextLine());

		System.out.println("Enter the Drivers Name for the trip you want to add");

		tripOffering.setDriverName(input.nextLine());

		System.out.println("Enter the Bus ID");

		tripOffering.setBusID(input.nextInt());

		scheduleWorker.addTripOffering(tripOffering);
	}
	private static void changeDriver() {
		displayDrivers();
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<TripOffering> tripOfferings = scheduleWorker.displayTripOfferings();
		for (TripOffering tripOffering : tripOfferings)
		{
			System.out.println(tripOffering.getDate()+", "+tripOffering.getDriverName()+", "+
					tripOffering.getBusID()+", "+tripOffering.getTripNumber()+", "+
					tripOffering.getScheduledStartTime()+", "+tripOffering.getScheduledArrivalTime());
		}
		TripOffering tripOffering= new TripOffering();
		System.out.println("Enter the Trip Number for the Trip you want to change the Driver For");
		Scanner input = new Scanner(System.in);
		tripOffering.setTripNumber(input.nextInt());
		input.nextLine();
		System.out.println("Enter the Date of the Trip you want to change Driver For");
		tripOffering.setDate(input.nextLine());
		System.out.println("Enter Scheduled Start Time of the Trip you want to change the Driver");
		tripOffering.setScheduledStartTime(input.nextLine());
		System.out.println("Enter the DriverID you want to change to");
		int DriverId=input.nextInt();
		input.nextLine();
		scheduleWorker.changeDriver(DriverId,tripOffering);

	}
	private static void deletetripOffering() {
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		List<TripOffering> tripOfferings = scheduleWorker.displayTripOfferings();
		System.out.println("Current Trip Offerings");
		for (TripOffering tripOffering : tripOfferings)
		{
			System.out.println(tripOffering.getDate()+", "+tripOffering.getDriverName()+", "+
					tripOffering.getBusID()+", "+tripOffering.getTripNumber()+", "+
					tripOffering.getScheduledStartTime()+", "+tripOffering.getScheduledArrivalTime());
		}
		TripOffering tripOffering= new TripOffering();
		System.out.println("Enter the Trip Number for the Trip you want to Delete");
		Scanner input = new Scanner(System.in);
		tripOffering.setTripNumber(input.nextInt());
		input.nextLine();
		System.out.println("Enter the Date of the Trip you want to Delete");
		tripOffering.setDate(input.nextLine());
		System.out.println("Enter Scheduled Start Time of the Trip you want to Delete");
		tripOffering.setScheduledStartTime(input.nextLine());
		scheduleWorker.deleteTripOffering(tripOffering);
	}
	private static void changeBus() {
		displayBuses();
		ScheduleWorker scheduleWorker = new ScheduleWorker();
		System.out.println("Current Trip Offerings");
		List<TripOffering> tripOfferings = scheduleWorker.displayTripOfferings();

		for (TripOffering tripOffering : tripOfferings)
		{
			System.out.println(tripOffering.getDate()+", "+tripOffering.getDriverName()+", "+
					tripOffering.getBusID()+", "+tripOffering.getTripNumber()+", "+
					tripOffering.getScheduledStartTime()+", "+tripOffering.getScheduledArrivalTime());
		}
		TripOffering tripOffering= new TripOffering();
		System.out.println("Enter the Trip Number for the Trip you want to change the Bus for");
		Scanner input = new Scanner(System.in);
		tripOffering.setTripNumber(input.nextInt());
		input.nextLine();
		System.out.println("Enter the Date of the Trip");
		tripOffering.setDate(input.nextLine());
		System.out.println("Enter Scheduled Start Time of the Trip");
		tripOffering.setScheduledStartTime(input.nextLine());
		System.out.println("Enter the Bus ID you want to change to");
		int BusID=input.nextInt();
		input.nextLine();
		scheduleWorker.changeBus(BusID,tripOffering);

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
		List<TripStopInfo> tripStopInfos= scheduleWorker.displayTripwithStartandStopLoc(trip);
		for(TripStopInfo tripStopInfo : tripStopInfos)
		{
			System.out.println(tripStopInfo.getTripNumber()+", "+tripStopInfo.getDrivingTime()+", "+tripStopInfo.getStopNumber()+", "+tripStopInfo.getSequenceNumber());
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
		input.nextLine();
		Trip trip= new Trip();
		updateSchedule updateSchedule= new updateSchedule();
		System.out.println("Please Enter Departure Time: ");
		updateSchedule.setActualStartTime(input.nextLine());

		System.out.println("Please Enter an Arrival Time:");
		updateSchedule.setActualArrivalTime(input.nextLine());

		System.out.println("Please Enter Number of Passengers In:");
		updateSchedule.setNumberOfPassengerIn(input.nextInt());
		input.nextLine();
		System.out.println("Please Enter Number of Passengers Out:");
		updateSchedule.setNumberOfPassengerOut(input.nextInt());
		input.nextLine();
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
		Driver driver = new Driver();
		driver.setDriverName(DriverName);
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
			System.out.println(driver.getDriverID() + "," + driver.getDriverName());
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

