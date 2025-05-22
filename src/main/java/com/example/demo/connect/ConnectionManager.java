package com.example.demo.connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
    private static final String URL_MASTER = "jdbc:sqlserver://DESKTOP-BQB1VDP:1433;databaseName=QL_CCU;user=sa;password=123456;";
    private static final String URL_REPLICA1 = "jdbc:sqlserver://DESKTOP-BQB1VDP\\CHINHANHHCM:1433;databaseName=QL_CCU;user=sa;password=123456;";
    private static final String URL_REPLICA2 = "jdbc:sqlserver://DESKTOP-BQB1VDP\\CHINHANHHN:1433;databaseName=QL_CCU;user=sa;password=123456;";
    private static final String URL_REPORTING = "jdbc:sqlserver://DESKTOP-BQB1VDP\\KHOVANV:1433;databaseName=QL_CCU;user=sa;password=123456;";

    public static Connection getMasterConnection() throws SQLException {
        return DriverManager.getConnection(URL_MASTER);
    }

    public static Connection getReplica1Connection() throws SQLException {
        return DriverManager.getConnection(URL_REPLICA1);
    }

    public static Connection getReplica2Connection() throws SQLException {
        return DriverManager.getConnection(URL_REPLICA2);
    }

    public static Connection getReportingConnection() throws SQLException {
        return DriverManager.getConnection(URL_REPORTING);
    }
}
