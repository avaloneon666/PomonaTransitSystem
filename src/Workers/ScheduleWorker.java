package Workers;

import Connection.ConnectionWorker;
import Interface.ScheduleInterface;
import entitites.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ScheduleWorker implements ScheduleInterface {


    @Override
    public void createTripTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Trip (TripNumber int primary key unique auto_increment NOT NULL," +
                            "StartLocationName varchar (55) , DestinationName varchar (55))");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }


    }

    @Override
    public void createTripOfferingTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS TripOffering (TripNumber int ," +
                            " Date varchar(55) primary key NOT NULL , ScheduledStartTime varchar(55) NOT NULL ," +
                            " ScheduledArrivalTime varchar (55), DriverName varchar (55), BusID varchar (55)," +
                            "foreign key(BusID) references Bus, foreign key (DriverName) references Driver, foreign key (TripNumber) references Trip)");


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }


    }


    @Override
    public void createStopTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Stop (StopNumber int primary key unique auto_increment NOT NULL, StopAddress varchar (55))");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }



    }

    @Override
    public void createActualTripStopInfoTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS ActualTripStopInfo (TripNumber int , Date varchar (55), ScheduledStartTime varchar(55), StopNumber varchar(55), ScheduleArrivalTime varchar(55)," +
                            " ActualStartTime varchar (55), ActualArrivalTime varchar(55)," +
                            " NumberOfPassengerIn varchar(55), NumberOfPassengerOut varchar(55), foreign key(Date) references TripOffering(Date)," +
                            " foreign key (StopNumber) references Stop(StopNumber), foreign key (TripNumber) references Trip(TripNumber), foreign key (ScheduledStartTime) references TripOffering(ScheduledStartTime)) ");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }



    }

    @Override
    public void createTripStopInfoTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS TripStopInfo (TripNumber int, StopNumber int, SequenceNumber int(10), DrivingTime int," +
                            "foreign key (TripNumber) references Trip, foreign key(StopNumber) references Stop)");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }


    }


    @Override
    public void createDriverTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Driver (DriverID int primary key unique auto_increment, DriverName varchar (55), " +
                            "Model varchar (55), Year int (10))");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }

    }


    @Override
    public void createBusTable() {
        Connection connection = null;
        Statement statement = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            statement.execute(
                    "CREATE TABLE IF NOT EXISTS Bus (BusID int primary key unique auto_increment, " +
                            "Model varchar (55), Year int (10))");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }

        }


    }























    @Override
    public void displayTripwithStartandStopLoc(Trip trip, TripOffering tripOffering) {

    }

    @Override
    public void addDriver(Driver driver) {

    }

    @Override
    public void deleteBus(Bus bus) {

    }

    @Override
    public void addBus(Bus bus) {

    }

    @Override
    public void showStops(TripStopInfo tripStopInfo) {

    }

    @Override
    public void showWeeklySchedulebyDriverandDate(Driver driver, TripOffering tripOffering) {

    }

    @Override
    public void recordActualData(ActualTripStopInfo actualTripStopInfo, Trip trip) {

    }
}
