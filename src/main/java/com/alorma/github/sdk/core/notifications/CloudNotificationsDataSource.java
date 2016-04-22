package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkItem;
import java.util.List;
import java.util.concurrent.Callable;
import retrofit2.Call;
import rx.Observable;

public class CloudNotificationsDataSource
    extends CloudDataSource<NotificationsRequest, List<Notification>> {

  public CloudNotificationsDataSource(RestWrapper restWrapper) {
    super(restWrapper);
  }

  @Override
  protected Observable<SdkItem<List<Notification>>> execute(
      final SdkItem<NotificationsRequest> request, final RestWrapper service) {

    return Observable.fromCallable(new Callable<SdkItem<List<Notification>>>() {
      @Override
      public SdkItem<List<Notification>> call() throws Exception {
        Call<List<Notification>> notifications =
            service.<NotificationsService>get().getNotifications(
                request.getK().isAllNotifications(), request.getK().isParticipatingNotifications());
        return new SdkItem<>(0, notifications.execute().body());
      }
    });
  }
}
