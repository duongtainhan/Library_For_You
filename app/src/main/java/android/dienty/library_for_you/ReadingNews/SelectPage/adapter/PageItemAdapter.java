package android.dienty.library_for_you.ReadingNews.SelectPage.adapter;

import android.content.Context;
import android.content.Intent;
import android.dienty.library_for_you.CONST;
import android.dienty.library_for_you.R;
import android.dienty.library_for_you.ReadingNews.SelectPage.models.PageItem;
import android.dienty.library_for_you.ReadingNews.ViewNews.ViewNewsActivity;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class PageItemAdapter extends RecyclerView.Adapter<PageItemAdapter.ViewHolder> {
    Context context;
    List<PageItem> pageItems;

    public PageItemAdapter(Context context, List<PageItem> pageItems) {
        this.context = context;
        this.pageItems = pageItems;
    }
    @NonNull
    @Override
    public PageItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_page,viewGroup,false);
        return new PageItemAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        PageItem pageItem = pageItems.get(i);
        viewHolder.txtNamePage.setText(pageItem.getNamePage());
        viewHolder.imgThumnailPage.setImageResource(pageItem.getThumnailPage());
        viewHolder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String page_selected="";
                switch (viewHolder.getAdapterPosition())
                {
                    case 0:
                        page_selected=CONST.NAME_PAGE.ZING_NEWS;
                        break;
                    case 1:
                        page_selected=CONST.NAME_PAGE.VN_EXPRESS;
                        break;
                    case 2:
                        page_selected=CONST.NAME_PAGE.DAN_TRI;
                        break;
                    case 3:
                        page_selected=CONST.NAME_PAGE.HAI_TU_GIO;
                        break;
                    case 4:
                        page_selected=CONST.NAME_PAGE.KENH_14;
                        break;
                    case 5:
                        page_selected=CONST.NAME_PAGE.VIETNAM_NET;
                        break;
                    case 6:
                        page_selected=CONST.NAME_PAGE.NGOI_SAO;
                        break;
                    case 7:
                        page_selected=CONST.NAME_PAGE.GENK;
                        break;
                }
                Intent intent = new Intent(context,ViewNewsActivity.class);
                intent.putExtra(CONST.INTENT.PAGE_SELECTED,page_selected);
                context.startActivity(intent);
            }
        });
    }


    @Override
    public int getItemCount() {
        return pageItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtNamePage;
        ImageView imgThumnailPage;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNamePage = itemView.findViewById(R.id.txtNamePage);
            imgThumnailPage = itemView.findViewById(R.id.imgThumnailPage);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}