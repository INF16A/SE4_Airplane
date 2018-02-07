public enum Configuration {
    instance;

    boolean isDebug = true;

    public String lineSeparator = System.getProperty("line.separator");
    public String fileSeparator = System.getProperty("file.separator");
    public String userDirectory = System.getProperty("user.dir");
    public String logFile = userDirectory + fileSeparator + "log" + fileSeparator + "persistence.log";
    public String dataPath = userDirectory + fileSeparator + "data" + fileSeparator;
    public String dataDirectory = userDirectory + fileSeparator + "data" + fileSeparator;
    public String databaseFile = dataDirectory + "flightRecorderA380.db";
    public String passengerArchive = dataDirectory + "passenger.csv";
    public String seatsArchive = dataDirectory + "seat_configuration_A380.csv";
}