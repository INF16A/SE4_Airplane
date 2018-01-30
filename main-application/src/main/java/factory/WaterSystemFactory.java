package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class WaterSystemFactory {
    private WaterSystemFactory() {}

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/13_watersystem.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, WaterSystemFactory.class.getClassLoader());
            Class waterSystemClass = Class.forName("WasteSystem",true,urlClassLoader);
            Object waterSystemInstance = waterSystemClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = waterSystemClass.getDeclaredField("port").get(waterSystemInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}