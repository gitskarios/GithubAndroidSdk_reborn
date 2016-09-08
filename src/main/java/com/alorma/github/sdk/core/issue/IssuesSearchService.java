package com.alorma.github.sdk.core.issue;

import com.alorma.github.sdk.core.issues.IssueSearchResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IssuesSearchService {

  String QUERY = "is:%s %s:%s";

  @GET("/search/issues")
  Call<IssueSearchResponse> userIssues(@Query("q") String filter);

  @GET("/search/issues")
  Call<IssueSearchResponse> userIssues(@Query("q") String filter, @Query("page") int page);
}
