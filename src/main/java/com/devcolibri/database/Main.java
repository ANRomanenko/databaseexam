package com.devcolibri.database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Main {

    private final static String URL =
            "jdbc:mysql://localhost:3306/mydbtest";
    private final static String URLFIXED =
            "jdbc:mysql://localhost:3306/mydbtest?useUnicode=true&useSSL=true&useJDBCCompliantTimezoneShift=true" +
                    "&useLegacyDatetimeCode=false&serverTimezone=UTC";
    private final static String USERNAME = "root";
    private final static String PASSWORD = "root";

    public static void main(String[] args) throws SQLException {
        //Connection to database; Соединение с базой данных
        Connection connection;




        Driver driver = new com.mysql.cj.jdbc.Driver();

        DriverManager.registerDriver(driver);

        connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

        /*WARN: Establishing SSL connection without server's identity verification is not recommended.
        According to MySQL 5.5.45+, 5.6.26+ and 5.7.6+ requirements SSL connection must be established by default
        if explicit option isn't set. For compliance with existing applications not using SSL the verifyServerCertificate property is set to 'false'.
        You need either to explicitly disable SSL by setting useSSL=false, or set useSSL=true and provide truststore for server certificate verification.
        Exception in thread "main" java.sql.SQLException:
        The server time zone value 'Russia TZ 2 Standard Time' is unrecognized or represents more than one time zone.
        You must configure either the server or JDBC driver (via the serverTimezone configuration property)
        to use a more specifc time zone value if you want to utilize time zone support.
        http://stackoverflow.com/questions/26515700/mysql-jdbc-driver-5-1-33-time-zone-issue

        при возникновении эксепшена или warninga, пользуемся URLFIXED
*/
        if (!connection.isClosed()) {
            System.out.println("Соединение с БД Установлено!");
        }
        connection.close();
        if (connection.isClosed()) {
            System.out.println("Соединение с БД Закрыто!");
        }
    }
}