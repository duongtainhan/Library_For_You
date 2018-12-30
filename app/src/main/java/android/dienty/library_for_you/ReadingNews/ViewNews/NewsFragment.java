package android.dienty.library_for_you.ReadingNews.ViewNews;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.dienty.foryou.ReadNews.FeedItem;
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

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
                case "zing_news":
                    //SetPageZing(url_rss);
                    break;
                case "vn_express":
                   // SetPageVnExpress(url_rss);
                    break;
                case "dan_tri":
                    //SetPageDanTri(url_rss);
                    break;
                case "24h":
                    //SetPage24h(url_rss);
                    break;
                case "kenh_14":
                    //SetPageKenh14(url_rss);
                    break;
                case "vietnam_net":
                    //SetPageVietNam(url_rss);
                    break;
                case "doi_song":
                    //SetPageDoiSong(url_rss);
                    break;
                case "nguoi_dua_tin":
                    //SetPageNguoiDuaTin(url_rss);
                    break;
                case "ngoi_sao":
                    //SetPageNgoiSao(url_rss);
                    break;
                case "genk":
                    //SetPageGenk(url_rss);
                    break;
                case "so_ha":
                    //SetPageSoHa(url_rss);
                    break;
                case "vov":
                    //SetPageVov(url_rss);
                    break;
            }

            return (ArrayList<FeedItem>) feedItems;
        }

        @Override
        protected void onPostExecute(ArrayList<FeedItem> feedItems) {
            if (page_name.equals("dan_tri") || page_name.equals("so_ha") || page_name.equals("vov")) {
                adapterOtherType = new AdapterOtherType(getActivity(), android.R.layout.simple_list_item_1, feedItems);
                listView.setAdapter(adapterOtherType);
            } else {
                newsAdapter = new NewsAdapter(getActivity(), android.R.layout.simple_list_item_1, feedItems);
                listView.setAdapter(newsAdapter);
            }
            super.onPostExecute(feedItems);
        }
    }
}
