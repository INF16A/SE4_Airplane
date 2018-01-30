package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class AirFlowSensorFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/airflowsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AirFlowSensorFactory.class.getClassLoader());
            Class airFlowSensorClass = Class.forName("Airflowsensor",true,urlClassLoader);
            Object airFlowSensorInstance = airFlowSensorClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = airFlowSensorClass.getDeclaredField("port").get(airFlowSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
