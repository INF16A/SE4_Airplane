package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class AirflowSensorFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "airflowsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AirflowSensorFactory.class.getClassLoader());
            System.out.println(urls[0].getPath());
            Class airFlowSensorClass = Class.forName("AirflowSensor", true, urlClassLoader);
            Object airFlowSensorInstance = airFlowSensorClass.getMethod("getInstance").invoke(null);
            componentPort = airFlowSensorClass.getDeclaredField("port").get(airFlowSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
