package edu.cnm.bootcamp.itajan.helloworldandroid.api.models;

public class Image {
  private String id;
  private String title;
  private String description;
  private String link;
  private boolean is_album;
  private boolean in_gallery;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getLink() {
    return link;
  }

  public boolean isIs_album() {
    return is_album;
  }

  public boolean isIn_gallery() {
    return in_gallery;
  }
}
