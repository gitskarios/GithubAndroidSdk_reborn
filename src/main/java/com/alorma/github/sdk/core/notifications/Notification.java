package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.Repo;
import com.alorma.github.sdk.core.ShaUrl;

public class Notification extends ShaUrl {

  public long id;
  public Repo repository;
  public NotificationSubject subject;
  public String reason;
  public boolean unread;
  public String updated_at;
  public String last_read_at;
  public Long adapter_repo_parent_id;

  public Notification() {
  }

}
