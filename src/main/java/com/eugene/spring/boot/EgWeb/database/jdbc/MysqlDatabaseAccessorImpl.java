package com.eugene.spring.boot.EgWeb.database.jdbc;

import com.eugene.spring.boot.EgWeb.impl.database.DatabaseAccessorImpl;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MysqlDatabaseAccessorImpl implements DatabaseAccessorImpl {
    DataSource dataSource;
    String jdbcClass;
    Connection conn;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Autowired
    public void setJdbcClass(String jdbcClass){
        this.jdbcClass = jdbcClass;
    }

    @Override
    public boolean isClassValid() {
        try {
            Class.forName(this.jdbcClass);
        } catch (ClassNotFoundException ncdf){
            return false;
        }
        return false;
    }

    @Override
    public Connection getConnection() throws SQLException {
        if(!isClassValid()){
            return null;
        }

        return dataSource.getConnection();
    }

    @Override
    public ResultSet getData() {
        return null;
    }

    @Override
    public long[] executeDML() {
        return new long[0];
    }
}
