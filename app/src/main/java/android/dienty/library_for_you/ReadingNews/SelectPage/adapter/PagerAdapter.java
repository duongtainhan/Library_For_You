package android.dienty.library_for_you.ReadingNews.SelectPage.adapter;

import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.ReadingNews.SelectPage.fragment.ListPagesFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

public class PagerAdapter extends FragmentPagerAdapter {
    private int numOfTabs;
    public PagerAdapter(FragmentManager fm, int numOfTabs) {
        super(fm);
        this.numOfTabs = numOfTabs;
    }

    @Override
    public Fragment getItem(int i) {
        switch (i) {
            case 0:
                return new ListPagesFragment(CONST.TYPE_PAGE.VIET_NAM);
            case 1:
                return new ListPagesFragment(CONST.TYPE_PAGE.INTERNATIONAL);
            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return numOfTabs;
    }

}