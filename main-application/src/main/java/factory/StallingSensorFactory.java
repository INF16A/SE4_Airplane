package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class StallingSensorFactory {
    private StallingSensorFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "stallingsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, StallingSensorFactory.class.getClassLoader());
            Class clazz = Class.forName("StallingSensor", true, urlClassLoader);
            Object instance = clazz.getMethod("getInstance", new Class[0]).invoke(null);
            componentPort = clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
