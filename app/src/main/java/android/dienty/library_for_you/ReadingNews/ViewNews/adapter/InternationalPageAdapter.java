package android.dienty.library_for_you.ReadingNews.ViewNews.adapter;

import android.content.Context;
import android.content.Intent;
import android.dienty.foryou.ReadNews.FeedItem;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.R;
import android.dienty.library_for_you.ReadingNews.SearchYoutube.SearchYoutubeActivity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.TextView;

import java.util.List;

public class InternationalPageAdapter extends ArrayAdapter<FeedItem> {
    private ImageView imgOption;

    public InternationalPageAdapter(@NonNull Context context, int resource, @NonNull List<FeedItem> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable final View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            view = inflater.inflate(R.layout.layout_international, null);
        }
        FeedItem feedItem = getItem(position);
        if (feedItem != null) {
            // Anh xa + Gan gia tri
            TextView txtTitle = view.findViewById(R.id.txtTitle);
            txtTitle.setText(feedItem.getTitle());
            Log.d("TITLE", feedItem.getTitle());
            TextView txtDescription = view.findViewById(R.id.txtDescription);
            txtDescription.setText(feedItem.getDescription());

            imgOption = view.findViewById(R.id.imgOption);
            imgOption.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    final PopupMenu popupMenu = new PopupMenu(getContext(), v);
                    popupMenu.getMenuInflater().inflate(R.menu.popup_menu, popupMenu.getMenu());
                    popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                        @Override
                        public boolean onMenuItemClick(MenuItem item) {
                            if (item.getItemId() == R.id.itemSearch) {
                                Intent intent = new Intent(getContext(), SearchYoutubeActivity.class);
                                intent.putExtra(CONST.INTENT.KEY_SEARCH, feedItem.getTitle());
                                getContext().startActivity(intent);
                            }
                            return true;
                        }
                    });
                    popupMenu.show();
                }
            });
        }
        return view;
    }
}
