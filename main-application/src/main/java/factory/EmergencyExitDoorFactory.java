package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class EmergencyExitDoorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "EmergencyExitDoor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EmergencyExitDoorFactory.class.getClassLoader());
            Class EmergencyExitDoorClass = Class.forName("EmergencyExitDoor", true, urlClassLoader);
            Object EmergencyExitDoorInstance = EmergencyExitDoorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = EmergencyExitDoorClass.getDeclaredField("port").get(EmergencyExitDoorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
