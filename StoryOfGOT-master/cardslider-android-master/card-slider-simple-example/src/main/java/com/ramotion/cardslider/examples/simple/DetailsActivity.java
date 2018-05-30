package com.ramotion.cardslider.examples.simple;

import android.animation.ObjectAnimator;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.transition.Transition;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;

import com.ramotion.cardslider.examples.simple.utils.DecodeBitmapTask;

public class DetailsActivity extends AppCompatActivity implements DecodeBitmapTask.Listener {

//    static final String BUNDLE_IMAGE_ID = "BUNDLE_IMAGE_ID";
    public static final String BUNDLE_IMAGE_ID = "BUNDLE_IMAGE_ID";


    private ImageView imageView;
    private DecodeBitmapTask decodeBitmapTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final int smallResId = getIntent().getIntExtra(BUNDLE_IMAGE_ID, -1);
        if (smallResId == -1) {
            finish();
            return;
        }

        imageView = (ImageView)findViewById(R.id.image);
        imageView.setImageResource(smallResId);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DetailsActivity.super.onBackPressed();
            }
        });

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            loadFullSizeBitmap(smallResId);
        } else {
            getWindow().getSharedElementEnterTransition().addListener(new Transition.TransitionListener() {

                private boolean isClosing = false;

                @Override public void onTransitionPause(Transition transition) {}
                @Override public void onTransitionResume(Transition transition) {}
                @Override public void onTransitionCancel(Transition transition) {}

                @Override public void onTransitionStart(Transition transition) {
                    if (isClosing) {
                        addCardCorners();
                    }
                }

                @Override public void onTransitionEnd(Transition transition) {
                    if (!isClosing) {
                        isClosing = true;

                        removeCardCorners();
                        loadFullSizeBitmap(smallResId);
                    }
                }
            });
        }
    }

    @Override
    protected void onPause() {
        super.onPause();

        if (isFinishing() && decodeBitmapTask != null) {
            decodeBitmapTask.cancel(true);
        }
    }

    private void addCardCorners() {
        final CardView cardView = (CardView) findViewById(R.id.card);
        cardView.setRadius(25f);
    }

    private void removeCardCorners() {
        final CardView cardView = (CardView)findViewById(R.id.card);
        ObjectAnimator.ofFloat(cardView, "radius", 0f).setDuration(50).start();
    }

    private void loadFullSizeBitmap(int smallResId) {
        int bigResId;
        switch (smallResId) {
            case R.drawable.s1e1: bigResId = R.drawable.s1e1; break;
            case R.drawable.s1e2: bigResId = R.drawable.s1e2; break;
            case R.drawable.s1e3: bigResId = R.drawable.s1e3; break;
            case R.drawable.s1e4: bigResId = R.drawable.s1e4; break;
            case R.drawable.s1e5: bigResId = R.drawable.s1e5; break;
            case R.drawable.s1e6: bigResId = R.drawable.s1e6; break;
            case R.drawable.s1e7: bigResId = R.drawable.s1e7; break;
            case R.drawable.s1e8: bigResId = R.drawable.s1e8; break;
            case R.drawable.s1e9: bigResId = R.drawable.s1e9; break;
            case R.drawable.s1e10: bigResId = R.drawable.s1e10; break;


            case R.drawable.s2e1: bigResId = R.drawable.s2e1; break;
            case R.drawable.s2e2: bigResId = R.drawable.s2e2; break;
            case R.drawable.s2e3: bigResId = R.drawable.s2e3; break;
            case R.drawable.s2e4: bigResId = R.drawable.s2e4; break;
            case R.drawable.s2e5: bigResId = R.drawable.s2e5; break;
            case R.drawable.s2e6: bigResId = R.drawable.s2e6; break;
            case R.drawable.s2e7: bigResId = R.drawable.s2e7; break;
            case R.drawable.s2e8: bigResId = R.drawable.s2e8; break;
            case R.drawable.s2e9: bigResId = R.drawable.s2e9; break;
            case R.drawable.s2e10: bigResId = R.drawable.s2e10; break;


            case R.drawable.s3e1: bigResId = R.drawable.s3e1; break;
            case R.drawable.s3e2: bigResId = R.drawable.s3e2; break;
            case R.drawable.s3e3: bigResId = R.drawable.s3e3; break;
            case R.drawable.s3e4: bigResId = R.drawable.s3e4; break;
            case R.drawable.s3e5: bigResId = R.drawable.s3e5; break;
            case R.drawable.s3e6: bigResId = R.drawable.s3e6; break;
            case R.drawable.s3e7: bigResId = R.drawable.s3e7; break;
            case R.drawable.s3e8: bigResId = R.drawable.s3e8; break;
            case R.drawable.s3e9: bigResId = R.drawable.s3e9; break;
            case R.drawable.s3e10: bigResId = R.drawable.s3e10; break;



            case R.drawable.s4e1: bigResId = R.drawable.s4e1; break;
            case R.drawable.s4e2: bigResId = R.drawable.s4e2; break;
            case R.drawable.s4e3: bigResId = R.drawable.s4e3; break;
            case R.drawable.s4e4: bigResId = R.drawable.s4e4; break;
            case R.drawable.s4e5: bigResId = R.drawable.s4e5; break;
            case R.drawable.s4e6: bigResId = R.drawable.s4e6; break;
            case R.drawable.s4e7: bigResId = R.drawable.s4e7; break;
            case R.drawable.s4e8: bigResId = R.drawable.s4e8; break;
            case R.drawable.s4e9: bigResId = R.drawable.s4e9; break;
            case R.drawable.s4e10: bigResId = R.drawable.s4e10; break;


            case R.drawable.s5e1: bigResId = R.drawable.s5e1; break;
            case R.drawable.s5e2: bigResId = R.drawable.s5e2; break;
            case R.drawable.s5e3: bigResId = R.drawable.s5e3; break;
            case R.drawable.s5e4: bigResId = R.drawable.s5e4; break;
            case R.drawable.s5e5: bigResId = R.drawable.s5e5; break;
            case R.drawable.s5e6: bigResId = R.drawable.s5e6; break;
            case R.drawable.s5e7: bigResId = R.drawable.s5e7; break;
            case R.drawable.s5e8: bigResId = R.drawable.s5e8; break;
            case R.drawable.s5e9: bigResId = R.drawable.s5e9; break;
            case R.drawable.s5e10: bigResId = R.drawable.s5e10; break;


            case R.drawable.s6e1: bigResId = R.drawable.s6e1; break;
            case R.drawable.s6e2: bigResId = R.drawable.s6e2; break;
            case R.drawable.s6e3: bigResId = R.drawable.s6e3; break;
            case R.drawable.s6e4: bigResId = R.drawable.s6e4; break;
            case R.drawable.s6e5: bigResId = R.drawable.s6e5; break;
            case R.drawable.s6e6: bigResId = R.drawable.s6e6; break;
            case R.drawable.s6e7: bigResId = R.drawable.s6e7; break;
            case R.drawable.s6e8: bigResId = R.drawable.s6e8; break;
            case R.drawable.s6e9: bigResId = R.drawable.s6e9; break;
            case R.drawable.s6e10: bigResId = R.drawable.s6e10; break;


            case R.drawable.s7e1: bigResId = R.drawable.s7e1; break;
            case R.drawable.s7e2: bigResId = R.drawable.s7e2; break;
            case R.drawable.s7e3: bigResId = R.drawable.s7e3; break;
            case R.drawable.s7e4: bigResId = R.drawable.s7e4; break;
            case R.drawable.s7e5: bigResId = R.drawable.s7e5; break;
            case R.drawable.s7e6: bigResId = R.drawable.s7e6; break;
            case R.drawable.s7e7: bigResId = R.drawable.s7e7; break;

            default: bigResId = R.drawable.season1;
        }

        final DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getRealMetrics(metrics);

        final int w = metrics.widthPixels;
        final int h = metrics.heightPixels;

        decodeBitmapTask = new DecodeBitmapTask(getResources(), bigResId, w, h, this);
        decodeBitmapTask.execute();
    }

    @Override
    public void onPostExecuted(Bitmap bitmap) {
        imageView.setImageBitmap(bitmap);
    }

}
