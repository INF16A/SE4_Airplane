package main.java.factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class NitrogenBottleFactory {
	public static Object build() {
		Object componentPort = null;

		try {
			URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + "/nitrogenbottle.jar").toURI().toURL()};
			URLClassLoader urlClassLoader = new URLClassLoader(urls, NitrogenBottleFactory.class.getClassLoader());
			Class nitrogenBottleClass = Class.forName("NitrogenBottleRefill",true,urlClassLoader);
			Object nitrogenBottleInstance = nitrogenBottleClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
			componentPort = nitrogenBottleClass.getDeclaredField("port").get(nitrogenBottleInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return componentPort;
	}
}
