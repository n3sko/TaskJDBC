package com.company.core.jdbc;

import com.company.core.jdbc.model.User;
import com.company.core.jdbc.service.UserService;
import com.company.core.jdbc.service.UserServiceImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // реализуйте алгоритм здесь
        UserService userService = new UserServiceImpl();

        userService.dropUsersTable();
        System.out.println("Отработал dropUsersTable");

        userService.createUsersTable();
        System.out.println("Отработал createUsersTable");

        byte age = 27;
        userService.saveUser("Andrey", "Demikov", age);
        System.out.println("Отработал saveUser");

        userService.removeUserById(1);
        System.out.println("Отработал removeUserById");

        List<User> users = userService.getAllUsers();
        System.out.println("Отработал getAllUsers");

        userService.cleanUsersTable();
        System.out.println("Отработал cleanUsersTable");
    }
}
