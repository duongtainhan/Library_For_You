package android.dienty.library_for_you.ImageProcessing.activity;

import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.MainActivity;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.dienty.library_for_you.R;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SaveActivity extends AppCompatActivity {

    RelativeLayout relativeBack;
    TextView txtHome;
    String path;
    ImageView imageReview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save);

        InitView();
        InitValue();
        InitAction();
    }

    private void InitView() {
        relativeBack = findViewById(R.id.rl_back);
        txtHome = findViewById(R.id.tv_home);
        imageReview = findViewById(R.id.iv_review);
    }

    private void InitValue() {
        Intent intent = getIntent();
        path = intent.getStringExtra(CONST.INTENT.SAVE_BITMAP);
        Glide.with(SaveActivity.this)
                .load(path)
                .into(imageReview);
    }

    private void InitAction() {
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        txtHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SaveActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });
    }
}
