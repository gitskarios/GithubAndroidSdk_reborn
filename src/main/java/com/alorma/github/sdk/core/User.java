package com.alorma.github.sdk.core;

import com.google.gson.annotations.SerializedName;

public class User {

  private int id;
  private String login;
  private String name;
  @SerializedName("avatar_url")
  private String avatar;

  public User() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLogin() {
    return login;
  }

  public void setLogin(String login) {
    this.login = login;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }
}