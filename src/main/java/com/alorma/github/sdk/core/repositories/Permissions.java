package com.alorma.github.sdk.core.repositories;

public class Permissions {

  public boolean admin;
  public boolean push;
  public boolean pull;

  public Permissions() {
    this.admin = false;
    this.push = false;
    this.pull = false;
  }
}
