package android.dienty.library_for_you.ImageProcessing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;

import bo.photo.module.image_picker_module.furntion.ImageFileLoader;

public class ImageProcessActivity extends AppCompatActivity {

    ImageFileLoader imageFileLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_process);
    }
}
