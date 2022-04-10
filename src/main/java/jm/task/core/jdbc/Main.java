package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserService;
import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws SQLException{
        // реализуйте алгоритм здесь
        Connection connection = Util.getConnection();
        //Statement statement = Util.getStatement();
        UserService userService = new UserServiceImpl();
        String[] name = {"Иван", "Пётр", "Сидор", "Фёдор"};
        String[] lastName = {"Иванов", "Петров", "Сидоров", "Фёдоров"};
        Random rnd = new Random();
        for (int i = 0; i < 4; i++) {
            userService.saveUser(name[rnd.nextInt(4)], lastName[rnd.nextInt(4)], (byte) rnd.nextInt(120));
        }
        List<User> users = userService.getAllUsers();
        for (User u: users) {
            System.out.println(u);
        }
        userService.cleanUsersTable();
        userService.dropUsersTable();
        try {
            connection.close();
            System.out.println("Соединение с БД Закрыто!");
            //statement.close();
            //System.out.println("Заявка закрыта");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
