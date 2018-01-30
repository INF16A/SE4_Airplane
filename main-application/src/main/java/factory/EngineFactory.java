package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/apu.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EngineFactory.class.getClassLoader());
            Class weatherRadarClass = Class.forName("APU", true, urlClassLoader);
            Object weatherRadarInstance = weatherRadarClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = weatherRadarClass.getDeclaredField("port").get(weatherRadarInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }


}
