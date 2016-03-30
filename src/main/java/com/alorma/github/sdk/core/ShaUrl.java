package com.alorma.github.sdk.core;

import com.google.gson.annotations.SerializedName;

public class ShaUrl {

  public String sha;
  public String url;

  @SerializedName("html_url")
  public String htmlUrl;

  public ShaUrl() {
  }


  public String getSha() {
    return sha;
  }

  public void setSha(String sha) {
    this.sha = sha;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getHtmlUrl() {
    return htmlUrl;
  }

  public void setHtmlUrl(String htmlUrl) {
    this.htmlUrl = htmlUrl;
  }

}
