package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class LogoLightFactory {


    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "LogoLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LogoLightFactory.class.getClassLoader());
            Class LogoLightClass = Class.forName("LogoLight", true, urlClassLoader);
            Object LogoLightInstance = LogoLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = LogoLightClass.getDeclaredField("port").get(LogoLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
