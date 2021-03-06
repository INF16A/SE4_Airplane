package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GPSFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "gps.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, GPSFactory.class.getClassLoader());
            Class gpsClass = Class.forName("GPS", true, urlClassLoader);
            Object gpsInstance = gpsClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = gpsClass.getDeclaredField("port").get(gpsInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
