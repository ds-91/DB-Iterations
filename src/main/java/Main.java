import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;

public class Main {

  private static final String CSV_FILE_PATH = "SEOExample.csv";

  public static void main(String[] args)
      throws IOException, CsvValidationException {
    CSVParser p = new CSVParser(CSV_FILE_PATH);
  }
}