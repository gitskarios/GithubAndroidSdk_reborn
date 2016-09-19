package com.alorma.github.sdk.core.datasource;

import com.alorma.github.sdk.core.ApiClient;
import com.alorma.github.sdk.core.Exclude;
import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.IOException;
import java.lang.reflect.Type;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class RetrofitWrapper extends RestWrapper {

  private String token;

  public RetrofitWrapper(ApiClient apiClient, String token) {
    super(apiClient);
    this.token = token;
  }

  @Override
  protected <T> T get(ApiClient apiClient) {
    GsonBuilder gsonBuilder =  new GsonBuilder();
    gsonBuilder.registerTypeAdapter(Date.class, new DateDeserializer());
    gsonBuilder.setExclusionStrategies(new AnnotationExclusionStrategy());

    Gson gson = gsonBuilder.setLenient().create();
    Retrofit retrofit = new Retrofit.Builder().baseUrl(apiClient.getApiEndpoint())
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(getClient())
        .build();

    return get(retrofit);
  }

  protected abstract <T> T get(Retrofit retrofit);

  private OkHttpClient getClient() {
    OkHttpClient.Builder builder = new OkHttpClient.Builder();
    builder.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();

        Request.Builder builder = original.newBuilder();

        if (token != null) {
          builder.addHeader("Authorization", "token " + token);
        }
        builder.addHeader("User-Agent", "Gitskarios");
        builder.addHeader("Accept", "application/vnd.github.v3.json");
        builder.method(original.method(), original.body());

        return chain.proceed(builder.build());
      }
    });

    return builder.build();
  }

  @Override
  public boolean isPaginated(retrofit2.Response response) {
    if (response.headers() != null) {
      String header = response.headers().get("Link");
      if (null != header) {
        String[] parts = header.split(",");
        for (String part : parts) {
          PaginationLink bottomPaginationLink = new PaginationLink(part);
          return bottomPaginationLink.rel == RelType.next;
        }
      }
    }
    return false;
  }

  @Override
  public Integer getPage(retrofit2.Response response) {
    if (isPaginated(response)) {
      String header = response.headers().get("Link");
      if (null != header) {
        String[] parts = header.split(",");
        for (String part : parts) {
          PaginationLink bottomPaginationLink = new PaginationLink(part);
          if (bottomPaginationLink.rel == RelType.next) {
            return bottomPaginationLink.page;
          }
        }
      }
    }
    return null;
  }

  // date deserializer
  private class DateDeserializer implements JsonDeserializer<Date> {
    final DateFormat original = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.ENGLISH);

    @Override
    public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
            throws JsonParseException {
      Date date = new Date();
      try {
        date = original.parse(json.getAsString());
      } catch (ParseException e) {
      }
      return date;
    }
  }

  private class AnnotationExclusionStrategy implements ExclusionStrategy {
    @Override
    public boolean shouldSkipField(FieldAttributes f) {
      return f.getAnnotation(Exclude.class) != null;
    }

    @Override
    public boolean shouldSkipClass(Class<?> clazz) {
      return false;
    }
  }
}
