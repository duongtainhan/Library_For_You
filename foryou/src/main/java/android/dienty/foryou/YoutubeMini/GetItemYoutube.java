package android.dienty.foryou.YoutubeMini;

import android.content.Context;
import android.dienty.foryou.YoutubeMini.Interface.RequestInterface;
import android.dienty.foryou.YoutubeMini.Models.Item;
import android.dienty.foryou.YoutubeMini.Models.VideoItem;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import android.dienty.foryou.R;

public class GetItemYoutube {
    private CompositeDisposable compositeDisposable;
    private VideoItem videoItem;
    private ArrayList<Item> arrayItems;
    private VideoAdapter videoAdapter;
    private Context context;

    public ArrayList<Item> getArrayItems() {
        return arrayItems;
    }

    private ListView listVideo;

    public void LoadJSON(String key, String key_search, int maxResult, Context context, ListView listVideo)
    {
        compositeDisposable = new CompositeDisposable();
        videoItem = new VideoItem();
        this.context = context;
        this.listVideo = listVideo;
        String maxVideo = String.valueOf(maxResult);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10,TimeUnit.SECONDS)
                .connectTimeout(10,TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_1))
                .build();
        RequestInterface requestInterface = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("https://www.googleapis.com/youtube/v3/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build().create(RequestInterface.class);
        Disposable disposable = requestInterface.register("snippet",key_search,maxVideo,"video",key)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(this::handleResponse, this::handleError, this::handleSuccess);
        compositeDisposable.add(disposable);
    }

    public void handleResponse(VideoItem itemVideo) {
        arrayItems = new ArrayList<>();
        videoItem = itemVideo;
        for(int i=0;i<videoItem.getItems().size();i++)
        {
            Item item = new Item();
            item.setSnippet(videoItem.getItems().get(i).getSnippet());
            item.setId(videoItem.getItems().get(i).getId());
            arrayItems.add(item);
            //Log.d("BBB",videoItems2.getItems().get(i).getSnippet().getThumbnails().getMedium().getUrl());
        }
        //Log.d("CCC",arrayItems.get(1).getId().getVideoId());
        videoAdapter = new VideoAdapter(context,R.layout.layout_video,arrayItems);
        listVideo.setAdapter(videoAdapter);
    }
    public String handleError(Throwable error) {
        return "Error " + error.getLocalizedMessage();
    }

    public String handleSuccess() {
        return "Connected";
    }
}
