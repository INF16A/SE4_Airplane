package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class SatComFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "satcom.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SatComFactory.class.getClassLoader());
            Class satComClass = Class.forName("SatCom",true,urlClassLoader);
            Object satComInstance = satComClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = satComClass.getDeclaredField("port").get(satComInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
