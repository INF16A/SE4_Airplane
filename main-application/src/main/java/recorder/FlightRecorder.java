// please do not modify

package recorder;


import configuration.Configuration;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

public enum FlightRecorder {
    instance;

    private Object object;

    FlightRecorder() {
        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "persistence.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, FlightRecorder.class.getClassLoader());

            Class clazz = Class.forName("FlightRecorder", true, urlClassLoader);
            object = clazz.getMethod("getInstance").invoke(null);
        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void startup() {
        try {
            Method method = object.getClass().getMethod("startup");
            method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void init() {
        dropTable();
        createTable();
    }

    public synchronized void update(String sqlStatement) {
        Method method = null;
        try {
            method = object.getClass().getMethod("update", String.class);
            method.invoke(object, sqlStatement);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void dropTable() {
        try {
            Method method = object.getClass().getMethod("dropTable");
            method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    public void createTable() {
        try {
            Method method = object.getClass().getMethod("createTable");
            method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    public void insert(String className, String message) {
        Method method = null;
        try {
            method = object.getClass().getMethod("insert", String.class, String.class);
            method.invoke(object, className, message);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


    public void shutdown() {
        try {
            Method method = object.getClass().getMethod("shutdown");
            method.invoke(object);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}