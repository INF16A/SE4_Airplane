package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class DefaultFactory {
    public static Object build(String jarName, String className) {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + jarName).toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, DefaultFactory.class.getClassLoader());
            Class clazz = Class.forName(className,true,urlClassLoader);
            Object instance = clazz.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = clazz.getDeclaredField("port").get(instance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
