package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ExhaustGasTemperatureSensorFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/exhaustgastemperaturesensor.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, ExhaustGasTemperatureSensorFactory.class.getClassLoader());
            Class exhaustGasTemperatureSensorClass = Class.forName("APUOilTank", true, urlClassLoader);
            Object exhaustGasTemperatureSensorInstance = exhaustGasTemperatureSensorClass.getMethod("getInstance", new Class[0]).invoke(null, new Object[0]);
            componentPort = exhaustGasTemperatureSensorClass.getDeclaredField("port").get(exhaustGasTemperatureSensorInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}
