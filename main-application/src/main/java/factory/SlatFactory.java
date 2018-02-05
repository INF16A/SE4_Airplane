package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class SlapFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "../../../../components/Slap/build/slap.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, SlapFactory.class.getClassLoader());
            Class slapClass = Class.forName("Slap", true, urlClassLoader);
            Object droopNoseInstance = slapClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = slapClass.getDeclaredField("port").get(droopNoseInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }
}