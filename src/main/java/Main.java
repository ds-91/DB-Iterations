import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
  private static final String CSV_FILE_PATH = "SEOExample.csv";

  public static void main(String[] args) {
    try {
      FileReader fr = new FileReader(CSV_FILE_PATH);
      CSVReader reader = new CSVReader(fr);

      String[] nextLine;

      while ((nextLine = reader.readNext()) != null) {
        for (String line : nextLine) {
          System.out.print(line);
        }
        System.out.println();
      }
    } catch (FileNotFoundException e) {
      System.out.println("file not found");
    } catch (CsvValidationException e) {
      System.out.println("something about validation");
    } catch (IOException e) {
      System.out.println("io exception");
    }
  }
}
