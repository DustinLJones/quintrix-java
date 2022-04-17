package com.quintrix.jfs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

  public static void main(String[] args) {
    Connection connection = null;
    Statement insertStmt = null;
    Statement selectStmt = null;
    Statement deleteStmt = null;
    String separator = "----------------";

    try {
      // Connect to database
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/world", "root", "");

      // Insert data into table
      insertStmt = connection.createStatement();
      insertStmt.execute(
          "INSERT INTO city (Name,CountryCode,District,Population) VALUES ('San Angelo', 'USA', 'Texas', 100031)");
      insertStmt.execute(
          "INSERT INTO city (Name,CountryCode,District,Population) VALUES ('Big Spring', 'USA', 'Texas', 28041)");

      // Select data from table
      selectStmt = connection.createStatement();
      ResultSet rs =
          selectStmt.executeQuery("SELECT ID, Name,Population FROM city WHERE district = 'Texas'");

      // Formated Header
      System.out.printf("%-5s" + "|" + "%-30s" + "|" + "%-11s" + "%n", "ID", "Name", "Population");
      System.out.println(separator + separator + separator);

      while (rs.next()) {
        System.out.printf("%-5s" + "|" + "%-30s" + "|" + "%-11s" + "%n", rs.getString(1),
            rs.getString(2), rs.getInt(3));
      }

      // Delete data from tale
      deleteStmt = connection.createStatement();
      deleteStmt.execute("DELETE FROM city  WHERE Name = 'San Angelo'");
      deleteStmt.execute("DELETE FROM city  WHERE Name = 'Big Spring'");

    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        selectStmt.close();
        insertStmt.close();
        deleteStmt.close();
        connection.close();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }
  }
}
