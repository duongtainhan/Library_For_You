package android.dienty.library_for_you.ReadingNews.SelectPage.fragment;

import android.annotation.SuppressLint;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.R;
import android.dienty.library_for_you.ReadingNews.SelectPage.adapter.PageItemAdapter;
import android.dienty.library_for_you.ReadingNews.SelectPage.activity.SelectPageActivity;
import android.dienty.library_for_you.ReadingNews.SelectPage.models.PageItem;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class ListPagesFragment extends Fragment {

    View view;
    String typePage;
    RecyclerView recyclerView;

    @SuppressLint("ValidFragment")
    public ListPagesFragment(String typePage) {
        this.typePage = typePage;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_list_pages, container, false);
        recyclerView = view.findViewById(R.id.recycler);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if(typePage.equals(CONST.TYPE_PAGE.VIET_NAM))
        {
            List<PageItem> pageItems = new ArrayList<>();
            pageItems.add(new PageItem(CONST.NAME_PAGE.VN_EXPRESS,R.drawable.vn_express));
            pageItems.add(new PageItem(CONST.NAME_PAGE.DAN_TRI,R.drawable.dan_tri));
            pageItems.add(new PageItem(CONST.NAME_PAGE.HAI_TU_GIO,R.drawable.hai_tu_gio));
            pageItems.add(new PageItem(CONST.NAME_PAGE.KENH_14,R.drawable.kenh_14));
            pageItems.add(new PageItem(CONST.NAME_PAGE.VIETNAM_NET,R.drawable.vietnam_net));
            pageItems.add(new PageItem(CONST.NAME_PAGE.NGOI_SAO,R.drawable.ngoi_sao));
            pageItems.add(new PageItem(CONST.NAME_PAGE.GENK,R.drawable.genk));
            PageItemAdapter pageItemAdapter = new PageItemAdapter(getContext(), pageItems);
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(pageItemAdapter);
        }
        else
        {
            List<PageItem> pageItems = new ArrayList<>();
            pageItems.add(new PageItem(CONST.NAME_PAGE.VN_EXPRESS,R.drawable.vn_express));
            pageItems.add(new PageItem(CONST.NAME_PAGE.DAN_TRI,R.drawable.dan_tri));
            pageItems.add(new PageItem(CONST.NAME_PAGE.HAI_TU_GIO,R.drawable.hai_tu_gio));
            pageItems.add(new PageItem(CONST.NAME_PAGE.KENH_14,R.drawable.kenh_14));
            pageItems.add(new PageItem(CONST.NAME_PAGE.VIETNAM_NET,R.drawable.vietnam_net));
            pageItems.add(new PageItem(CONST.NAME_PAGE.NGOI_SAO,R.drawable.ngoi_sao));
            pageItems.add(new PageItem(CONST.NAME_PAGE.GENK,R.drawable.genk));
            PageItemAdapter pageItemAdapter = new PageItemAdapter(getContext(), pageItems);
            GridLayoutManager layoutManager = new GridLayoutManager(getContext(), 3);
            recyclerView.setLayoutManager(layoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(pageItemAdapter);
        }
    }
}