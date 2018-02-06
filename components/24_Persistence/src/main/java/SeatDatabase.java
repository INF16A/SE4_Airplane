import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;

public class SeatDatabase {
    private static SeatDatabase instance = new SeatDatabase();

    public static SeatDatabase getInstance() {return instance;}

    private SeatDatabase(){}

    private Connection connection;
    private String driverName = "jdbc:hsqldb:";
    private String username = "sa";
    private String password = "";

    public void startup() {
        try {
            Class.forName("org.hsqldb.jdbcDriver");
            String databaseURL = driverName + Configuration.instance.databaseFile;
            connection = DriverManager.getConnection(databaseURL,username,password);
            if (Configuration.instance.isDebug)
                System.out.println("SeatDatabase - connection : " + connection);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void init() {
        importCSVDataSeats(Configuration.instance.seatsArchive);
    }

    public Connection getConnection() {
        return connection;
    }

    public synchronized void update(String sqlStatement) {
        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sqlStatement);
            if (result == -1)
                System.out.println("error executing " + sqlStatement);
            statement.close();
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }

    public void dropTable() {
        System.out.println("--- dropTable");

        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("DROP TABLE seats");
        System.out.println("sqlStringBuilder : " + sqlStringBuilder.toString());
        update(sqlStringBuilder.toString());
    }

    public void createTable() {
        StringBuilder sqlStringBuilder = new StringBuilder();
        sqlStringBuilder.append("CREATE TABLE seats ").append(" ( ");
        sqlStringBuilder.append("id VARCHAR(10) NOT NULL").append(",");
        sqlStringBuilder.append("PRIMARY KEY (id)");
        sqlStringBuilder.append(" )");
        update(sqlStringBuilder.toString());
    }

    public String buildSQLStatement(String id) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("INSERT INTO seats (id) VALUES ('");
        stringBuilder.append(id).append("')");
        return stringBuilder.toString();
    }


    public void shutdown() {
        try {
            Statement statement = connection.createStatement();
            statement.execute("SHUTDOWN");
            connection.close();
            if (Configuration.instance.isDebug)
                System.out.println("SeatDatabase - isClosed : " + connection.isClosed());
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
        }
    }



    public void importCSVDataSeats(String dataPath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dataPath));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] strings = line.split(";");
                for(String s : strings){
                    update(buildSQLStatement(s));
                }
            }
            if (Configuration.instance.isDebug)
                System.out.println("SeatDatabase - CSV imported ");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public ArrayList<String> getSeats() {
        String query = "SELECT id FROM seats;";
        ArrayList<String> output = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(query);
            while (result.next()) {
                output.add(result.getString("id"));

            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return output;
    }

    public static void main(String[] args) {
        SeatDatabase.getInstance().startup();
        SeatDatabase.getInstance().dropTable();
        SeatDatabase.getInstance().createTable();
        SeatDatabase.getInstance().init();
        SeatDatabase.getInstance().shutdown();
    }

}
