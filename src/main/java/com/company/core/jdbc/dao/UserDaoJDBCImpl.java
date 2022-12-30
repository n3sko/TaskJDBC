package com.company.core.jdbc.dao;

import com.company.core.jdbc.model.User;
import com.company.core.jdbc.util.ConnectionManager;

import javax.naming.PartialResultException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {

    }

    private static final String SQL = """
            CREATE TABLE users(id SERIAL primary key,name varchar(100),lastName varchar(100),age integer);
            """;

    private static final String dropSQL= """
            DROP TABLE users
            """;
    private static final String saveUser= """
            INSERT INTO users(name, lastname, age)
            values (?,?,?)
            """;
    private static final String removeById= """
            DELETE from users where id=?;
            """;
    private static final String getAllUsers= """
            SELECT id,name,lastname,age from users;
            """;

    private static final String removeAllUsers= """
            DELETE  FROM users;
            """;
    public void createUsersTable() {
        try (var connection = ConnectionManager.open();
             var prepareStatement = connection.prepareStatement(SQL)) {
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void dropUsersTable() {
        try (var connection = ConnectionManager.open();
        var prepareStatement=connection.prepareStatement(dropSQL)) {
            prepareStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public void saveUser(String name, String lastName, byte age) {
        try (var conection = ConnectionManager.open();
             var prepareStatement=conection.prepareStatement(saveUser)) {
            prepareStatement.setString(1,name);
            prepareStatement.setString(2,lastName);
            prepareStatement.setByte(3,age);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeUserById(long id) {
        try (var connection = ConnectionManager.open();
        var prepareStatement=connection.prepareStatement(removeById)) {
            prepareStatement.setLong(1,id);
            prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<User> getAllUsers() {
        try (var connection = ConnectionManager.open();
        var prepareStatement=connection.prepareStatement(getAllUsers)) {
            var resultSet=prepareStatement.executeQuery();
            List<User>user=new ArrayList<>();
            while (resultSet.next()){
                user.add(buildUser(resultSet));
            }
            return user;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static User buildUser(ResultSet resultSet) throws SQLException {
        return new User(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("lastname"),
                resultSet.getByte("age"));
    }

    public void cleanUsersTable() {
        try (var connection = ConnectionManager.open();
        var prepareStatement=connection.prepareStatement(removeAllUsers)) {
           prepareStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
