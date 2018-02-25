package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CargoSystemFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "cargosystem.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CargoSystemFactory.class.getClassLoader());
            Class cargoSystemClass = Class.forName("CargoSystem",true,urlClassLoader);
            Object cargoSystemInstance = cargoSystemClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = cargoSystemClass.getDeclaredField("port").get(cargoSystemInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
