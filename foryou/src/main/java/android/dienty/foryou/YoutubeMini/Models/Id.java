package android.dienty.foryou.YoutubeMini.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Id {

@SerializedName("videoId")
@Expose
private String videoId;

public String getVideoId() {
return videoId;
}

public void setVideoId(String videoId) {
this.videoId = videoId;
}

}