package android.dienty.library_for_you.ImageProcessing.fragment;

import android.annotation.SuppressLint;
import android.content.Context;
import android.dienty.library_for_you.ImageProcessing.BoostPercentChangeListener;
import android.dienty.library_for_you.ImageProcessing.BoostRadioChangeListener;
import android.dienty.library_for_you.ImageProcessing.CloseFragmentListener;
import android.dienty.library_for_you.R;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.SeekBar;

@SuppressLint("ValidFragment")
public class Type2Fragment extends Fragment {
    View view;
    RelativeLayout relativeMain;
    SeekBar seekBarPercent;
    RadioButton radioType1;
    RadioButton radioType2;
    RadioButton radioType3;
    BoostPercentChangeListener boostPercentChangeListener;
    BoostRadioChangeListener boostRadioChangeListener;
    CloseFragmentListener closeFragmentListener;
    Context context;

    @SuppressLint("ValidFragment")
    public Type2Fragment(Context context) {
        this.context = context;
        boostPercentChangeListener = (BoostPercentChangeListener) context;
        boostRadioChangeListener = (BoostRadioChangeListener) context;
        closeFragmentListener = (CloseFragmentListener) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_option_type2, container, false);
        seekBarPercent = view.findViewById(R.id.seekBarPercent);
        radioType1 = view.findViewById(R.id.radioType1);
        radioType2 = view.findViewById(R.id.radioType2);
        radioType3 = view.findViewById(R.id.radioType3);
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
        radioType1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radioType1.isChecked())
                {
                    radioType1.setChecked(true);
                }
                if(radioType1.isChecked())
                {
                    radioType2.setChecked(false);
                    radioType3.setChecked(false);
                }
                boostRadioChangeListener.onChangeRadio(1);
            }
        });
        radioType2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radioType2.isChecked())
                {
                    radioType2.setChecked(true);
                }
                if(radioType2.isChecked())
                {
                    radioType1.setChecked(false);
                    radioType3.setChecked(false);
                }
                boostRadioChangeListener.onChangeRadio(2);
            }
        });
        radioType3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!radioType3.isChecked())
                {
                    radioType3.setChecked(true);
                }
                if(radioType3.isChecked())
                {
                    radioType2.setChecked(false);
                    radioType1.setChecked(false);
                }
                boostRadioChangeListener.onChangeRadio(3);
            }
        });
        seekBarPercent.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                float percent;
                percent = progress;
                if(progress!=0)
                {
                    percent = (float) progress/100;
                }
                Log.d("BOOST: ",percent+"");
                boostPercentChangeListener.onChangePercent(percent);
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
