package android.dienty.foryou.YoutubeMini.Interface;

import android.dienty.foryou.YoutubeMini.Models.VideoItem;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RequestInterface {

    @GET("search")
    Observable<VideoItem> register(@Query("part") String part,
                                   @Query("q") String key_search,
                                   @Query("maxResults") String maxResults,
                                   @Query("type") String type,
                                   @Query("key") String key);
}