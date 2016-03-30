package com.alorma.github.sdk.core;

public class Repo extends ShaUrl {

  public long id;
  public String name;
  public String full_name;
  public User owner;

  public Repo() {
    super();
  }

}