package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class OxygenBottleFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "oxygenbottle.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, OxygenBottleFactory.class.getClassLoader());
            Class oxygenBottleClass = Class.forName("OxygenBottle", true, urlClassLoader);
            Object oxygenBottleInstance = oxygenBottleClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = oxygenBottleClass.getDeclaredField("port").get(oxygenBottleInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
