package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class FlapFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "flap.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FlapFactory.class.getClassLoader());
            Class flapClass = Class.forName("Flap", true, urlClassLoader);
            Object droopNoseInstance = flapClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = flapClass.getDeclaredField("port").get(droopNoseInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}