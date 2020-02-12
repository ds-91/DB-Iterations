package Model;

import com.opencsv.bean.CsvBindByName;

public class Book {

  @CsvBindByName(column = "isbn")
  private String isbn;

  @CsvBindByName(column = "publisher")
  private String publisherName;

  @CsvBindByName(column = "author")
  private String authorName;

  /*
  @CsvBindByName(column = "book_year")
  private int bookYear;
  */

  @CsvBindByName(column = "title")
  private String bookTitle;

  /*
  @CsvBindByName(column = "book_price")
  private double bookPrice;
  */

  public Book() {

  }

  public String getIsbn() {
    return isbn;
  }

  public String getPublisherName() {
    return publisherName;
  }

  public String getAuthorName() {
    return authorName;
  }


  public String getBookTitle() {
    return bookTitle;
  }

  @Override
  public String toString() {
    return "ISBN: " + this.getIsbn() + "\n" +
        "Publisher: " + this.getPublisherName() + "\n" +
        "Author: " + this.getAuthorName() + "\n" +
        //"Year: " + this.getBookYear() + "\n" +
        "Title: " + this.getBookTitle() + "\n";
        //"Price: " + this.getBookPrice() + "\n";
  }
}
