package android.dienty.library_for_you.ImageProcessing;

import android.content.Context;
import android.dienty.library_for_you.R;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import java.util.List;

public class ListProcessAdapter extends RecyclerView.Adapter<ListProcessAdapter.ViewHolder> {
    Context context;
    List<Bitmap> listBitmap;
    ClickProcessListener clickProcessListener;

    public ListProcessAdapter(Context context, List<Bitmap> listBitmap) {
        this.context = context;
        this.listBitmap = listBitmap;
        clickProcessListener = (ClickProcessListener) context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.item_photo, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.imageView.setImageBitmap(listBitmap.get(i));
        viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickProcessListener.onGetClick(viewHolder.getAdapterPosition());
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBitmap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.iv_photo);
        }
    }
}
