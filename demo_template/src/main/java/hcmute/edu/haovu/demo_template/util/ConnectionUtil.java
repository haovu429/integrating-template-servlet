package hcmute.edu.haovu.demo_template.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {
  /**
   * Get database connection
   *
   * @return a Connection object
   * @throws SQLException
   */
  public static Connection getConnection() throws SQLException {
    Connection conn = null;


    try (InputStream input = ConnectionUtil.class.getClassLoader().getResourceAsStream("db.properties")) {

      Class.forName("com.mysql.cj.jdbc.Driver");
      // load the properties file
      Properties pros = new Properties();
      pros.load(input);

      // assign db parameters
      String url = pros.getProperty("url");
      String user = pros.getProperty("user");
      String password = pros.getProperty("password");

      // create a connection to the database
      conn = DriverManager.getConnection(url, user, password);
    } catch (IOException e) {
      System.out.println(e.getMessage());
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
    return conn;
  }
}
