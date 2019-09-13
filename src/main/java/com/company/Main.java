package com.company;

import com.company.app.system.BankApplication;
import com.company.platform.Application;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {
    private static String className;
    private static String appTitle;

    public static void main(String[] args) {
        Application app = new BankApplication();

        app.run(args);
    }



    private static Application init(String className) {
        Object o;
        try {
            Class clazz = Class.forName(className);
            o = clazz.newInstance();
            return (Application)o;
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static Application init(String className, String title) {
        Application a = init(className);

        if(a != null) {
            try {
                Method setTitleMethod = a.getClass().getMethod("setTitle", String.class);
                if(setTitleMethod != null) {
                    setTitleMethod.invoke(a, appTitle);
                    // a.setTitle(appTitle)
                }
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

        return a;
    }
}
