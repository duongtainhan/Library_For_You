package android.dienty.library_for_you;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ImageView imgAnim1;
    ImageView imgAnim2;
    TextView txtDemo;
    TextView txtTeam;
    TextView txtName;

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
    }
    private void InitValue() {

    }
    private void InitAction() {
        CreateAnimation();
    }

    private void CreateAnimation()
    {
        //AnimationAlpha ImageView
        AlphaAnimation alphaAnim1 = new AlphaAnimation(0,0.1f);
        alphaAnim1.setDuration(2000);
        alphaAnim1.setFillAfter(true);
        alphaAnim1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                imgAnim2.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                AlphaAnimation alphaAnim2 = new AlphaAnimation(0,0.1f);
                alphaAnim2.setDuration(2000);
                alphaAnim2.setFillAfter(true);
                alphaAnim2.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        imgAnim1.setVisibility(View.VISIBLE);
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {

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

}
