package Model;

import com.google.gson.annotations.SerializedName;

public class Author {
  @SerializedName("author_name")
  private String name;

  @SerializedName("author_email")
  private String email;

  @SerializedName("author_url")
  private String url;

  public Author() {

  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getUrl() {
    return url;
  }

  @Override
  public String toString() {
    return "Name: " + this.getName() + "\n" +
        "Email: " + this.getEmail() + "\n" +
        "URL: " + this.getUrl();
  }
}
