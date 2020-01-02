package com.mno.dao;


import com.mno.util.BeanUtil;
import com.mno.util.MyDbUtil;

import java.lang.reflect.ParameterizedType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 10418
 * @date 2020-01-01
 */
public class BaseDao<T> {
    private Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];

    public int iud(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement statement = null;
        int count = 0;
        try {
            conn = MyDbUtil.getConnection();
            statement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            count = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(conn, statement, null);
        }
        return count;
    }

    public <T> T getOneData(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        T entity = null;
        try {
            conn = MyDbUtil.getConnection();
            stat = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stat.setObject(i + 1, args[i]);
            }
            rs = stat.executeQuery();
            if (rs.next()) {
                entity = (T) entityClass.getDeclaredConstructor().newInstance();
                ResultSetMetaData rsmd = rs.getMetaData();
                int columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String key = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(key);
                    BeanUtil.setProperty(entity, key, value);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(conn, stat, rs);
        }
        return entity;
    }

    public <T> List<T> getListData( String sql, Object... args) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        T entity = null;
        ResultSetMetaData rsmd = null;
        int columnCount = 0;
        List<T> list = new ArrayList<>();
        try {
            conn = MyDbUtil.getConnection();
            stat = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stat.setObject(i + 1, args[i]);
            }
            rs = stat.executeQuery();
            while (rs.next()) {
                entity = (T) entityClass.getDeclaredConstructor().newInstance();
                rsmd = rs.getMetaData();
                columnCount = rsmd.getColumnCount();
                for (int i = 1; i <= columnCount; i++) {
                    String key = rsmd.getColumnLabel(i);
                    Object value = rs.getObject(key);
                    BeanUtil.setProperty(entity, key, value);
                }
                list.add(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(conn, stat, rs);
        }
        return list;

    }

    public Object getOneColumn(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        Object result = null;
        try {
            conn = MyDbUtil.getConnection();
            stat = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stat.setObject(i + 1, args[i]);
            }
            rs = stat.executeQuery();
            if (rs.next()) {
                result = rs.getObject(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(conn, stat, rs);
        }
        return result;
    }

    public Blob getBlob(String sql, Object... args) {

        Connection conn = null;
        PreparedStatement stat = null;
        ResultSet rs = null;
        Blob result = null;
        try {
            conn = MyDbUtil.getConnection();
            stat = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                stat.setObject(i + 1, args[i]);
            }
            rs = stat.executeQuery();
            if (rs.next()) {
                result = rs.getBlob(1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(conn, stat, rs);
        }
        return result;
    }


    public int iud(Connection conn, String sql, Object... args) {
        PreparedStatement statement = null;
        int count = 0;
        try {
            statement = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                statement.setObject(i + 1, args[i]);
            }
            count = statement.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            MyDbUtil.close(null, statement, null);
        }
        return count;
    }
}
