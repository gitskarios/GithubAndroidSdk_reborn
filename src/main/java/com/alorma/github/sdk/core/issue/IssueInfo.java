package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.repositories.RepoInfo;
import java.io.Serializable;

public class IssueInfo implements Serializable {

  public RepoInfo repoInfo;
  public int num;
  public IssueState state = IssueState.open;

  public IssueInfo() {
  }

  public IssueInfo(RepoInfo repoInfo) {
    this.repoInfo = repoInfo;
  }

  @Override
  public String toString() {
    return repoInfo.toString() + "#" + num;
  }

}
