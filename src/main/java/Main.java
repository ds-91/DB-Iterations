import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

  private static final String CSV_FILE_PATH = "SEOExample.csv";

  public static void main(String[] args) {
    FileReader f = createReader(CSV_FILE_PATH);
    CSVReader r = new CSVReader(f);

    //csvPrintAll(f, r);
    csvPrintByArrayIndex(f, r);
  }

  public static FileReader createReader(String filename) {
    FileReader fr;
    try {
      fr = new FileReader(filename);
    } catch (FileNotFoundException e) {
      return null;
    }
    return fr;
  }

  public static void csvPrintAll(FileReader f, CSVReader r) {
    try {
      String[] nextLine;

      while ((nextLine = r.readNext()) != null) {
        for (String line : nextLine) {
          System.out.print(line);
        }
        System.out.println();
      }
    } catch (CsvValidationException e) {
      System.out.println("something about validation");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("io exception");
      e.printStackTrace();
    }
  }

  public static void csvPrintByArrayIndex(FileReader f, CSVReader r) {
    try {
      String[] nextLine;
      while ((nextLine = r.readNext()) != null) {
        /**
         * Array indexes:
         * 0 = name, 1 = date, 2 = entry point, 3 = region, 4 = location
         * 5 = accepted, 6 = enrolled, 7 = search terms, 8 = engine, 9 = reason
         */
        System.out.println(nextLine[0]);
      }
    } catch (CsvValidationException e) {
      System.out.println("something about validation");
      e.printStackTrace();
    } catch (IOException e) {
      System.out.println("io exception");
      e.printStackTrace();
    }
  }
}
