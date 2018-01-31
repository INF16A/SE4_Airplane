package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class LandingLightFactory {

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "LandingLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LandingLightFactory.class.getClassLoader());
            Class LandingLightClass = Class.forName("LandingLight", true, urlClassLoader);
            Object LandingLightInstance = LandingLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = LandingLightClass.getDeclaredField("port").get(LandingLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
