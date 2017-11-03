package edu.cnm.bootcamp.itajan.helloworldandroid.api.models;

import java.util.List;



public class GalleryResponse {
  private boolean success;
  private int status;
  private List<Image> data;

  public boolean isSuccess() {
    return success;
  }

  public int getStatus() {
    return status;
  }

  public List<Image> getData() {
    return data;
  }
}
