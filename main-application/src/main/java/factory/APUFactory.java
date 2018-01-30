package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by Lenovo on 30.01.2018.
 */
public class APUFactory {

    //Untested!

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/apu.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EngineFactory.class.getClassLoader());
            Class apuClass = Class.forName("APU", true, urlClassLoader);
            Object apuInstance = apuClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = apuClass.getDeclaredField("port").get(apuInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }


}
