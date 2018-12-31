package android.dienty.library_for_you.ReadingNews.WebView;

import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class WebViewActivity extends AppCompatActivity {

    WebView webView;
    RelativeLayout relativeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        webView = findViewById(R.id.webView);
        Intent intentNews = getIntent();
        String linkURL = intentNews.getStringExtra(CONST.INTENT.LINK);
        webView.loadUrl(linkURL);
        webView.setWebViewClient(new WebViewClient());
        //
        relativeBack = findViewById(R.id.rl_back_youtube);
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
