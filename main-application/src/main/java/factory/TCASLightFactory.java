package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TCASLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "TCASLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, TCASLightFactory.class.getClassLoader());
            Class TCASLightClass = Class.forName("TCASLight", true, urlClassLoader);
            Object TCASLightInstance = TCASLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = TCASLightClass.getDeclaredField("port").get(TCASLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
