package com.alorma.github.sdk.core.repositories;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.User;
import java.util.List;

public class Commit extends ShaUrl {

  public GitCommit commit;
  public User author;
  public List<ShaUrl> parents;
  public GitChangeStatus stats;
  public User committer;
  public String message;
  public boolean distinct;
  public GitCommitFiles files;
  public int days;
  public int comment_count;

  public Commit() {
  }

}