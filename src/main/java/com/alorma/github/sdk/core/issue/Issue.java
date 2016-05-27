package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.GithubComment;
import com.alorma.github.sdk.core.User;
import com.alorma.github.sdk.core.repositories.Repo;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Issue extends GithubComment {

  public int number;
  public IssueState state;
  public boolean locked;
  public String title;
  public List<Label> labels;
  public User assignee;
  public Milestone milestone;
  public int comments;
  @SerializedName("pull_request") public PullRequest pullRequest;
  @SerializedName("closed_at") public String closedAt;

  public Repo repository;

  public Issue() {
  }
}
