package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CrewDoorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "CrewDoor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CrewDoorFactory.class.getClassLoader());
            Class CrewDoorClass = Class.forName("CrewDoor", true, urlClassLoader);
            Object CrewDoorInstance = CrewDoorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = CrewDoorClass.getDeclaredField("port").get(CrewDoorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
