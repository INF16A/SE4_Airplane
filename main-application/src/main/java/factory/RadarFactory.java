package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class RadarFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "radar.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RadarFactory.class.getClassLoader());
            Class radarClass = Class.forName("Radar", true, urlClassLoader);
            Object radarInstance = radarClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = radarClass.getDeclaredField("port").get(radarInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}