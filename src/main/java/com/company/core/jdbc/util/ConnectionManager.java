package com.company.core.jdbc.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class ConnectionManager {
    private static final String USER_KEY = "db.user";
    private static final String PASSWORD_KEY = "db.password";
    private static final String URL_KEY = "db.url";


    public ConnectionManager() {
    }

    public static Connection open() {
        Connection con;
        try {
            return con = DriverManager.getConnection(Util.getProperty(URL_KEY), Util.getProperty(USER_KEY), Util.getProperty(PASSWORD_KEY));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }
}
