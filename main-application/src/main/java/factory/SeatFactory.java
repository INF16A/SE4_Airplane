package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class SeatFactory {
	
    public static Object buildCrewSeat() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/crewseat.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SeatFactory.class.getClassLoader());
            Class crewSeatClass = Class.forName("CrewSeat",true,urlClassLoader);
            Object crewSeatInstance = crewSeatClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = crewSeatClass.getDeclaredField("port").get(crewSeatInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
	
	public static Object buildTouristSeat() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/touristclassseat.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SeatFactory.class.getClassLoader());
            Class touristSeatClass = Class.forName("TouristClassSeat",true,urlClassLoader);
            Object touristSeatInstance = touristSeatClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = touristSeatClass.getDeclaredField("port").get(crewSeatInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
	
	public static Object buildBusinessSeat() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/businessclassseat.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SeatFactory.class.getClassLoader());
            Class businessSeatClass = Class.forName("BusinessClassSeat",true,urlClassLoader);
            Object businessSeatInstance = businessSeatClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = businessSeatClass.getDeclaredField("port").get(businessSeatInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
	
	public static Object buildFirstSeat() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/firstclassseat.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SeatFactory.class.getClassLoader());
            Class firstSeatClass = Class.forName("FirstClassSeat",true,urlClassLoader);
            Object firstSeatInstance = firstSeatClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = firstSeatClass.getDeclaredField("port").get(firstSeatInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}
