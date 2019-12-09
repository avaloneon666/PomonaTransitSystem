package Workers;

import Connection.ConnectionWorker;
import Interface.ScheduleInterface;
import entitites.*;
import entitites.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public List<Bus> displayBuses() {
        List<Bus> buses = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from bus");
            while (resultSet.next()) {
                Bus bus = new Bus();
                bus.setBusID(resultSet.getInt("BusID"));
                bus.setModel(resultSet.getString("Model"));
                bus.setYear(resultSet.getInt("Year"));
                buses.add(bus);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {

                    resultSet.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement !=null)
            {
                try{
                    statement.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            if(connection!=null)
            {
                try{
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }



        }
        return buses;
    }

    @Override
    public List<Driver> displayDrivers() {
        List<Driver> drivers = new ArrayList<>();
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionWorker.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * from driver");
            while (resultSet.next()) {
                Driver driver = new Driver();
                driver.setDriverID(resultSet.getInt("DriverId"));
                driver.setDriverName(resultSet.getString("DriverName"));
                driver.setDriverTelephoneNumber(resultSet.getInt("DriverTelephone"));
                drivers.add(driver);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {

                    resultSet.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(statement !=null)
            {
                try{
                    statement.close();


                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
            if(connection!=null)
            {
                try{
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
        return drivers;
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
    public List displayTripwithStartandStopLoc(Trip trip) {
        List<entireTripSchedule> entireTrip = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM TripStopInfo tsi INNER JOIN trip t on tsi.TripNumber=t.TripNumber WHERE StartLocationName= ? AND DestinationName= ?");
            preparedStatement.setString(1, trip.getStartLocation());
            preparedStatement.setString(2, trip.getStopLocation());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                entireTripSchedule entireTripSchedule = new entireTripSchedule();
                entireTripSchedule.setBusID(resultSet.getString("DriverName"));
                entireTripSchedule.setScheduledArrivalTime(resultSet.getString("ScheduledStartTime"));
                entireTripSchedule.setScheduledArrivalTime(resultSet.getString("ScheduledArrivalTime"));
                entireTripSchedule.setStartLocation(resultSet.getString("StartLocationName"));
                entireTripSchedule.setStopLocation(resultSet.getString("DestinationName"));
                entireTrip.add(entireTripSchedule);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }


        return entireTrip;
    }
    @Override
    public void addDriver(Driver driver) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO driver (DriverName,DriverTelephoneNumber) VALUES(?,?)");
            preparedStatement.setString(1, driver.getDriverName());
            preparedStatement.setInt(2, driver.getDriverTelephoneNumber());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Override
    public void deleteBus(Bus bus) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("DELETE FROM bus WHERE BusID =?");
            preparedStatement.setInt(1, bus.getBusID());
            preparedStatement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }
    }
    @Override
    public void addBus(Bus bus) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("INSERT INTO bus (Model,Year) VALUES(?,?)");
            preparedStatement.setString(1, bus.getModel());
            preparedStatement.setInt(2, bus.getYear());

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

    }
    @Override
    public List<TripStopInfo> showStops(Trip trip) {
        List<TripStopInfo> TripStopInfos = new ArrayList<>();
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("SELECT * FROM TripStopInfo WHERE tripNumber= ?");
            preparedStatement.setInt(1, trip.getTripNumber());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                TripStopInfo tripStopInfo = new TripStopInfo();
                tripStopInfo.setTripNumber(resultSet.getInt("tripNumber"));
                tripStopInfo.setStopNumber(resultSet.getInt("stopNumber"));
                tripStopInfo.setSequenceNumber(resultSet.getInt("sequenceNumber"));
                tripStopInfo.setDrivingTime(resultSet.getInt("DrivingTime"));
                TripStopInfos.add(tripStopInfo);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (resultSet != null) {
                try {
                    resultSet.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return TripStopInfos;
    }

    @Override
    public void recordActualData(Trip trip,updateSchedule updateSchedule) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        try {
            connection = ConnectionWorker.getConnection();
            preparedStatement = connection.prepareStatement("UPDATE ActualTripInfo SET " +
                    " ActualStartTime =?, ActualArrivalTime=?, NumberOfPassengerIn= ?, NumberOfPassengerOut=? WHERE tripNumber = ?");
            preparedStatement.setString(1, updateSchedule.getActualStartTime());
            preparedStatement.setString(2, updateSchedule.getActualArrivalTime());
            preparedStatement.setInt(3,updateSchedule.getNumberOfPassengerIn());
            preparedStatement.setInt(4,updateSchedule.getNumberOfPassengerOut());
            preparedStatement.setInt(5,trip.getTripNumber());
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
            if (connection != null) {
                try {
                    connection.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }


            }
        }

    }


    public void showWeeklySchedulebyDriverandDate(Driver driver, TripOffering tripOffering) {

    }
}
