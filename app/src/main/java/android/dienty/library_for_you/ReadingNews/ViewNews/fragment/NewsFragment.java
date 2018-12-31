package android.dienty.library_for_you.ReadingNews.ViewNews.fragment;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.dienty.foryou.ReadNews.FeedItem;
import android.dienty.foryou.ReadNews.TypePage;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.ReadingNews.ViewNews.adapter.AdapterOtherType;
import android.dienty.library_for_you.ReadingNews.ViewNews.adapter.NewsAdapter;
import android.dienty.library_for_you.ReadingNews.WebView.WebViewActivity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

import android.dienty.library_for_you.R;

@SuppressLint("ValidFragment")
public class NewsFragment extends Fragment {

    TypePage typePage = new TypePage();
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
        new LoadRss().execute(url);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentNews = new Intent(view.getContext(), WebViewActivity.class);
                intentNews.putExtra(CONST.INTENT.LINK, typePage.getFeedItemList().get(position).getLink());
                startActivity(intentNews);
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
                    ReadRss_VnExpress(url_rss);
                    break;
                case CONST.NAME_PAGE.DAN_TRI:
                    ReadRss_DanTri(url_rss);
                    break;
                case CONST.NAME_PAGE.HAI_TU_GIO:
                    ReadRss_24H(url_rss);
                    break;
                case CONST.NAME_PAGE.KENH_14:
                    ReadRss_Kenh14(url_rss);
                    break;
                case CONST.NAME_PAGE.VIETNAM_NET:
                    ReadRss_VietNamNet(url_rss);
                    break;
                case CONST.NAME_PAGE.NGOI_SAO:
                    ReadRss_NgoiSao(url_rss);
                    break;
                case CONST.NAME_PAGE.GENK:
                    ReadRss_Genk(url_rss);
                    break;
            }

            return typePage.getFeedItemList();
        }

        @Override
        protected void onPostExecute(ArrayList<FeedItem> feedItems) {
            if (page_name.equals(CONST.NAME_PAGE.DAN_TRI)) {
                if(getActivity()!=null)
                {
                    adapterOtherType = new AdapterOtherType(getActivity(), android.R.layout.simple_list_item_1, feedItems);
                    listView.setAdapter(adapterOtherType);
                }
            } else {
                if(getActivity()!=null)
                {
                    newsAdapter = new NewsAdapter(getActivity(), android.R.layout.simple_list_item_1, feedItems);
                    listView.setAdapter(newsAdapter);
                }
            }
            super.onPostExecute(feedItems);
        }
        private void ReadRss_VnExpress(String urlRSS)
        {
            typePage.getPageVnExpress(urlRSS);
        }
        private void ReadRss_DanTri(String urlRSS)
        {
            typePage.getPageDanTri(urlRSS);
        }
        private void ReadRss_24H(String urlRSS)
        {
            typePage.getPage24H(urlRSS);
        }
        private void ReadRss_Kenh14(String urlRSS)
        {
            typePage.getPageKenh14(urlRSS);
        }
        private void ReadRss_VietNamNet(String urlRSS)
        {
            typePage.getPageVietNam(urlRSS);
        }
        private void ReadRss_NgoiSao(String urlRSS)
        {
            typePage.getPageNgoiSao(urlRSS);
        }
        private void ReadRss_Genk(String urlRSS)
        {
            typePage.getPageGenk(urlRSS);
        }
    }
}
