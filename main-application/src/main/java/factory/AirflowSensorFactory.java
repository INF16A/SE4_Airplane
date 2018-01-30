package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class AirflowSensorFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(new File(new File(Configuration.instance.commonPathToJavaArchive).getParent()).getParent() +
                    Configuration.instance.fileSeparator + "components" +
                    Configuration.instance.fileSeparator + "airflowsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AirflowSensorFactory.class.getClassLoader());
            System.out.println(urls[0].getPath());
            Class airFlowSensorClass = Class.forName("AirflowSensor", true, urlClassLoader);
            Object airFlowSensorInstance = airFlowSensorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = airFlowSensorClass.getDeclaredField("port").get(airFlowSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
