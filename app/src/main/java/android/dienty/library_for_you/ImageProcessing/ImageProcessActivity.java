package android.dienty.library_for_you.ImageProcessing;

import android.dienty.library_for_you.CONST;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.util.Log;
import android.widget.ImageView;

import bo.photo.module.image_picker_module.furntion.ImageFileLoader;

public class ImageProcessActivity extends AppCompatActivity {

    ImageFileLoader imageFileLoader;
    ImageView imageLibrary;
    String path;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_process);
        //
        InitView();
        InitValue();
        InitAction();
    }

    private void InitView() {
        imageLibrary = findViewById(R.id.imagePhotoLibrary);
    }

    private void InitValue() {
        path = getIntent().getStringExtra(CONST.INTENT.PATH_IMAGE);
    }

    private void InitAction() {
        imageLibrary.setBackground(Drawable.createFromPath(path));
    }
}
