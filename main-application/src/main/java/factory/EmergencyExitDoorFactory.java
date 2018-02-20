package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class EmergencyExitDoorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "EmergencyDoor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EmergencyExitDoorFactory.class.getClassLoader());
            Class EmergencyDoorClass = Class.forName("EmergencyDoor", true, urlClassLoader);
            Object EmergencyDoorInstance = EmergencyDoorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = EmergencyDoorClass.getDeclaredField("port").get(EmergencyDoorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
