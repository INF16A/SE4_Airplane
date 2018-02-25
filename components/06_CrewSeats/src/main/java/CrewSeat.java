import java.lang.reflect.Method;

public class CrewSeat {

    public Port port;
    private static CrewSeat instance = new CrewSeat();

    private String manifacturer = "Recaro";
    private String type = "CrewSeat";
    private String id;

    private CrewSeat(){
        port = new Port();
    }

    public static CrewSeat getInstance(){
        return instance;
    }

    public class Port implements ICrewSeat{
        private Method[] methods = getClass().getMethods();

        public String version(){
            return innerMethodVersion();
        }
        public boolean readingLightOn(){
            return innerMethodReadingLightOn();
        }
        public boolean readingLightOff() {
            return innerMethodReadingLightOff();
        }
        public String getManifacturer(){
            return innerMethodGetManifacturer();
        }
        public String getType(){
            return innerMethodGetType();
        }
        public String getId(){
            return innerMethodGetId();
        }
        public void setId(String id){
            innerMethodSetId(id);
        }
    }

    private String innerMethodGetManifacturer(){
        return manifacturer;
    }

    private String innerMethodGetType(){
        return type;
    }

    private String innerMethodGetId(){
        return id;
    }

    private void innerMethodSetId(String id){
        this.id = id;
    }

    private String innerMethodVersion(){
        return type + " - " + manifacturer;
    }

    private boolean innerMethodReadingLightOff(){
        return false;
    }

    private boolean innerMethodReadingLightOn(){
        return true;
    }
}
