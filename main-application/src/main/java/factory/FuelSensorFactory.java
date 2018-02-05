package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class FuelSensorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "fuelsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FuelSensorFactory.class.getClassLoader());
            Class fuelSensorClass = Class.forName("FuelSensor", true, urlClassLoader);
            Object fuelSensorInstance = fuelSensorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = fuelSensorClass.getDeclaredField("port").get(fuelSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
