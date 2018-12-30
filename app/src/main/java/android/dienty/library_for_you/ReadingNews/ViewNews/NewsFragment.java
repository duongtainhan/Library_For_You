package android.dienty.library_for_you.ReadingNews.ViewNews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.dienty.foryou.ReadNews.FeedItem;
import android.dienty.foryou.ReadNews.TypePage;
import android.dienty.library_for_you.CONST;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.dienty.library_for_you.R;

@SuppressLint("ValidFragment")
public class NewsFragment extends Fragment {

    private List<FeedItem> feedItems = new ArrayList<>();
    View view;
    NewsAdapter newsAdapter;
    AdapterOtherType adapterOtherType;
    String url;
    String page_name;
    ListView listView;

    public NewsFragment(String url, String page_name) {
        this.url = url;
        this.page_name = page_name;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_news, container, false);
        listView = view.findViewById(R.id.listView);
        feedItems = new ArrayList<>();
        new LoadRss().execute(url);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent intentNews = new Intent(view.getContext(), WebActivity.class);
                //intentNews.putExtra("link", feedItems.get(position).getLink());
                //startActivity(intentNews);
            }
        });
        return view;
    }

    private class LoadRss extends AsyncTask<String, Void, ArrayList<FeedItem>> {
        @Override
        protected ArrayList<FeedItem> doInBackground(String... params) {

            String url_rss = params[0];

            switch (page_name) {
                case CONST.NAME_PAGE.VN_EXPRESS:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.DAN_TRI:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.HAI_TU_GIO:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.KENH_14:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.VIETNAM_NET:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.DOI_SONG:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.NGOI_SAO:
                    ReadRss(url_rss);
                    break;
                case CONST.NAME_PAGE.GENK:
                    ReadRss(url_rss);
                    break;
            }

            return (ArrayList<FeedItem>) feedItems;
        }

        @Override
        protected void onPostExecute(ArrayList<FeedItem> feedItems) {
            if (page_name.equals(CONST.NAME_PAGE.DAN_TRI)) {
                adapterOtherType = new AdapterOtherType(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, feedItems);
                listView.setAdapter(adapterOtherType);
            } else {
                newsAdapter = new NewsAdapter(Objects.requireNonNull(getActivity()), android.R.layout.simple_list_item_1, feedItems);
                listView.setAdapter(newsAdapter);
            }
            super.onPostExecute(feedItems);
        }
        private void ReadRss(String urlRSS)
        {
            TypePage typePage = new TypePage(urlRSS);
            feedItems = typePage.getAllItems();
        }
    }
}
