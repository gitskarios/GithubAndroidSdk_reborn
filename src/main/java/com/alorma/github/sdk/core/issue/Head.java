package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.User;
import com.alorma.github.sdk.core.repositories.Repo;

public class Head extends ShaUrl {

  public String ref;
  public Repo repo;
  public String label;
  public User user;

  public Head() {
  }
}