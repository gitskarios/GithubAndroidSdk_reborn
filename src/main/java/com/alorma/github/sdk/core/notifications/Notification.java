package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.ShaUrl;
import com.alorma.github.sdk.core.repositories.Repo;

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

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public Repo getRepository() {
    return repository;
  }

  public void setRepository(Repo repository) {
    this.repository = repository;
  }

  public NotificationSubject getSubject() {
    return subject;
  }

  public void setSubject(NotificationSubject subject) {
    this.subject = subject;
  }

  public String getReason() {
    return reason;
  }

  public void setReason(String reason) {
    this.reason = reason;
  }

  public boolean isUnread() {
    return unread;
  }

  public void setUnread(boolean unread) {
    this.unread = unread;
  }

  public String getUpdated_at() {
    return updated_at;
  }

  public void setUpdated_at(String updated_at) {
    this.updated_at = updated_at;
  }

  public String getLast_read_at() {
    return last_read_at;
  }

  public void setLast_read_at(String last_read_at) {
    this.last_read_at = last_read_at;
  }

  public Long getAdapter_repo_parent_id() {
    return adapter_repo_parent_id;
  }

  public void setAdapter_repo_parent_id(Long adapter_repo_parent_id) {
    this.adapter_repo_parent_id = adapter_repo_parent_id;
  }
}
