package com.alorma.github.sdk.core;

import com.google.gson.annotations.SerializedName;

public class Repo extends ShaUrl {

  private long id;
  private String name;

  @SerializedName("full_name")
  private String fullName;
  private User owner;

  public Repo() {
    super();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String full_name) {
    this.fullName = full_name;
  }

  public User getOwner() {
    return owner;
  }

  public void setOwner(User owner) {
    this.owner = owner;
  }
}