package jm.task.core.jdbc.util;

import java.sql.*;


public class Util {
    // реализуйте настройку соеденения с БД

    //private final static String URLFIXED =
    //        "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
    //                "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private static final String HOST = "jdbc:mysql://localhost:3306/testdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12344321";
    private static Connection connection;
    private static Driver driver;//FabricMySQLDriver()
    //private static Statement statement;
    //private static Util util;
    private Util() throws SQLException {
        //if(connection == null || connection.isClosed()) {
            driver = DriverManager.getDriver(HOST);
            DriverManager.registerDriver(driver);
            connection = DriverManager.getConnection(HOST, USERNAME, PASSWORD);
            System.out.println("Соединение с БД Установлено!");
        //}if(util == nu)
    }
    private static void instance() throws SQLException {
        if(connection == null || connection.isClosed()) new Util();
    }

    public static Connection getConnection() throws SQLException {
        instance();
        return connection;
    }
    /*public static Statement getStatement(){
        getConnection();
        if (statement == null) {
            try {
                if(!getConnection().isClosed()) statement = connection.createStatement();
                //System.out.println(statement.isClosed());
                System.out.println("Заявка открыта");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return statement;
    }*/
}
