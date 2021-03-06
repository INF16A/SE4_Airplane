package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class APUOilTankFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "apuoiltank.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, APUOilTankFactory.class.getClassLoader());
            Class fuelTankClass = Class.forName("APUOilTank", true, urlClassLoader);
            Object fuelTankInstance = fuelTankClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = fuelTankClass.getDeclaredField("port").get(fuelTankInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
