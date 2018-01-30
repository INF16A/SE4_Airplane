package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PotableWaterTankFactory {
	public static Object build() {
		Object componentPort = null;

		try {
			URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/potablewatertank.jar").toURI().toURL()};
			URLClassLoader urlClassLoader = new URLClassLoader(urls, PotableWaterTankFactory.class.getClassLoader());
			Class potableWaterTankClass = Class.forName("PotableWaterTank",true,urlClassLoader);
			Object potableWaterTankInstance = potableWaterTankClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
			componentPort = potableWaterTankClass.getDeclaredField("port").get(potableWaterTankInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return componentPort;
	}
}
