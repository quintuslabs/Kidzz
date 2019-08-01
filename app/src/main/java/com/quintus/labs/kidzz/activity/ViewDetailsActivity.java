package com.quintus.labs.kidzz.activity;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.quintus.labs.kidzz.R;


/**
 * Kidzz
 * https://github.com/quintuslabs/Kidzz
 * Created on 25-feb-2019.
 * Created by : Santosh Kumar Dash:- http://santoshdash.epizy.com
 */


public class ViewDetailsActivity extends AppCompatActivity {
    String name, title2, title3, title4;
    int image1, image2, image3, image4;
    ImageView imageView, img1, img2, img3;
    TextView title_tv;
    Animation animation;
    TextView splashText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        title2 = intent.getStringExtra("title2");
        title3 = intent.getStringExtra("title3");
        title4 = intent.getStringExtra("title4");
        image1 = intent.getIntExtra("image1", 0);
        image2 = intent.getIntExtra("image2", 0);
        image3 = intent.getIntExtra("image3", 0);
        image4 = intent.getIntExtra("image4", 0);

        img1 = findViewById(R.id.vda_image1);
        img2 = findViewById(R.id.vda_image2);
        img3 = findViewById(R.id.vda_image3);
        title_tv = findViewById(R.id.title_tv);

        final Bitmap image11 = BitmapFactory.decodeResource(getApplication().getResources(), image2);
        img1.setImageBitmap(image11);
        final Bitmap image22 = BitmapFactory.decodeResource(getApplication().getResources(), image3);
        img2.setImageBitmap(image22);
        final Bitmap image33 = BitmapFactory.decodeResource(getApplication().getResources(), image4);
        img3.setImageBitmap(image33);

        title_tv.setVisibility(View.INVISIBLE);

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(image11);
                title_tv.setVisibility(View.VISIBLE);
                title_tv.setText(title2);
                StartAnimations();

                RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                rotate.setDuration(1000);
                rotate.setInterpolator(new LinearInterpolator());
                imageView.startAnimation(rotate);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(image22);
                title_tv.setText(title3);
                StartAnimations();

                Animation slideDown = new TranslateAnimation(
                        Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                        0.0f, Animation.RELATIVE_TO_SELF, -1.0f,
                        Animation.RELATIVE_TO_SELF, 0.0f);
                slideDown.setDuration(800);
                imageView.setAnimation(slideDown);


            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView.setImageBitmap(image33);
                title_tv.setText(title4);
                StartAnimations();

                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setStartOffset(2000);
                fadeOut.setDuration(2000);

                AnimationSet animation = new AnimationSet(false); //change to false

                animation.addAnimation(fadeOut);
                imageView.setAnimation(animation);


            }
        });

        final Bitmap image = BitmapFactory.decodeResource(getApplication().getResources(),
                image1);
        imageView = findViewById(R.id.vda_backdrop);
        imageView.setImageBitmap(image);

        ObjectAnimator animation = ObjectAnimator.ofFloat(imageView, "rotationY", 0.0f, 360f);
        animation.setDuration(1000);
        animation.setRepeatCount(0);
        animation.setInterpolator(new AccelerateDecelerateInterpolator());
        animation.start();

    }


    public void onBackPressed(View view) {
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }

    private void StartAnimations() {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.alpha);
        anim.reset();
        RelativeLayout l = findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        anim = AnimationUtils.loadAnimation(this, R.anim.animation_slide_up);
        anim.reset();
        TextView iv = findViewById(R.id.title_tv);
        iv.clearAnimation();
        iv.startAnimation(anim);
    }

}
