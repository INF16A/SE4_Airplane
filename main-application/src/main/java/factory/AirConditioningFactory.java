package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class AirConditioningFactory {
    private AirConditioningFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "airconditioning.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AirConditioningFactory.class.getClassLoader());
            Class airConditioningClass = Class.forName("AirConditioning", true, urlClassLoader);
            Object airConditioningInstance = airConditioningClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = airConditioningClass.getDeclaredField("port").get(airConditioningInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
