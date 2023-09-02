package com.thejobslk.dao.dbutil;

import java.sql.Connection;
import java.sql.SQLException;

public interface DbDriverManager {
  public Connection getConnection() throws ClassNotFoundException, SQLException;
}
