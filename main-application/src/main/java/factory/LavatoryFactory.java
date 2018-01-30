package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class LavatoryFactory {
    private LavatoryFactory() {}

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/13_lavatory.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LavatoryFactory.class.getClassLoader());
            Class lavatoryClass = Class.forName("Lavatory",true,urlClassLoader);
            Object lavatoryInstance = lavatoryClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = lavatoryClass.getDeclaredField("port").get(lavatoryInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}