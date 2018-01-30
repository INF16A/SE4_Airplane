package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class GenericFactory {
    @SuppressWarnings("unchecked")
    public static Object buildObjectByClassName(String className) {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/" + className.toLowerCase() + ".jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, GenericFactory.class.getClassLoader());
            Class clazz = Class.forName(className,true,urlClassLoader);
            Object instance = clazz.getMethod("getInstance").invoke(null);
            componentPort = clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
