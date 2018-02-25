package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class CostOptimizerFactory {
    private CostOptimizerFactory() {
    }

    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "costoptimizer.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, CostOptimizerFactory.class.getClassLoader());
            Class costOptimizerClass = Class.forName("CostOptimizer", true, urlClassLoader);
            Object costOptimizerInstance = costOptimizerClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = costOptimizerClass.getDeclaredField("port").get(costOptimizerInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
