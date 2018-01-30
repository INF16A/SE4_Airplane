package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class KitchenFactory {
    private KitchenFactory() {}

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/kitchen.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, KitchenFactory.class.getClassLoader());
            Class kitchenClass = Class.forName("Kitchen",true,urlClassLoader);
            Object kitchenInstance = kitchenClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = kitchenClass.getDeclaredField("port").get(kitchenInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}