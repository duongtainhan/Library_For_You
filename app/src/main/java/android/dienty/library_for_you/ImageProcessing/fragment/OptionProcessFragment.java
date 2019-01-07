package android.dienty.library_for_you.ImageProcessing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.dienty.library_for_you.ImageProcessing.CloseFragmentListener;
import android.dienty.library_for_you.ImageProcessing.SB1ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB2ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB3ChangeListener;
import android.dienty.library_for_you.ImageProcessing.SB4ChangeListener;
import android.dienty.library_for_you.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

@SuppressLint("ValidFragment")
public class OptionProcessFragment extends Fragment {

    View view;
    RelativeLayout relativeOption1;
    RelativeLayout relativeOption2;
    RelativeLayout relativeOption3;
    RelativeLayout relativeOption4;
    RelativeLayout relativeMain;
    SeekBar seekBarOption1;
    SeekBar seekBarOption2;
    SeekBar seekBarOption3;
    SeekBar seekBarOption4;
    TextView textViewOption1;
    TextView textViewOption2;
    TextView textViewOption3;
    TextView textViewOption4;

    boolean enableOption1;
    boolean enableOption2;
    boolean enableOption3;
    boolean enableOption4;
    String sOption;
    Context context;
    CloseFragmentListener closeFragmentListener;
    SB1ChangeListener sb1ChangeListener;
    SB2ChangeListener sb2ChangeListener;
    SB3ChangeListener sb3ChangeListener;
    SB4ChangeListener sb4ChangeListener;

    @SuppressLint("ValidFragment")
    public OptionProcessFragment(Context context, boolean enableOption1, boolean enableOption2, boolean enableOption3, boolean enableOption4, String sOption) {
        this.enableOption1 = enableOption1;
        this.enableOption2 = enableOption2;
        this.enableOption3 = enableOption3;
        this.enableOption4 = enableOption4;
        this.sOption = sOption;
        this.context = context;
        closeFragmentListener = (CloseFragmentListener) context;
        if(enableOption1)
        {
            sb1ChangeListener = (SB1ChangeListener) context;
        }
        if(enableOption2)
        {
            sb2ChangeListener = (SB2ChangeListener) context;
        }
        if(enableOption3)
        {
            sb3ChangeListener = (SB3ChangeListener) context;
        }
        if(enableOption4)
        {
            sb4ChangeListener = (SB4ChangeListener) context;
        }
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
        seekBarOption1 = view.findViewById(R.id.seekBarOption1);
        seekBarOption2 = view.findViewById(R.id.seekBarOption2);
        seekBarOption3 = view.findViewById(R.id.seekBarOption3);
        seekBarOption4 = view.findViewById(R.id.seekBarOption4);
        textViewOption1 = view.findViewById(R.id.txtOption1);
        textViewOption2 = view.findViewById(R.id.txtOption2);
        textViewOption3 = view.findViewById(R.id.txtOption3);
        textViewOption4 = view.findViewById(R.id.txtOption4);
        textViewOption1.setText(sOption);
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
        seekBarOption1.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb1ChangeListener.onProcessChangeSB1(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarOption2.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb2ChangeListener.onProcessChangeSB2(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarOption3.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb3ChangeListener.onChangeProcessSB3(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        seekBarOption4.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                sb4ChangeListener.onChangeProcessSB4(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
