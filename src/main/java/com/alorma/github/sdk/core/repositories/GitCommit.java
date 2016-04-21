package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.User;
import java.util.List;

public class GitCommit extends ShaUrl {

  public User committer;
  public List<ShaUrl> parents;
  public User author;
  public String message;
  public ShaUrl tree;
  public int comment_count;

  public GitCommit() {
  }

}
