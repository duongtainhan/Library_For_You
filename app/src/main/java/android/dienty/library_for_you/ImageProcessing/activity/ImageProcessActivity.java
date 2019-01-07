package android.dienty.library_for_you.ImageProcessing.activity;

import android.dienty.foryou.ImageProceesing.ImageProcessing;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.ImageProcessing.BoostPercentChangeListener;
import android.dienty.library_for_you.ImageProcessing.BoostRadioChangeListener;
import android.dienty.library_for_you.ImageProcessing.ClickProcessListener;
import android.dienty.library_for_you.ImageProcessing.CloseFragmentListener;
import android.dienty.library_for_you.ImageProcessing.SB1ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB2ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB3ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB4ChangeListener;
import android.dienty.library_for_you.ImageProcessing.adapter.ListProcessAdapter;
import android.dienty.library_for_you.ImageProcessing.fragment.OptionProcessFragment;
import android.dienty.library_for_you.ImageProcessing.fragment.Type2Fragment;
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


public class ImageProcessActivity extends AppCompatActivity implements ClickProcessListener, CloseFragmentListener,
        SB1ChangeListener, SB2ChangeListener, SB3ChangeListener, SB4ChangeListener,
        BoostRadioChangeListener, BoostPercentChangeListener {

    ImageView imageLibrary;
    ImageView imageNone;
    String path;
    RelativeLayout relativeBack;
    List<Bitmap> listImageProcess;
    RecyclerView recyclerImageProcess;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    OptionProcessFragment optionProcessFragment;
    Type2Fragment type2Fragment;
    int posProcess;
    int processOption1 = 1;
    int processOption2 = 1;
    int processOption3 = 1;
    int processOption4 = 1;
    float percentBoost = 0.1f;
    int typeBoost=1;

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
        recyclerImageProcess = findViewById(R.id.rv_image_process);
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
                CloseFragmentBoost();
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
                GetListImageProcess(path, 350, 350));
        recyclerImageProcess.setAdapter(listProcessAdapter);
    }

    public List<Bitmap> GetListImageProcess(String pathBitmap, int bitmapWidth, int bitmapHeight) {
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(pathBitmap, bmOptions);
        bitmap = Bitmap.createScaledBitmap(bitmap, bitmapWidth, bitmapHeight, true);
        listImageProcess.add(ImageProcessing.decreaseColorDepth(bitmap, 50));
        listImageProcess.add(ImageProcessing.doBrightness(bitmap, 50));
        listImageProcess.add(ImageProcessing.doGreyscale(bitmap));
        listImageProcess.add(ImageProcessing.doInvert(bitmap));
        listImageProcess.add(ImageProcessing.createContrast(bitmap, 10));
        listImageProcess.add(ImageProcessing.createSepiaToningEffect(bitmap, 10, 10, 10, 10));
        listImageProcess.add(ImageProcessing.doGamma(bitmap, 5, 6, 9));
        listImageProcess.add(ImageProcessing.rotate(bitmap, 30));
        listImageProcess.add(ImageProcessing.engrave(bitmap));
        listImageProcess.add(ImageProcessing.boost(bitmap,2,0.3f));
        listImageProcess.add(ImageProcessing.applyFleaEffect(bitmap));
        listImageProcess.add(ImageProcessing.applyBlackFilter(bitmap));
        listImageProcess.add(ImageProcessing.applyGaussianBlur(bitmap));
        listImageProcess.add(ImageProcessing.applyMeanRemoval(bitmap));
        return listImageProcess;
    }

    @Override
    public void onGetClick(int posProcess) {
        this.posProcess = posProcess;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        switch (posProcess)
        {
            case 0:
                AddFragmentOption(true,false,false,false,"Offset");
                break;
            case 1:
                AddFragmentOption(true,false,false,false,"Brightness");
                break;
            case 2:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.doGreyscale(bitmap));
                break;
            case 3:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.doInvert(bitmap));
                break;
            case 4:
                AddFragmentOption(true,false,false,false,"Contrast");
                break;
            case 5:
                AddFragmentOption(true,true,true,true,"Depth");
                break;
            case 6:
                AddFragmentOption(true,true,true,false,"Red");
                break;
            case 7:
                AddFragmentOption(true,false,false,false,"Degree");
                break;
            case 8:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.engrave(bitmap));
                break;
            case 9:
                AddFragmentBoostEffect();
                break;
            case 10:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.applyFleaEffect(bitmap));
                break;
            case 11:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.applyBlackFilter(bitmap));
                break;
            case 12:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.applyGaussianBlur(bitmap));
                break;
            case 13:
                CloseFragmentOption();
                CloseFragmentBoost();
                imageLibrary.setImageBitmap(ImageProcessing.applyMeanRemoval(bitmap));
                break;
        }
    }

    private void AddFragmentOption(Boolean enableOption1, Boolean enableOption2, Boolean enableOption3, Boolean enableOption4, String sOption) {
        optionProcessFragment = new OptionProcessFragment(ImageProcessActivity.this, enableOption1, enableOption2, enableOption3, enableOption4, sOption);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameAddOption, optionProcessFragment, CONST.FRAGMENT.OPTION);
        fragmentTransaction.commit();
    }

    private void CloseFragmentOption() {
        optionProcessFragment = (OptionProcessFragment) fragmentManager.findFragmentByTag(CONST.FRAGMENT.OPTION);
        if (optionProcessFragment != null) {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(optionProcessFragment);
            fragmentTransaction.commit();
        }
    }
    private void AddFragmentBoostEffect()
    {
        type2Fragment = new Type2Fragment(ImageProcessActivity.this);
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frameAddOption,type2Fragment,CONST.FRAGMENT.BOOST);
        fragmentTransaction.commit();
    }
    private void CloseFragmentBoost()
    {
        type2Fragment = (Type2Fragment) fragmentManager.findFragmentByTag(CONST.FRAGMENT.BOOST);
        if(type2Fragment!=null)
        {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(type2Fragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    public void onClickOutSide(boolean close) {
        if (close) {
            CloseFragmentOption();
            CloseFragmentBoost();
        }
    }

    @Override
    public void onProcessChangeSB1(int process) {
        processOption1 = process;
        if(process==0)
        {
            imageLibrary.setImageBitmap(null);
            imageLibrary.setBackground(Drawable.createFromPath(path));
        }
        else {
            BitmapFactory.Options bmOptions = new BitmapFactory.Options();
            Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
            switch (posProcess)
            {
                case 0:
                    imageLibrary.setImageBitmap(ImageProcessing.decreaseColorDepth(bitmap, process));
                    break;
                case 1:
                    imageLibrary.setImageBitmap(ImageProcessing.doBrightness(bitmap, process));
                    break;
                case 4:
                    imageLibrary.setImageBitmap(ImageProcessing.createContrast(bitmap, process));
                    break;
                case 5:
                    imageLibrary.setImageBitmap(ImageProcessing.createSepiaToningEffect(bitmap, getProcessOption1(),getProcessOption4(),getProcessOption3(),getProcessOption2()));
                    break;
                case 6:
                    imageLibrary.setImageBitmap(ImageProcessing.doGamma(bitmap, getProcessOption1(),getProcessOption3(),getProcessOption2()));
                    break;
                case 7:
                    imageLibrary.setImageBitmap(null);
                    imageLibrary.setBackground(null);
                    imageLibrary.setImageBitmap(ImageProcessing.rotate(bitmap, getProcessOption1()));
                    break;
            }
        }
    }

    @Override
    public void onProcessChangeSB2(int process) {
        processOption2 = process;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        switch (posProcess)
        {
            case 5:
                imageLibrary.setImageBitmap(ImageProcessing.createSepiaToningEffect(bitmap, getProcessOption1(),getProcessOption4(),getProcessOption3(),getProcessOption2()));
                break;
            case 6:
                imageLibrary.setImageBitmap(ImageProcessing.doGamma(bitmap, getProcessOption1(),getProcessOption3(),getProcessOption2()));
                break;
        }
    }

    @Override
    public void onChangeProcessSB3(int process) {
        processOption3 = process;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        switch (posProcess)
        {
            case 5:
                imageLibrary.setImageBitmap(ImageProcessing.createSepiaToningEffect(bitmap, getProcessOption1(),getProcessOption4(),getProcessOption3(),getProcessOption2()));
                break;
            case 6:
                imageLibrary.setImageBitmap(ImageProcessing.doGamma(bitmap, getProcessOption1(),getProcessOption3(),getProcessOption2()));
                break;
        }
    }

    @Override
    public void onChangeProcessSB4(int process) {
        processOption4 = process;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        switch (posProcess)
        {
            case 5:
                imageLibrary.setImageBitmap(ImageProcessing.createSepiaToningEffect(bitmap, getProcessOption1(),getProcessOption4(),getProcessOption3(),getProcessOption2()));
                break;
        }

    }

    public int getProcessOption1() {
        return processOption1;
    }

    public int getProcessOption2() {
        return processOption2;
    }

    public int getProcessOption3() {
        return processOption3;
    }

    public int getProcessOption4() {
        return processOption4;
    }
    public float getPercentBoost() {
        return percentBoost;
    }

    public int getTypeBoost() {
        return typeBoost;
    }

    @Override
    public void onChangePercent(float percent) {
        percentBoost = percent;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        imageLibrary.setImageBitmap(ImageProcessing.boost(bitmap,getTypeBoost(),getPercentBoost()));
    }

    @Override
    public void onChangeRadio(int type) {
        typeBoost = type;
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        Bitmap bitmap = BitmapFactory.decodeFile(path, bmOptions);
        imageLibrary.setImageBitmap(ImageProcessing.boost(bitmap,getTypeBoost(),getPercentBoost()));
    }
}
