package com.yoshuawuyts.whereapp;

/**
 * Location model
 */

public class ModelLocation {
  private int id;
  private String name;

  public ModelLocation(){}

  public ModelLocation(String name) {
    super();
    this.name = name;
  }

  // getter / setter
  @Override
  public String toString() {
    return "LocationModel [id=" 
    + id 
    + ", name="
    + name
    + "]";
  }

  public void setId(int parseInt) {
    this.id = parseInt;
  }

  public void setName(String string) {
    this.name = string;
  }

  public String getName() {
    return this.name;
  }

  public int getId() {
    return this.id;
  }

}
