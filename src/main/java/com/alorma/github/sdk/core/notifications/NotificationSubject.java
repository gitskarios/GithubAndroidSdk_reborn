package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.ShaUrl;

/**
 * Created by Bernat on 18/02/2015.
 */
public class NotificationSubject extends ShaUrl {

  public String title;
  public String latest_comment_url;
  public String type;

  public NotificationSubject() {
  }

}
