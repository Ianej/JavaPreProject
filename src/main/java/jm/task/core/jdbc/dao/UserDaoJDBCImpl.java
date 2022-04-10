package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        String query = "CREATE TABLE IF NOT EXISTS `users` (" +
                "`id` BIGINT NOT NULL AUTO_INCREMENT," +
                "`name` VARCHAR(45) NOT NULL," +
                "`lastName` VARCHAR(45) NOT NULL," +
                "`age` INT(3) NOT NULL," +
                "PRIMARY KEY (`id`));" /*+
                "ENGINE = InnoDB;" +
                "DEFAULT CHARACTER SET = utf8;"*/;
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        String query = "DROP TABLE IF EXISTS users;";
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        String query = "insert into users (name, lastname, age) values (?,?,?);";
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            pStatement.setString(1, name);
            pStatement.setString(2, lastName);
            pStatement.setInt(3, age);
            pStatement.executeUpdate();
            System.out.println("User с именем – " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        String query = "delete from users where id = ?;";
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            pStatement.setLong(1, id);
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        String query = "select * from users;";
        List<User> list = new ArrayList<>();
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            ResultSet rs = pStatement.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString("name"), rs.getString("lastName"), rs.getByte("age")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void cleanUsersTable() {
        String query = "delete from users;";
        try (PreparedStatement pStatement = Util.getConnection().prepareStatement(query);) {
            pStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
