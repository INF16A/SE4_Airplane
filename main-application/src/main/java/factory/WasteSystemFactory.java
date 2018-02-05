package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class WasteSystemFactory {
    private WasteSystemFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "wastesystem.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LavatoryFactory.class.getClassLoader());
            Class wasteSystemClass = Class.forName("WasteSystem", true, urlClassLoader);
            Object wasteSystemInstance = wasteSystemClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = wasteSystemClass.getDeclaredField("port").get(wasteSystemInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}