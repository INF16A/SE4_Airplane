package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class IceDetectorProbeFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive  + Configuration.instance.fileSeparator +"icedetectorprobe.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, IceDetectorProbeFactory.class.getClassLoader());
            Class iceDetectorProbeClass = Class.forName("IceDetectorProbe", true, urlClassLoader);
            Object iceDetectorProbeInstance = iceDetectorProbeClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = iceDetectorProbeClass.getDeclaredField("port").get(iceDetectorProbeInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
