package android.dienty.library_for_you.ImageProcessing;

import android.content.Context;
import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;
import android.dienty.library_for_you.R;

public class AddPhotoAdapter extends RecyclerView.Adapter<AddPhotoAdapter.ViewHolder> {
    List<String> listFrameAsset;
    Context context;
    GetPathListener getPathListener;

    public AddPhotoAdapter(ArrayList<String> listFrameAsset, Context context) {
        this.context = context;
        this.listFrameAsset =listFrameAsset;
        getPathListener = (GetPathListener) context;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.item_photo_library, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
          Glide.with(context).load(listFrameAsset.get(position)).into(holder.imageView);
          holder.imageView.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  getPathListener.onGetPath(listFrameAsset.get(position));
              }
          });
       }
    @Override
    public int getItemCount() {
        return listFrameAsset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_photobackground);
        }
    }
}