package android.dienty.library_for_you.ImageProcessing;

import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.dienty.library_for_you.R;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import bo.photo.module.image_picker_module.furntion.ImageFileLoader;
import bo.photo.module.image_picker_module.furntion.ImageLoaderListener;
import bo.photo.module.image_picker_module.model.Folder;
import bo.photo.module.image_picker_module.model.Image;

public class ShowGalleryActivity extends AppCompatActivity implements GetPathListener {

    RecyclerView recyclerView;
    RelativeLayout relativeBack;
    ArrayList<String> listResource;
    ImageFileLoader imageFileLoader;
    ArrayList<File> excludedImages;
    boolean isCompleted;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_gallery);
        //
        InitView();
        InitValue();
        InitAction();
    }

    private void InitView() {
        recyclerView = findViewById(R.id.rv_gallery_library);
        relativeBack = findViewById(R.id.rl_back_main);
    }
    private void InitValue() {
        isCompleted=false;
        listResource= new ArrayList<>();
        excludedImages = new ArrayList<>();
        imageFileLoader = new ImageFileLoader(ShowGalleryActivity.this);
    }
    private void InitAction() {
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        AddPhotoAdapter adapter = new AddPhotoAdapter(listResource,ShowGalleryActivity.this);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(ShowGalleryActivity.this,3);
        recyclerView.setLayoutManager(gridLayoutManager);
        recyclerView.setAdapter(adapter);
        imageFileLoader.loadDeviceImages(true, false, excludedImages, new ImageLoaderListener() {
            @Override
            public void onImageLoaded(List<Image> images, List<Folder> folders) {
                for (int i=0;i<images.size();i++){
                    listResource.add(images.get(i).getPath());
                }
                isCompleted=true;
            }
            @Override
            public void onFailed(Throwable throwable) {

            }
        },true,false,false,false);
        while (!isCompleted){
            adapter.notifyDataSetChanged();
        }
    }

    @Override
    public void onGetPath(String path) {
        Intent intent = new Intent(ShowGalleryActivity.this, ImageProcessActivity.class);
        intent.putExtra(CONST.INTENT.PATH_IMAGE, path);
        startActivity(intent);
    }
}
