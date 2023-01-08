package com.company.core.jdbc.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final Properties PROPERTIES = new Properties();

    static {
        loadProperties();
    }

    public Util() {
    }

    public static String getProperty(String key) {
        return PROPERTIES.getProperty(key);
    }

    private static void loadProperties() {
        try (InputStream inputStream = Util.class.getClassLoader().getResourceAsStream("application.properties")) {
            PROPERTIES.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}