package android.dienty.library_for_you.ImageProcessing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.dienty.library_for_you.ImageProcessing.CloseFragmentListener;
import android.dienty.library_for_you.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

@SuppressLint("ValidFragment")
public class OptionProcessFragment extends Fragment {

    View view;
    RelativeLayout relativeOption1;
    RelativeLayout relativeOption2;
    RelativeLayout relativeOption3;
    RelativeLayout relativeOption4;
    RelativeLayout relativeMain;
    boolean enableOption1;
    boolean enableOption2;
    boolean enableOption3;
    boolean enableOption4;
    Context context;
    CloseFragmentListener closeFragmentListener;

    @SuppressLint("ValidFragment")
    public OptionProcessFragment(Context context, boolean enableOption1, boolean enableOption2, boolean enableOption3, boolean enableOption4) {
        this.enableOption1 = enableOption1;
        this.enableOption2 = enableOption2;
        this.enableOption3 = enableOption3;
        this.enableOption4 = enableOption4;
        this.context = context;
        closeFragmentListener = (CloseFragmentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_option_process,container,false);
        relativeOption1 = view.findViewById(R.id.relativeOption1);
        relativeOption2 = view.findViewById(R.id.relativeOption2);
        relativeOption3 = view.findViewById(R.id.relativeOption3);
        relativeOption4 = view.findViewById(R.id.relativeOption4);
        relativeMain = view.findViewById(R.id.relativeMain);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        relativeMain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                closeFragmentListener.onClickOutSide(true);
            }
        });
        if(!enableOption4)
        {
            relativeOption4.setVisibility(View.GONE);
        }
        if(!enableOption3)
        {
            relativeOption3.setVisibility(View.GONE);
        }
        if(!enableOption2)
        {
            relativeOption2.setVisibility(View.GONE);
        }
        if(!enableOption1)
        {
            relativeOption1.setVisibility(View.GONE);
        }
    }
}
