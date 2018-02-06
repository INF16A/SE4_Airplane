package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class OxygenSensorFactory {
    private OxygenSensorFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "oxygensensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, OxygenSensorFactory.class.getClassLoader());
            Class clazz = Class.forName("OxygenSensor", true, urlClassLoader);
            Object instance = clazz.getMethod("getInstance", new Class[0]).invoke(null);
            componentPort = clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
