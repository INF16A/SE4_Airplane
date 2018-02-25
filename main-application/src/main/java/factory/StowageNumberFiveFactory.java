package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class StowageNumberFiveFactory {
	public static Object build() {
		Object componentPort = null;

		try {
			URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "stowagenumberfive.jar").toURI().toURL()};
			URLClassLoader urlClassLoader = new URLClassLoader(urls, StowageNumberFiveFactory.class.getClassLoader());
			Class stowageNumberFiveClass = Class.forName("StowageNumberFive",true,urlClassLoader);
			Object stowageNumberFiveInstance = stowageNumberFiveClass.getMethod("getInstance",new Class[0]).invoke(null,new Object[0]);
			componentPort = stowageNumberFiveClass.getDeclaredField("port").get(stowageNumberFiveInstance);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return componentPort;
	}
}
