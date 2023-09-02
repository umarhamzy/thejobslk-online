package com.thejobslk.dao.dbutil;

// Implementation of Factory class
public class DbDriverManagerFactory {

  public DbDriverManager getDbDriver(String database) {
    if (database.equals("MySQL")) {
      return new DbDriverManagerMySQLImpl();
    } else {
      return null;
    }
  }

}
