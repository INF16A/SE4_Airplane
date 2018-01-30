package factory;

import configuration.Configuration;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class LeftAileronFactory {

    public static Object build(String id, String manufacturer, String type) {
        Object componentPort = null;

        try {
            URL[] urls = { new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "leftaileron.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, LeftAileronFactory.class.getClassLoader());
            Class leftAileronClass = Class.forName("LeftAileron",true,urlClassLoader);
            Object leftAileronInstance = leftAileronClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = leftAileronClass.getDeclaredField("port").get(leftAileronInstance);

            Method setId = componentPort.getClass().getMethod("setId", String.class);
            setId.invoke(componentPort, id);

            Method setManufacturer = componentPort.getClass().getMethod("setManufacturer", String.class);
            setManufacturer.invoke(componentPort, manufacturer);

            Method setType = componentPort.getClass().getMethod("setType", String.class);
            setType.invoke(componentPort, type);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }

}
