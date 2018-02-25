package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ElevatorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(configuration.Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "elevator.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ElevatorFactory.class.getClassLoader());
            Class elevatorFactoryClass = Class.forName("Elevator", true, urlClassLoader);
            Object elevatorFactoryInstance = elevatorFactoryClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = elevatorFactoryClass.getDeclaredField("port").get(elevatorFactoryInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}
