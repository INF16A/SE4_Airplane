package java.factory;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;
import configuration.Configuration;

public class CameraFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/camera.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CameraFactory.class.getClassLoader());
            Class cameraClass = Class.forName("Camera",true,urlClassLoader);
            Object cameraInstance = cameraClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = cameraClass.getDeclaredField("port").get(cameraInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
