package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД
    private static final String HOST = "jdbc:mysql://localhost:3306/testdb";//? useTimezone = true & serverTimezone = UTC
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12344321";

    private static SessionFactory sessionFactory;
    static {
        Configuration cfg = new Configuration()
                .setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver")
                .setProperty("hibernate.connection.url", HOST)
                .setProperty("hibernate.connection.username", USERNAME)
                .setProperty("hibernate.connection.password", PASSWORD)
                .setProperty("dialect", "org.hibernate.dialect.MySQL8Dialect")
                .setProperty("hibernate.c3p0.min_size", "5")
                .setProperty("hibernate.c3p0.max_size", "20")
                .setProperty("hibernate.c3p0.timeout", "1800")
                .setProperty("hibernate.c3p0.max_statements", "50")
                .setProperty("show_sql", "true")
                .addAnnotatedClass(User.class);
        sessionFactory = cfg.buildSessionFactory();
    }
    public static Session session;
    private Util() {
        session = sessionFactory.openSession();
    }
    private static void instance() throws SQLException {
        if(session == null || !session.isOpen()) new Util();
        System.out.println(session.isConnected() ? "Установлено!" : "Не установлено!");
    }

    public static Session getSession() throws SQLException{
        System.out.println("Hibernate cоединение с БД..." );
        instance();
        return session;
    }

    public static Connection getConnection() {
        return null;
    }
}
