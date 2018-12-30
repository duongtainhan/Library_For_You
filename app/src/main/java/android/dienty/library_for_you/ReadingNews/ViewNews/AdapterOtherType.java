package android.dienty.library_for_you.ReadingNews.ViewNews;

import android.content.Context;
import android.dienty.foryou.ReadNews.FeedItem;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;
import android.dienty.library_for_you.R;

public class AdapterOtherType extends ArrayAdapter<FeedItem> {

    public AdapterOtherType(@NonNull Context context, int resource, @NonNull List<FeedItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view =  inflater.inflate(R.layout.layout_other_type, null);
        }
        FeedItem feedItem = getItem(position);
        if (feedItem != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = view.findViewById(R.id.txtTypeTitle);
            txtTitle.setText(feedItem.getTitle());
            ImageView imgThumbnail = view.findViewById(R.id.imgTypeThumbnail);
            Glide.with(getContext()).load(feedItem.getThumbnail()).into(imgThumbnail);
        }
        return view;
    }
}