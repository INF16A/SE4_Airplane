package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class FireDetectorFactory {
    private FireDetectorFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "firedetector.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FireDetectorFactory.class.getClassLoader());
            Class clazz = Class.forName("FireDetector", true, urlClassLoader);
            Object instance = clazz.getMethod("getInstance", new Class[0]).invoke(null);
            componentPort = clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
