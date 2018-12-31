package android.dienty.library_for_you.ReadingNews.SearchYoutube;

import android.dienty.foryou.YoutubeMini.GetItemYoutube;
import android.dienty.library_for_you.CONST;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.view.View;
import android.widget.ListView;
import android.widget.RelativeLayout;

public class SearchYoutubeActivity extends AppCompatActivity {

    private static final String key="AIzaSyAsaI7Evp_fk_R_G6LJCBA5I-EBJXA7zIY";
    RelativeLayout relativeBack;
    ListView listVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_youtube);

        String key_search = getIntent().getStringExtra(CONST.INTENT.KEY_SEARCH);
        InitView();
        GetItemYoutube getItemYoutube = new GetItemYoutube();
        getItemYoutube.LoadJSON(key,key_search,10,SearchYoutubeActivity.this,listVideo);
    }
    private void InitView()
    {
        relativeBack = findViewById(R.id.relativeBackNews);
        listVideo = findViewById(R.id.listVideo);
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
