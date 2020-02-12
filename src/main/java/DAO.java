import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DAO {
  private static final String JDBC_CONNECTION = "jdbc:sqlite:C:\\Users\\Derek\\IdeaProjects\\iteration1\\src\\data\\BookStore.db";
  public Connection getConnection() throws ClassNotFoundException, SQLException {
    Class.forName("org.sqlite.JDBC");
    return DriverManager.getConnection(JDBC_CONNECTION);
  }
}
