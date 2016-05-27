package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.User;

public class IssueStoryReviewComment implements IssueStoryDetail {

  public ReviewComment event;
  public long created_at;

  public IssueStoryReviewComment(ReviewComment event) {
    this.event = event;
  }

  @Override
  public boolean isList() {
    return false;
  }

  @Override
  public String getType() {
    return "review_comment";
  }

  @Override
  public long createdAt() {
    return created_at;
  }

  @Override
  public User user() {
    return event.user;
  }

}
