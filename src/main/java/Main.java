import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {

  private static final String CSV_FILE_PATH = "./src/data/bookstore_report2.csv";
  private static final String JSON_FILE_PATH = "./src/data/authors.json";

  public static void main(String[] args)
      throws IOException, CsvValidationException {
    CSVParser p = new CSVParser(CSV_FILE_PATH);
    //GsonParser gp = new GsonParser(JSON_FILE_PATH);
  }
}