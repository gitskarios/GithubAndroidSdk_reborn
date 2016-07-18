package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.BodyRequest;
import com.alorma.github.sdk.core.repositories.RepoInfo;

public class EditIssueCommentBodyRequest {
  private RepoInfo repoInfo;
  private String commentId;
  private BodyRequest body;

  public EditIssueCommentBodyRequest(RepoInfo repoInfo, String commentId, String body) {
    this.repoInfo = repoInfo;
    this.commentId = commentId;
    this.body = new BodyRequest(body);
  }

  public RepoInfo getRepoInfo() {
    return repoInfo;
  }

  public String getCommentId() {
    return commentId;
  }

  public BodyRequest getBody() {
    return body;
  }
}
