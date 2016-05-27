package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ShaUrl;

public class Label extends ShaUrl implements Comparable<Label> {

  public String name;
  public String color;

  public Label() {
  }

  @Override
  public int compareTo(Label another) {
    return name.toLowerCase().compareTo(another.name.toLowerCase());
  }
}
