package factory;

import configuration.Configuration;

import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by npor1112 on 30.01.2018.
 */
public class SeatManagementFactory {
    public static Object build() {
        return DefaultFactory.build("seatmanagement.jar", "SeatManagement");
    }
}
