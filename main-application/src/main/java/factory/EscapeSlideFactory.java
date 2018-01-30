package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class EscapeSlideFactory {
    private EscapeSlideFactory() {}

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/escapeslide.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, EscapeSlideFactory.class.getClassLoader());
            Class escapeSlideClass = Class.forName("EscapeSlide",true,urlClassLoader);
            Object escapeSlideInstance = escapeSlideClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
            componentPort = escapeSlideClass.getDeclaredField("port").get(escapeSlideInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
