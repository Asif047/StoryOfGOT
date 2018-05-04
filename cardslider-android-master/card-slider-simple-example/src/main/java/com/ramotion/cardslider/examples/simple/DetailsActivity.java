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
