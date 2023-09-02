package com.thejobslk.dao.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbDriverManagerMySQLImpl implements DbDriverManager {

  public DbDriverManagerMySQLImpl() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver"); // com.mysql.jdbc.Driver - DEPRECATED

    String url = "jdbc:mysql://127.0.0.1:3306/thejobslk";
    String username = "root";
    String password = "r00t";
    // ALTERNATIVELY - Can be used as configs as well.

    return DriverManager.getConnection(url, username, password);
  }

}
