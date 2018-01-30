package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PitotTubeFactory {

    public static Object build() {
        Object componentPort = null;
        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/pitottube.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, PitotTubeFactory.class.getClassLoader());
            Class pitotTubeClass = Class.forName("PitotTube", true, urlClassLoader);
            Object pitotTubeInstance = pitotTubeClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = pitotTubeClass.getDeclaredField("port").get(pitotTubeInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }

}
