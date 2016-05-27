package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.User;
import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class Milestone extends ShaUrl implements Comparable<Milestone> {

  public String title;
  public int number;
  public MilestoneState state;
  public String description;
  public User creator;
  @SerializedName("open_issues") public int openIssues;
  @SerializedName("closed_issues") public int closedIssues;
  @SerializedName("created_at") public Date createdAt;
  @SerializedName("updated_at") public Date updatedAt;
  @SerializedName("due_on") public String dueOn;

  public Milestone() {
  }

  @Override
  public int compareTo(Milestone another) {
    return title.toLowerCase().compareTo(another.title.toLowerCase());
  }

}