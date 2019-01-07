package android.dienty.library_for_you.ImageProcessing.activity;

import android.dienty.foryou.ImageProceesing.ImageProcessing;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.ImageProcessing.ClickProcessListener;
import android.dienty.library_for_you.ImageProcessing.CloseFragmentListener;
import android.dienty.library_for_you.ImageProcessing.adapter.ListProcessAdapter;
import android.dienty.library_for_you.ImageProcessing.fragment.OptionProcessFragment;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;


public class ImageProcessActivity extends AppCompatActivity implements ClickProcessListener, CloseFragmentListener {

    ImageView imageLibrary;
    ImageView imageNone;
    String path;
    RelativeLayout relativeBack;
    List<Bitmap> listImageProcess;
    RecyclerView recyclerImageProcess;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    OptionProcessFragment optionProcessFragment;

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
        imageNone = findViewById(R.id.iv_none);
        relativeBack = findViewById(R.id.rl_back_choose);
        recyclerImageProcess =  findViewById(R.id.rv_image_process);
    }

    private void InitValue() {
        path = getIntent().getStringExtra(CONST.INTENT.PATH_IMAGE);
        listImageProcess = new ArrayList<>();
        fragmentManager = getSupportFragmentManager();
    }

    private void InitAction() {
        imageLibrary.setBackground(Drawable.createFromPath(path));
        imageNone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CloseFragmentOption();
                imageLibrary.setImageBitmap(null);
                imageLibrary.setBackground(Drawable.createFromPath(path));
            }
        });
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
        listImageProcess.add(ImageProcessing.decreaseColorDepth(bitmap,10));
        listImageProcess.add(ImageProcessing.doBrightness(bitmap,50));
        listImageProcess.add(ImageProcessing.doGreyscale(bitmap));
        listImageProcess.add(ImageProcessing.doInvert(bitmap));
        listImageProcess.add(ImageProcessing.createContrast(bitmap,10));
        listImageProcess.add(ImageProcessing.createSepiaToningEffect(bitmap,10,10,10,10));
        listImageProcess.add(ImageProcessing.doColorFilter(bitmap,10,15,20));
        listImageProcess.add(ImageProcessing.doGamma(bitmap,5,20,16));
        listImageProcess.add(ImageProcessing.rotate(bitmap,30));
        return listImageProcess;
    }

    @Override
    public void onGetClick(int posProcess) {
//        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
//        Bitmap bitmap = BitmapFactory.decodeFile(path,bmOptions);
//        imageLibrary.setImageBitmap(ImageProcessing.decreaseColorDepth(bitmap,10));
        if(posProcess == 0)
        {
            AddFragmentOption();
        }
    }

    private void AddFragmentOption()
    {
        optionProcessFragment = new OptionProcessFragment(ImageProcessActivity.this,true,false,false,false);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameAddOption,optionProcessFragment,CONST.FRAGMENT.OPTION);
        fragmentTransaction.commit();
    }
    private void CloseFragmentOption()
    {
        optionProcessFragment = (OptionProcessFragment) fragmentManager.findFragmentByTag(CONST.FRAGMENT.OPTION);
        if(optionProcessFragment!=null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(optionProcessFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClickOutSide(boolean close) {
        if(close)
        {
            CloseFragmentOption();
        }
    }
}
