package com.alorma.github.sdk.core.notifications;

import com.alorma.github.sdk.core.datasource.CloudDataSource;
import com.alorma.github.sdk.core.datasource.RestWrapper;
import com.alorma.github.sdk.core.datasource.SdkResponse;
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
  protected Observable<SdkResponse<List<Notification>>> execute(final NotificationsRequest request,
      final RestWrapper service) {

    return Observable.fromCallable(new Callable<SdkResponse<List<Notification>>>() {
      @Override
      public SdkResponse<List<Notification>> call() throws Exception {
        Call<List<Notification>> notifications =
            service.<NotificationsService>get().getNotifications(request.isAllNotifications(),
                request.isParticipatingNotifications());
        return new SdkResponse<>(0, notifications.execute().body());
      }
    });
  }
}
