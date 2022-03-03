package com.eugene.spring.boot.EgWeb.impl.database;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

public interface DatabaseAccessorImpl {
    boolean isClassValid();

    Connection getConnection() throws SQLException;

    ResultSet getData();
    long[] executeDML();
}
