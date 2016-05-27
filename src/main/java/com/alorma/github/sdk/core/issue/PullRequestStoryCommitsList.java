package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.User;
import com.alorma.github.sdk.core.repositories.Commit;
import java.util.ArrayList;

public class PullRequestStoryCommitsList extends ArrayList<Commit>
    implements IssueStoryDetail {

  public long created_at;
  public User user;

  public PullRequestStoryCommitsList() {
  }

  @Override
  public boolean isList() {
    return true;
  }

  @Override
  public String getType() {
    return "pushed";
  }

  @Override
  public long createdAt() {
    return created_at;
  }

  @Override
  public User user() {
    return user;
  }
}
