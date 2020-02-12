import Model.Author;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class GsonParser {
  public GsonParser(String input) throws IOException, CsvValidationException {
    if (CSVParser.fileExists(input)) {
      readJsonIntoDatabase(input);
    }
  }

  private void readJsonIntoDatabase(String input) throws FileNotFoundException {
    Gson g = new Gson();

    BufferedReader br = new BufferedReader(new FileReader(input));
    Author[] authors = g.fromJson(br, Author[].class);

    // Print by id in author array
    //System.out.println(authors[0].toString());

    DAO dao = new DAO();
    Connection conn = null;
    PreparedStatement ps = null;

    // add each to database
    for (Author a : authors) {
      try {
        conn = dao.getConnection();
        ps = conn.prepareStatement("INSERT INTO author(author_name, author_email, author_url) VALUES(?, ?, ?)");
        ps.setString(1, a.getName());
        ps.setString(2, a.getEmail());
        ps.setString(3, a.getUrl());

        ps.execute();

        conn.close();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }
    System.out.println("Done...check database");
  }
}
