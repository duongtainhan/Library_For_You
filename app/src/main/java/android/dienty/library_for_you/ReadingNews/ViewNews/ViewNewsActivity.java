package android.dienty.library_for_you.ReadingNews.ViewNews;

import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.R;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

public class ViewNewsActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private RelativeLayout relativeBack;
    private PagerAdapter pagerAdapter;
    private List<Fragment> listFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_news);

        InitView();
        SetPage();
    }
    private void InitView()
    {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        relativeBack = findViewById(R.id.relativeBackPage);
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
    private void SetPage() {
        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        listFragment = new ArrayList<>();
        String page_selected = "";
        if (getIntent() != null) {
            page_selected = getIntent().getStringExtra(CONST.INTENT.PAGE_SELECTED);
            Log.d("GET_PAGE_VIEWNEWS",page_selected);
        }
        switch (page_selected) {
            case CONST.NAME_PAGE.VN_EXPRESS:
                PageVnExpress();
                Log.d("GET_PAGE_NEWS","VN_EXPRESS");
                break;
            case CONST.NAME_PAGE.DAN_TRI:
                PageDanTri();
                break;
            case CONST.NAME_PAGE.HAI_TU_GIO:
                Page24h();
                break;
            case CONST.NAME_PAGE.KENH_14:
                PageKenh14();
                break;
            case CONST.NAME_PAGE.VIETNAM_NET:
                PageVietNameNet();
                break;
            case CONST.NAME_PAGE.NGOI_SAO:
                PageNgoiSao();
                break;
            case CONST.NAME_PAGE.GENK:
                PageGenk();
                break;
        }
        viewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void PageVnExpress() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.vn_express; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.vn_express[i], CONST.NAME_PAGE.VN_EXPRESS);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.vn_express[i]);
            listFragment.add(newsFragment);
        }
    }

    private void PageDanTri() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.dan_tri; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.dan_tri[i], CONST.NAME_PAGE.DAN_TRI);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.dan_tri[i]);
            listFragment.add(newsFragment);
        }
    }

    private void Page24h() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.hai_tu_gio; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.hai_tu_gio[i], CONST.NAME_PAGE.HAI_TU_GIO);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.hai_tu_gio[i]);
            listFragment.add(newsFragment);
        }
    }

    private void PageKenh14() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.kenh_14; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.kenh_14[i], CONST.NAME_PAGE.KENH_14);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.kenh_14[i]);
            listFragment.add(newsFragment);
        }
    }

    private void PageVietNameNet() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.vietnam_net; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.vietnam_net[i], CONST.NAME_PAGE.VIETNAM_NET);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.vietnam_net[i]);
            listFragment.add(newsFragment);
        }
    }

    private void PageNgoiSao() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.ngoi_sao; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.ngoi_sao[i], CONST.NAME_PAGE.NGOI_SAO);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.ngoi_sao[i]);
            listFragment.add(newsFragment);
        }
    }

    private void PageGenk() {
        listFragment.clear();
        for (int i = 0; i < CONST.DATA.length.genk; i++) {
            NewsFragment newsFragment = new NewsFragment(CONST.DATA.url.genk[i], CONST.NAME_PAGE.GENK);
            pagerAdapter.AddFragment(newsFragment, CONST.DATA.title.genk[i]);
            listFragment.add(newsFragment);
        }
    }
}
