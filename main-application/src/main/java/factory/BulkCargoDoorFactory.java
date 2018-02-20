package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class BulkCargoDoorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "BulkCargoDoor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, BulkCargoDoorFactory.class.getClassLoader());
            Class bulkCargoDoorFactoryClass = Class.forName("BulkCargoDoor", true, urlClassLoader);
            Object bulkCargoDoorInstance = bulkCargoDoorFactoryClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = bulkCargoDoorFactoryClass.getDeclaredField("port").get(bulkCargoDoorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
