package com.alorma.github.sdk.core.repositories;

import java.io.Serializable;

public class RepoInfo implements Serializable {

  public String owner;
  public String name;
  public String branch;
  public Permissions permissions = new Permissions();

  public RepoInfo() {
  }

  @Override
  public String toString() {
    return owner + "/" + name;
  }

}