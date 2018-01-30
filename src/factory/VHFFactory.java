package factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class VHFFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/vhf.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RadarFactory.class.getClassLoader());
            Class vhfClass = Class.forName("VHF",true,urlClassLoader);
            Object vhfInstance = vhfClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = vhfClass.getDeclaredField("port").get(vhfInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
