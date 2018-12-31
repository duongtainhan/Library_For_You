package android.dienty.library_for_you;

import android.content.Intent;
import android.dienty.library_for_you.ReadingNews.SelectPage.activity.SelectPageActivity;
import android.dienty.library_for_you.ReadingNews.ViewNews.NewsFragment;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ImageView imgAnim1;
    ImageView imgAnim2;
    TextView txtDemo;
    TextView txtTeam;
    TextView txtName;
    CardView cardReading;
    CardView cardImageProcess;
    LinearLayout linearFunction;
    public static boolean showAnimation = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        InitView();
        InitValue();
        InitAction();
    }

    private void InitView()
    {
        imgAnim1 = findViewById(R.id.img_anim1);
        imgAnim2 = findViewById(R.id.img_anim2);
        txtDemo = findViewById(R.id.txtDemo);
        txtTeam = findViewById(R.id.txtTeam);
        txtName = findViewById(R.id.txtName);
        linearFunction = findViewById(R.id.linearFunction);
        cardReading = findViewById(R.id.cardReading);
        cardImageProcess = findViewById(R.id.cardImageProcess);
    }
    private void InitValue() {
    }
    private void InitAction() {
        if(showAnimation)
        {
            CreateAnimation();
            showAnimation=false;
        }
        ClickAnimationCardView();
    }

    private void CreateAnimation()
    {
        //AnimationAlpha ImageView
        AlphaAnimation alphaAnim1 = new AlphaAnimation(0,0.1f);
        alphaAnim1.setDuration(2369);
        alphaAnim1.setFillAfter(true);
        alphaAnim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgAnim2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AlphaAnimation alphaAnim2 = new AlphaAnimation(0,0.1f);
                alphaAnim2.setDuration(1999);
                alphaAnim2.setFillAfter(true);
                alphaAnim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imgAnim1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        //AnimationAlpha TextView
                        AlphaAnimation alphaTextDemo = new AlphaAnimation(0,1);
                        alphaTextDemo.setDuration(1369);
                        alphaTextDemo.setFillAfter(true);
                        alphaTextDemo.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {
                                txtDemo.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                AlphaAnimation alphaTextTeam = new AlphaAnimation(0,1);
                                alphaTextTeam.setDuration(1369);
                                alphaTextTeam.setFillAfter(true);
                                alphaTextTeam.setAnimationListener(new Animation.AnimationListener() {
                                    @Override
                                    public void onAnimationStart(Animation animation) {
                                        txtTeam.setVisibility(View.VISIBLE);
                                    }

                                    @Override
                                    public void onAnimationEnd(Animation animation) {
                                        AlphaAnimation alphaTextName = new AlphaAnimation(0,1);
                                        alphaTextName.setDuration(1369);
                                        alphaTextName.setFillAfter(true);
                                        alphaTextName.setAnimationListener(new Animation.AnimationListener() {
                                            @Override
                                            public void onAnimationStart(Animation animation) {
                                                txtName.setVisibility(View.VISIBLE);
                                            }

                                            @Override
                                            public void onAnimationEnd(Animation animation) {
                                                AlphaAnimation alphaLinear = new AlphaAnimation(0,1);
                                                alphaLinear.setDuration(1999);
                                                alphaLinear.setFillAfter(true);
                                                alphaLinear.setAnimationListener(new Animation.AnimationListener() {
                                                    @Override
                                                    public void onAnimationStart(Animation animation) {
                                                        linearFunction.setVisibility(View.VISIBLE);
                                                    }

                                                    @Override
                                                    public void onAnimationEnd(Animation animation) {

                                                    }

                                                    @Override
                                                    public void onAnimationRepeat(Animation animation) {

                                                    }
                                                });
                                                linearFunction.startAnimation(alphaLinear);
                                            }

                                            @Override
                                            public void onAnimationRepeat(Animation animation) {

                                            }
                                        });
                                        txtName.startAnimation(alphaTextName);
                                    }

                                    @Override
                                    public void onAnimationRepeat(Animation animation) {

                                    }
                                });
                                txtTeam.startAnimation(alphaTextTeam);
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {

                            }
                        });
                        txtDemo.startAnimation(alphaTextDemo);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {

                    }
                });
                imgAnim1.startAnimation(alphaAnim2);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        imgAnim2.startAnimation(alphaAnim1);
    }
    private void ClickAnimationCardView()
    {
        AlphaAnimation alphaReading = new AlphaAnimation(1,0.1f);
        alphaReading.setDuration(123);
        alphaReading.setRepeatCount(1);
        alphaReading.setRepeatMode(Animation.REVERSE);
        alphaReading.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(MainActivity.this,SelectPageActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cardReading.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardReading.startAnimation(alphaReading);
            }
        });

        AlphaAnimation alphaImageProcess = new AlphaAnimation(1, 0.1f);
        alphaImageProcess.setDuration(123);
        alphaImageProcess.setRepeatCount(1);
        alphaImageProcess.setRepeatMode(Animation.REVERSE);
        alphaImageProcess.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        cardImageProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cardImageProcess.startAnimation(alphaImageProcess);
            }
        });
    }
}
