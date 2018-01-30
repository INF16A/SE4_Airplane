package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class EngineFactory {

    //Untested!

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/engine.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EngineFactory.class.getClassLoader());
            Class engineClass = Class.forName("Engine", true, urlClassLoader);
            Object engineInstance = engineClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = engineClass.getDeclaredField("port").get(engineInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }


}
