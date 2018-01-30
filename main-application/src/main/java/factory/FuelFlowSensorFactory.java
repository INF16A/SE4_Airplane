package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class FuelFlowSensorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/fuelflowsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FuelFlowSensorFactory.class.getClassLoader());
            Class fuelFlowSensorClass = Class.forName("APUOilTank", true, urlClassLoader);
            Object fuelFlowSensorInstance = fuelFlowSensorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = fuelFlowSensorClass.getDeclaredField("port").get(fuelFlowSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
