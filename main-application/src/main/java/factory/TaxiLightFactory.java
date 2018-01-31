package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Endrit Callaki on 30.01.2018.
 */
public class TaxiLightFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "TaxiLight.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, TaxiLightFactory.class.getClassLoader());
            Class TaxiLightClass = Class.forName("TaxiLight", true, urlClassLoader);
            Object TaxiLightInstance = TaxiLightClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = TaxiLightClass.getDeclaredField("port").get(TaxiLightInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
