package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class SlatFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "../../../../components/Slat/build/slap.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SlatFactory.class.getClassLoader());
            Class slatClass = Class.forName("Slat", true, urlClassLoader);
            Object slatInstance = slatClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = slatClass.getDeclaredField("port").get(slatInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}