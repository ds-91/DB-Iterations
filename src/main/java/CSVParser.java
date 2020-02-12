import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class CSVParser {

  public CSVParser(String input) throws IOException, CsvValidationException {
    if (fileExists(input)) {
      //csvPrintAll(input);
      csvPrintByArrayIndex(input);
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

  public static void csvPrintByArrayIndex(String filename)
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

  protected static boolean fileExists(String filename) {
    File f = new File(filename);

    if (!f.exists()) {
      System.out.println("File doesn't exist!");
      return false;
    }
    return true;
  }
}