import Model.Book;
import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CSVParser {

  public CSVParser(String input) throws IOException, CsvValidationException {
    if (fileExists(input)) {
      //csvPrintAll(input);
      //csvPrintByArrayIndex(input);
      csvReadIntoDatabase(input);
    }
  }

  private void csvPrintAll(String filename)
      throws IOException, CsvValidationException {
    String[] nextLine;

    FileReader f = new FileReader(filename);
    CSVReader r = new CSVReader(f);

    while ((nextLine = r.readNext()) != null) {
      for (String line : nextLine) {
        System.out.println(line);
      }
      System.out.println();
    }
  }

  public void csvPrintByArrayIndex(String filename)
      throws IOException, CsvValidationException {

    FileReader f = new FileReader(filename);
    CSVReader r = new CSVReader(f);
    String[] nextLine;
    while ((nextLine = r.readNext()) != null) {
      /**
       * Array indexes:
       * 0 = name, 1 = date, 2 = entry point, 3 = region, 4 = location
       * 5 = accepted, 6 = enrolled, 7 = search terms, 8 = engine, 9 = reason
       */
      System.out.println(nextLine[0]);
    }
  }

  public void csvReadIntoDatabase(String filename) throws IOException {
    FileReader f = new FileReader(filename);
    CSVReader r = new CSVReader(f);

    CsvToBean bean = new CsvToBeanBuilder(r)
        .withType(Book.class)
        .withIgnoreLeadingWhiteSpace(true)
        .withSeparator(',')
        .withSkipLines(1)
        .build();

    DAO dao = new DAO();
    Connection conn = null;
    PreparedStatement ps = null;

    for (Book b : (Iterable<Book>) bean) {
      try {
        conn = dao.getConnection();
        ps = conn.prepareStatement("INSERT INTO book(isbn, publisher_name, author_name, book_title) VALUES(?, ?, ?, ?)");
        ps.setString(1, b.getIsbn());
        ps.setString(2, b.getPublisherName());
        ps.setString(3, b.getAuthorName());
        ps.setString(4, b.getBookTitle());

        ps.execute();

        conn.close();
        ps.close();
      } catch (SQLException e) {
        e.printStackTrace();
      } catch (ClassNotFoundException e) {
        e.printStackTrace();
      }
    }

    f.close();
    r.close();
    System.out.println("Done (csv)...check database");
  }

  protected static boolean fileExists(String filename) {
    File f = new File(filename);

    if (!f.exists()) {
      System.out.println("File doesn't exist!");
      return false;
    }
    return true;
  }
}