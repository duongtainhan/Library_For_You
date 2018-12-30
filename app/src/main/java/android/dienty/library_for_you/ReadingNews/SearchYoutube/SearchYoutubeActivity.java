package android.dienty.library_for_you.ReadingNews.SearchYoutube;

import android.dienty.foryou.YoutubeMini.GetItemYoutube;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.widget.RelativeLayout;

public class SearchYoutubeActivity extends AppCompatActivity {

    RelativeLayout relativeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_youtube);

        InitView();
    }
    private void InitView()
    {
        relativeBack = findViewById(R.id.relativeBackNews);
    }
}
