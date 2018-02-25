package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class RadarAltimeterFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "radaraltimeter.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RadarAltimeterFactory.class.getClassLoader());
            Class radarAltimeterClass = Class.forName("RadarAltimeter", true, urlClassLoader);
            Object radarAltimeterInstance = radarAltimeterClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = radarAltimeterClass.getDeclaredField("port").get(radarAltimeterInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
