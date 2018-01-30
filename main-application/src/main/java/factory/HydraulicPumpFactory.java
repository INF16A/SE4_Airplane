package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class HydraulicPumpFactory {

    //Untested!

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/hydraulicpump.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EngineFactory.class.getClassLoader());
            Class hydraulicPumpClass = Class.forName("HydraulicPump", true, urlClassLoader);
            Object engineInstance = hydraulicPumpClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = hydraulicPumpClass.getDeclaredField("port").get(engineInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }


}
