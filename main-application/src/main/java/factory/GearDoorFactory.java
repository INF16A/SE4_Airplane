package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GearDoorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "GearDoor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BulkCargoDoorFactory.class.getClassLoader());
            Class GearDoorClass = Class.forName("GearDoor", true, urlClassLoader);
            Object GearDoorInstance = GearDoorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = GearDoorClass.getDeclaredField("port").get(GearDoorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
