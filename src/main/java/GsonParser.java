import Model.Author;
import com.google.gson.Gson;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class GsonParser {
  public GsonParser(String input) throws IOException, CsvValidationException {
    if (CSVParser.fileExists(input)) {
      readJson(input);
    }
  }

  private void readJson(String input) throws FileNotFoundException {
    Gson g = new Gson();

    BufferedReader br = new BufferedReader(new FileReader(input));
    Author[] authors = g.fromJson(br, Author[].class);

    // Print by id in author array
    //System.out.println(authors[0].toString());

    // print all authors
    for (Author a : authors) {
      System.out.println(a.toString() + "\n");
    }
  }
}
