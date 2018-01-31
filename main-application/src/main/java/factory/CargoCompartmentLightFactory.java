package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class CargoCompartmentLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "CargoCompartmentLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CargoCompartmentLightFactory.class.getClassLoader());
            Class CargoCompartmentLightClass = Class.forName("CargoCompartmentLight", true, urlClassLoader);
            Object CargoCompartmentLightInstance = CargoCompartmentLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = CargoCompartmentLightClass.getDeclaredField("port").get(CargoCompartmentLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
