package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class GearFactory {

    //Untested!

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "gear.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EngineFactory.class.getClassLoader());
            Class gearClass = Class.forName("Gear", true, urlClassLoader);
            Object gearInstance = gearClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = gearClass.getDeclaredField("port").get(gearInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
