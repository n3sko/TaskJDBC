package com.company.core.jdbc;

import com.company.core.jdbc.dao.UserDao;
import com.company.core.jdbc.dao.UserDaoJDBCImpl;
import com.company.core.jdbc.util.ConnectionManager;

public class Main {
    public static void main(String[] args) {
        // реализуйте алгоритм здесь
        UserDao userDao=new UserDaoJDBCImpl();
        userDao.saveUser("john","ermishin", (byte) 15);
    }
}
