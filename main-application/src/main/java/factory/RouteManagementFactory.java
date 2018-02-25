package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class RouteManagementFactory {

    private RouteManagementFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "routemanagement.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, RouteManagementFactory.class.getClassLoader());
            Class routeManagementClass = Class.forName("RouteManagement", true, urlClassLoader);
            Object routeManagementInstance = routeManagementClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = routeManagementClass.getDeclaredField("port").get(routeManagementInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
