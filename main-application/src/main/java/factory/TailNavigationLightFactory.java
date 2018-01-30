package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TailNavigationLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "TailNavigationLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, TailNavigationLightFactory.class.getClassLoader());
            Class TailNavigationLightClass = Class.forName("TailNavigationLight", true, urlClassLoader);
            Object TailNavigationLightInstance = TailNavigationLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = TailNavigationLightClass.getDeclaredField("port").get(TailNavigationLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
