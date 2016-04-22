package com.alorma.github.sdk.core.repositories;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ReposService {

  @GET("/user/repos?type=owner")
  Call<List<Repo>> userReposList(@Query("sort") String sort);

  @GET("/user/repos?type=owner")
  Call<List<Repo>> userReposList(@Query("page") int page, @Query("sort") String sort);

  @GET("/users/{username}/repos?type=owner")
  Call<List<Repo>> userReposList(@Path("username") String username, @Query("sort") String sort);

  @GET("/users/{username}/repos?type=owner")
  Call<List<Repo>> userReposList(@Path("username") String username, @Query("page") int page,
      @Query("sort") String sort);

  // Starred repos
  @GET("/user/starred?sort=updated")
  Call<List<Repo>> userStarredReposList(@Query("sort") String sort);

  @GET("/user/starred?sort=updated")
  Call<List<Repo>> userStarredReposList(@Query("page") int page, @Query("sort") String sort);

  @GET("/users/{username}/starred?sort=updated")
  Call<List<Repo>> userStarredReposList(@Path("username") String username,
      @Query("sort") String sort);

  @GET("/users/{username}/starred?sort=updated")
  Call<List<Repo>> userStarredReposList(@Path("username") String username, @Query("page") int page,
      @Query("sort") String sort);
}
