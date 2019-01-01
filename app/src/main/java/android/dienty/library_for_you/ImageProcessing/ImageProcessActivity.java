package android.dienty.library_for_you.ImageProcessing;

import android.dienty.foryou.ImageProceesing.ImageProcessing;
import android.dienty.library_for_you.CONST;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class ImageProcessActivity extends AppCompatActivity {

    ImageView imageLibrary;
    String path;
    RelativeLayout relativeBack;
    List<Bitmap> listImageProcess;
    RecyclerView recyclerImageProcess;


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
        relativeBack = findViewById(R.id.rl_back_choose);
        recyclerImageProcess =  findViewById(R.id.rv_image_process);
    }

    private void InitValue() {
        path = getIntent().getStringExtra(CONST.INTENT.PATH_IMAGE);
        listImageProcess = new ArrayList<>();
    }

    private void InitAction() {
        imageLibrary.setBackground(Drawable.createFromPath(path));
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        ListProcessAdapter listProcessAdapter = new
                ListProcessAdapter(ImageProcessActivity.this,
                GetListImageProcess(path,350,350));
        recyclerImageProcess.setAdapter(listProcessAdapter);
    }
    public List<Bitmap> GetListImageProcess(String pathBitmap, int bitmapWidth, int bitmapHeight) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(pathBitmap,bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap,bitmapWidth, bitmapHeight,true);
        listImageProcess.add(ImageProcessing.decreaseColorDepth(bitmap,50));
        listImageProcess.add(ImageProcessing.doInvert(bitmap));
        listImageProcess.add(ImageProcessing.doBrightness(bitmap,120));
        listImageProcess.add(ImageProcessing.doGreyscale(bitmap));
        return listImageProcess;
    }
}
