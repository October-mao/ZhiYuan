package com.mno.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * @author 10418
 * @date 2018-05-23
 */
public class MyDbUtil {
    public static void main(String[] args) {
        MyDbUtil.getConnection();
    }

    public static Connection getConnection() {
        try {
            Properties pop = new Properties();
            InputStream in = MyDbUtil.class.getClassLoader().getResourceAsStream("jdbc.properties");
            pop.load(in);
            String driverClass = pop.getProperty("class");
            String jdbcUrl = pop.getProperty("url");
            String user = pop.getProperty("user");
            String password = pop.getProperty("password");
            Class.forName(driverClass);
            return DriverManager.getConnection(jdbcUrl, user, password);
        } catch (IOException | SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void close(Connection conn, Statement stat, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (stat != null) {
            try {
                stat.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //开启事务处理
    public static void startTransaction(Connection conn) {
        if (conn != null) {
            try {
                conn.setAutoCommit(false);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //提交事务处理
    public static void commitTransaction(Connection conn) {
        if (conn != null) {
            try {
                conn.commit();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //回滚事务处理
    public static void rollbackTransaction(Connection conn) {
        if (conn != null) {
            try {
                conn.rollback();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
