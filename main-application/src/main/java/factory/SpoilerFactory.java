package factory;

import configuration.Configuration;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class SpoilerFactory {

    public static Object build(String id, String manufacturer, String type) {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "spoiler.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SpoilerFactory.class.getClassLoader());
            Class spoilerClass = Class.forName("Spoiler", true, urlClassLoader);
            Object spoilerInstance = spoilerClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = spoilerClass.getDeclaredField("port").get(spoilerInstance);

            Method setId = componentPort.getClass().getMethod("setId", String.class);
            setId.invoke(componentPort, id);

            Method setManufacturer = componentPort.getClass().getMethod("setManufacturer", String.class);
            setManufacturer.invoke(componentPort, manufacturer);

            Method setType = componentPort.getClass().getMethod("setType", String.class);
            setType.invoke(componentPort, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
