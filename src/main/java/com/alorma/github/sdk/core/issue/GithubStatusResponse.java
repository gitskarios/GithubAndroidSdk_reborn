package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.repositories.Repo;
import java.util.List;

public class GithubStatusResponse extends ShaUrl {

  public String state;
  public int total_count;
  public List<GithubStatus> statuses;
  public Repo repository;
  public String commit_url;

  public GithubStatusResponse() {
  }
}
