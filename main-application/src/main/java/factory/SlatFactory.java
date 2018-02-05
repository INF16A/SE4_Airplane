package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class SlatFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "slat.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SlatFactory.class.getClassLoader());
            Class slatClass = Class.forName("Slat", true, urlClassLoader);
            Object droopNoseInstance = slatClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = slatClass.getDeclaredField("port").get(droopNoseInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}