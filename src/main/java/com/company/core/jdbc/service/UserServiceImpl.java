package com.company.core.jdbc.service;

import com.company.core.jdbc.model.User;
import java.util.List;

// TODO: 08.01.2023 Где реализация методов сервисного слоя?
// TODO: 08.01.2023 В сервисном слое мы должны оперировать DAO слоем (DAO слой непосредственно представляет функционал работы с БД)
public class UserServiceImpl implements UserService {
    
    public void createUsersTable() {

    }

    public void dropUsersTable() {

    }

    public void saveUser(String name, String lastName, byte age) {

    }

    public void removeUserById(long id) {

    }

    public List<User> getAllUsers() {
        return null;
    }

    public void cleanUsersTable() {

    }
}
