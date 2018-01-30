package factory;

import configuration.Configuration;

import java.io.File;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public class RudderFactory {

    public static Object build(String id, String manufacturer, String type) {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/rudder.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RudderFactory.class.getClassLoader());
            Class rudderClass = Class.forName("Rudder",true,urlClassLoader);
            Object rudderInstance = rudderClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = rudderClass.getDeclaredField("port").get(rudderInstance);

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
