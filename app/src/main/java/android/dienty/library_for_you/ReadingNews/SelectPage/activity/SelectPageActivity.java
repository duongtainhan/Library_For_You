package android.dienty.library_for_you.ReadingNews.SelectPage.activity;

import android.dienty.library_for_you.R;
import android.dienty.library_for_you.ReadingNews.SelectPage.adapter.PagerAdapter;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

public class SelectPageActivity extends AppCompatActivity {

    ViewPager viewPager;
    TabLayout tabLayout;
    RelativeLayout relativeBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_page);
        InitView();
    }
    private void InitView()
    {
        viewPager = findViewById(R.id.viewPagerSelectPage);
        tabLayout = findViewById(R.id.tabSelectPage);
        relativeBack = findViewById(R.id.rl_back);
        relativeBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        InitViewPager();
    }
    private void InitViewPager() {
        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
    }
}
