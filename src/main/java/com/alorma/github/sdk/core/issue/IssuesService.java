package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.issues.Issue;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IssuesService {

  @GET("/user/issues")
  Call<List<Issue>> userIssues(@Query("filter") String filter);

  @GET("/user/issues")
  Call<List<Issue>> userIssues(@Query("filter") String filter, @Query("page") int page);
}
