package android.dienty.library_for_you.ReadingNews.SearchYoutube;

import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import android.dienty.library_for_you.R;


public class YoutubePlayer extends YouTubeBaseActivity implements YouTubePlayer.OnInitializedListener {

    String key = "AIzaSyAeO5epPX-eQCmWuNpb6LAz61W2JGwfa9k";
    YouTubePlayerView youTubePlayerView;
    String videoID;
    int REQUEST_VIDEO = 123;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_youtube_player);

        Intent intent = getIntent();
        videoID = intent.getStringExtra(CONST.INTENT.VIDEO_ID);
        youTubePlayerView = findViewById(R.id.youtubePlayerView);
        youTubePlayerView.initialize(key,this);

    }

    @Override
    public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
        youTubePlayer.cueVideo(videoID);
    }

    @Override
    public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
        if(youTubeInitializationResult.isUserRecoverableError())
        {
            youTubeInitializationResult.getErrorDialog(YoutubePlayer.this,REQUEST_VIDEO);
        }
        else
        {
            Toast.makeText(YoutubePlayer.this, "ERROR!!!...", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_VIDEO)
        {
            youTubePlayerView.initialize(key,YoutubePlayer.this);
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
