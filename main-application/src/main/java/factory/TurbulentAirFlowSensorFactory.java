package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class TurbulentAirFlowSensorFactory {

    public static Object build() {
        Object componentPort = null;
        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "turbulentairflowsensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, TurbulentAirFlowSensorFactory.class.getClassLoader());
            Class pitotTubeClass = Class.forName("TurbulentAirFlowSensor", true, urlClassLoader);
            Object pitotTubeInstance = pitotTubeClass.getMethod("getInstance").invoke(null);
            componentPort = pitotTubeClass.getDeclaredField("port").get(pitotTubeInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return componentPort;
    }

}
