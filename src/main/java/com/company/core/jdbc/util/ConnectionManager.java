package com.company.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {

    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";

    // TODO: 08.01.2023 Конструктор должен быть привытным (ConnectionManager - singletone, единственный для всей программы)
    public ConnectionManager() {
    }

    // TODO: 08.01.2023 Можно переписать более лаконично см пример
//    public static Connection open() {
//        try {
//            return DriverManager.getConnection(
//                    PropertiesUtil.get(URL_KEY),
//                    PropertiesUtil.get(USER_KEY),
//                    PropertiesUtil.get(PASSWORD_KEY)
//            );
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
    public static Connection open() {
        Connection con;
        try {
            return con = DriverManager.getConnection(Util.getProperty(URL_KEY), Util.getProperty(USER_KEY), Util.getProperty(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
