package com.alorma.github.sdk.core.issues;

public class PullRequest extends Issue {
  private boolean merged;

  public boolean isMerged() {
    return merged;
  }
}
