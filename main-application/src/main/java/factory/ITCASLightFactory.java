package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class ITCASLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "ITCASLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ITCASLightFactory.class.getClassLoader());
            Class ITCASLightClass = Class.forName("ITCASLight", true, urlClassLoader);
            Object ITCASLightInstance = ITCASLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = ITCASLightClass.getDeclaredField("port").get(ITCASLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
