package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class RightNavigationLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "RightNavigationLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RightNavigationLightFactory.class.getClassLoader());
            Class RightNavigationLightClass = Class.forName("RightNavigationLight", true, urlClassLoader);
            Object RightNavigationLightInstance = RightNavigationLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = RightNavigationLightClass.getDeclaredField("port").get(RightNavigationLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
