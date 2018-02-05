package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class DroopNoseFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "droopnose.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, DroopNoseFactory.class.getClassLoader());
            Class droopNoseClass = Class.forName("DroopNose", true, urlClassLoader);
            Object droopNoseInstance = droopNoseClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = droopNoseClass.getDeclaredField("port").get(droopNoseInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}