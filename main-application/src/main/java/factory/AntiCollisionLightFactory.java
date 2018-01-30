package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class AntiCollisionLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "AntiCollisionLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, AntiCollisionLightFactory.class.getClassLoader());
            Class AntiCollisionLightClass = Class.forName("AntiCollisionLight", true, urlClassLoader);
            Object AntiCollisionLightInstance = AntiCollisionLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = AntiCollisionLightClass.getDeclaredField("port").get(AntiCollisionLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
