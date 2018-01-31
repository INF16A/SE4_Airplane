package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class LeftNavigationLightFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "LeftNavigationLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LeftNavigationLightFactory.class.getClassLoader());
            Class LeftNavigationLightClass = Class.forName("LeftNavigationLight", true, urlClassLoader);
            Object LeftNavigationLightInstance = LeftNavigationLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = LeftNavigationLightClass.getDeclaredField("port").get(LeftNavigationLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
