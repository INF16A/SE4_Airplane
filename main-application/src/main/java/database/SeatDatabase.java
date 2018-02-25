package database;

import configuration.Configuration;


import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

public enum SeatDatabase {
    instance;

    private Object object;

    SeatDatabase() {
        try {
            URL[] urls = {new File(Configuration.instance.commonPathToJavaArchive + Configuration.instance.fileSeparator + "persistence.jar").toURI().toURL()};
            URLClassLoader urlClassLoader = new URLClassLoader(urls, recorder.FlightRecorder.class.getClassLoader());

            Class clazz = Class.forName("SeatDatabase", true, urlClassLoader);
            object = clazz.getMethod("getInstance").invoke(null);


        } catch (Exception e) {
            System.out.println("--- exception");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public ArrayList<String> getSeats() {
        ArrayList<String> seats = new ArrayList<>();
        try {
            Method method = object.getClass().getMethod("getSeats");
            seats = (ArrayList<String>) method.invoke(object);
        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return seats;
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
        try {
            Method method = object.getClass().getMethod("init");
            method.invoke(object);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
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

    public void shutdown() {
        try {
            Method method = object.getClass().getMethod("shutdown");
            method.invoke(object);

        } catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
    }


}
