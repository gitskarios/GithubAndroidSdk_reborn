package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.User;

public interface IssueStoryDetail {
  boolean isList();

  String getType();

  long createdAt();

  User user();
}
