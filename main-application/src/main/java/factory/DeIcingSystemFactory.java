package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class DeIcingSystemFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/deicingsystem.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, DeIcingSystemFactory.class.getClassLoader());
            Class fuelTankClass = Class.forName("DeIcingSystem",true,urlClassLoader);
            Object fuelTankInstance = fuelTankClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = fuelTankClass.getDeclaredField("port").get(fuelTankInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
