package edu.cnm.bootcamp.itajan.helloworldandroid.api;

import android.content.Context;
import edu.cnm.bootcamp.itajan.helloworldandroid.R;
import edu.cnm.bootcamp.itajan.helloworldandroid.api.models.GalleryResponse;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Single;


public class API {
  public static ImgurService imgurService;

  public static void init(final Context context) {
    OkHttpClient.Builder httpClient = new Builder();
    httpClient.addInterceptor(new Interceptor() {
      @Override
      public Response intercept(Interceptor.Chain chain) throws IOException {
        Request original = chain.request();

        Request request = original.newBuilder()
            .header(
                "Authorization",
                "Client-ID "
                    + context.getString(R.string.imgur_client_id)
            )
            .method(original.method(), original.body())
            .build();

        return chain.proceed(request);
      }
    });

    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.imgur.com/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(httpClient.build())
            .build();

    imgurService = retrofit.create(ImgurService.class);
  }

  public static Single<GalleryResponse> subredditGallery(String subreddit) {
    return imgurService.subredditGallery(subreddit, "time", "day", 0);
  }

}
