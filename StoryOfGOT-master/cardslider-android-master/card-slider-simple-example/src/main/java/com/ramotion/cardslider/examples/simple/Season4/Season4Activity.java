package com.ramotion.cardslider.examples.simple.Season4;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.ActivityOptions;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.support.annotation.StyleRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.ramotion.cardslider.CardSliderLayoutManager;
import com.ramotion.cardslider.CardSnapHelper;
import com.ramotion.cardslider.examples.simple.DetailsActivity;
import com.ramotion.cardslider.examples.simple.R;
import com.ramotion.cardslider.examples.simple.Season3.Season3Activity;
import com.ramotion.cardslider.examples.simple.cards.SliderAdapter;
import com.ramotion.cardslider.examples.simple.utils.DecodeBitmapTask;

public class Season4Activity extends AppCompatActivity {

    private final int[][] dotCoords = new int[5][2];
    private final int[] pics = {R.drawable.s4e1, R.drawable.s4e2, R.drawable.s4e3, R.drawable.s4e4,
            R.drawable.s4e5, R.drawable.s4e6, R.drawable.s4e7, R.drawable.s4e8,
            R.drawable.s4e9, R.drawable.s4e10};

    private final int[] descriptions = {R.string.texts4e1, R.string.texts4e2, R.string.texts4e3,
            R.string.texts4e4, R.string.texts4e5, R.string.texts4e6, R.string.texts4e7,
            R.string.texts4e8, R.string.texts4e9, R.string.texts4e10};

    private final String[] episode = {"Episode 1", "Episode 2", "Episode 3", "Episode 4",
            "Episode 5", "Episode 6", "Episode 7", "Episode 8", "Episode 9", "Episode 10"};

    private final String[] epiTitle = {"Two Swords", "The Lion and the Rose",
            "Breaker of Chains", "Oathkeeper", "First of His Name",
            "The Laws of Gods and Men", "Mockingbird", "The Mountain and the Viper",
            "The Watchers on the Wall", "The Children"};

    private final String[] epiNumber = {"S-4 E-1", "S-4 E-2", "S-4 E-3", "S-4 E-4", "S-4 E-5",
            "S-4 E-6", "S-4 E-7", "S-4 E-8", "S-4 E-9", "S-4 E-10"};
    private final String[] times = {"April 6, 2014    IMDB Rating:  9.1/10",
            "April 13, 2014    IMDB Rating: 9.7/10", "April 20, 2014    IMDB Rating: 8.9/10",
            "April 27, 2014   IMDB Rating:  8.9/10", "May 4, 2014    IMDB Rating: 8.8/10",
            "May 11, 2014    IMDB Rating: 9.7/10", "May 18, 2014   IMDB Rating:  9.2/10",
            "June 1, 2014    IMDB Rating:  9.7/10", "June 8, 2014    IMDB Rating: 9.6/10",
            "June 15, 2014   IMDB Rating: 9.7/10"};

    private final SliderAdapter sliderAdapter = new SliderAdapter(pics, 10, new Season4Activity.OnCardClickListener());

    private CardSliderLayoutManager layoutManger;
    private RecyclerView recyclerView;
    //private ImageSwitcher mapSwitcher;
    private TextSwitcher temperatureSwitcher;
    private TextSwitcher placeSwitcher;
    private TextSwitcher clockSwitcher;
    private TextSwitcher descriptionsSwitcher;
    private View greenDot;

    private TextView country1TextView;
    private TextView country2TextView;
    private int countryOffset1;
    private int countryOffset2;
    private long countryAnimDuration;
    private int currentPosition;

    private DecodeBitmapTask decodeMapBitmapTask;
    private DecodeBitmapTask.Listener mapLoadListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_season4);


        initRecyclerView();
        initCountryText();
        initSwitchers();

    }



    private void initRecyclerView() {
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setAdapter(sliderAdapter);
        recyclerView.setHasFixedSize(true);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    onActiveCardChange();
                }
            }
        });

        layoutManger = (CardSliderLayoutManager) recyclerView.getLayoutManager();

        new CardSnapHelper().attachToRecyclerView(recyclerView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (isFinishing() && decodeMapBitmapTask != null) {
            decodeMapBitmapTask.cancel(true);
        }
    }

    private void initSwitchers() {
        temperatureSwitcher = (TextSwitcher) findViewById(R.id.ts_temperature);
        temperatureSwitcher.setFactory(new Season4Activity.TextViewFactory(R.style.TemperatureTextView, true));
        temperatureSwitcher.setCurrentText(epiNumber[0]);

        placeSwitcher = (TextSwitcher) findViewById(R.id.ts_place);
        placeSwitcher.setFactory(new Season4Activity.TextViewFactory(R.style.PlaceTextView, false));
        placeSwitcher.setCurrentText(epiTitle[0]);

        clockSwitcher = (TextSwitcher) findViewById(R.id.ts_clock);
        clockSwitcher.setFactory(new Season4Activity.TextViewFactory(R.style.ClockTextView, false));
        clockSwitcher.setCurrentText(times[0]);

        descriptionsSwitcher = (TextSwitcher) findViewById(R.id.ts_description);
        descriptionsSwitcher.setInAnimation(this, android.R.anim.fade_in);
        descriptionsSwitcher.setOutAnimation(this, android.R.anim.fade_out);
        descriptionsSwitcher.setFactory(new Season4Activity.TextViewFactory(R.style.DescriptionTextView, false));
        descriptionsSwitcher.setCurrentText(getString(descriptions[0]));

//        mapSwitcher = (ImageSwitcher) findViewById(R.id.ts_map);
//        mapSwitcher.setInAnimation(this, R.anim.fade_in);
//        mapSwitcher.setOutAnimation(this, R.anim.fade_out);
//        mapSwitcher.setFactory(new ImageViewFactory());
//        mapSwitcher.setImageResource(maps[0]);
//
//        mapLoadListener = new DecodeBitmapTask.Listener() {
//            @Override
//            public void onPostExecuted(Bitmap bitmap) {
//                ((ImageView)mapSwitcher.getNextView()).setImageBitmap(bitmap);
//                mapSwitcher.showNext();
//            }
//        };
    }

    private void initCountryText() {
        countryAnimDuration = getResources().getInteger(R.integer.labels_animation_duration);
        countryOffset1 = getResources().getDimensionPixelSize(R.dimen.left_offset);
        countryOffset2 = getResources().getDimensionPixelSize(R.dimen.card_width);
        country1TextView = (TextView) findViewById(R.id.tv_country_1);
        country2TextView = (TextView) findViewById(R.id.tv_country_2);

        country1TextView.setX(countryOffset1);
        country2TextView.setX(countryOffset2);
        country1TextView.setText(episode[0]);
        country2TextView.setAlpha(0f);

        country1TextView.setTypeface(Typeface.createFromAsset(getAssets(), "open-sans-extrabold.ttf"));
        country2TextView.setTypeface(Typeface.createFromAsset(getAssets(), "open-sans-extrabold.ttf"));
    }

//    private void initGreenDot() {
//        mapSwitcher.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
//            @Override
//            public void onGlobalLayout() {
//                mapSwitcher.getViewTreeObserver().removeOnGlobalLayoutListener(this);
//
//                final int viewLeft = mapSwitcher.getLeft();
//                final int viewTop = mapSwitcher.getTop() + mapSwitcher.getHeight() / 3;
//
//                final int border = 100;
//                final int xRange = Math.max(1, mapSwitcher.getWidth() - border * 2);
//                final int yRange = Math.max(1, (mapSwitcher.getHeight() / 3) * 2 - border * 2);
//
//                final Random rnd = new Random();
//
//                for (int i = 0, cnt = dotCoords.length; i < cnt; i++) {
//                    dotCoords[i][0] = viewLeft + border + rnd.nextInt(xRange);
//                    dotCoords[i][1] = viewTop + border + rnd.nextInt(yRange);
//                }
//
//                greenDot = findViewById(R.id.green_dot);
//                greenDot.setX(dotCoords[0][0]);
//                greenDot.setY(dotCoords[0][1]);
//            }
//        });
//    }

    private void setCountryText(String text, boolean left2right) {
        final TextView invisibleText;
        final TextView visibleText;
        if (country1TextView.getAlpha() > country2TextView.getAlpha()) {
            visibleText = country1TextView;
            invisibleText = country2TextView;
        } else {
            visibleText = country2TextView;
            invisibleText = country1TextView;
        }

        final int vOffset;
        if (left2right) {
            invisibleText.setX(0);
            vOffset = countryOffset2;
        } else {
            invisibleText.setX(countryOffset2);
            vOffset = 0;
        }

        invisibleText.setText(text);

        final ObjectAnimator iAlpha = ObjectAnimator.ofFloat(invisibleText, "alpha", 1f);
        final ObjectAnimator vAlpha = ObjectAnimator.ofFloat(visibleText, "alpha", 0f);
        final ObjectAnimator iX = ObjectAnimator.ofFloat(invisibleText, "x", countryOffset1);
        final ObjectAnimator vX = ObjectAnimator.ofFloat(visibleText, "x", vOffset);

        final AnimatorSet animSet = new AnimatorSet();
        animSet.playTogether(iAlpha, vAlpha, iX, vX);
        animSet.setDuration(countryAnimDuration);
        animSet.start();
    }

    private void onActiveCardChange() {
        final int pos = layoutManger.getActiveCardPosition();
        if (pos == RecyclerView.NO_POSITION || pos == currentPosition) {
            return;
        }

        onActiveCardChange(pos);
    }

    private void onActiveCardChange(int pos) {
        int animH[] = new int[] {R.anim.slide_in_right, R.anim.slide_out_left};
        int animV[] = new int[] {R.anim.slide_in_top, R.anim.slide_out_bottom};

        final boolean left2right = pos < currentPosition;
        if (left2right) {
            animH[0] = R.anim.slide_in_left;
            animH[1] = R.anim.slide_out_right;

            animV[0] = R.anim.slide_in_bottom;
            animV[1] = R.anim.slide_out_top;
        }

        setCountryText(episode[pos % episode.length], left2right);

        temperatureSwitcher.setInAnimation(Season4Activity.this, animH[0]);
        temperatureSwitcher.setOutAnimation(Season4Activity.this, animH[1]);
        temperatureSwitcher.setText(epiNumber[pos % epiNumber.length]);

        placeSwitcher.setInAnimation(Season4Activity.this, animV[0]);
        placeSwitcher.setOutAnimation(Season4Activity.this, animV[1]);
        placeSwitcher.setText(epiTitle[pos % epiTitle.length]);

        clockSwitcher.setInAnimation(Season4Activity.this, animV[0]);
        clockSwitcher.setOutAnimation(Season4Activity.this, animV[1]);
        clockSwitcher.setText(times[pos % times.length]);

        descriptionsSwitcher.setText(getString(descriptions[pos % descriptions.length]));

        //showMap(maps[pos % maps.length]);

        ViewCompat.animate(greenDot)
                .translationX(dotCoords[pos % dotCoords.length][0])
                .translationY(dotCoords[pos % dotCoords.length][1])
                .start();

        currentPosition = pos;
    }

    private void showMap(@DrawableRes int resId) {
        if (decodeMapBitmapTask != null) {
            decodeMapBitmapTask.cancel(true);
        }

//        final int w = mapSwitcher.getWidth();
//        final int h = mapSwitcher.getHeight();
//
//        decodeMapBitmapTask = new DecodeBitmapTask(getResources(), resId, w, h, mapLoadListener);
//        decodeMapBitmapTask.execute();
    }

    private class TextViewFactory implements  ViewSwitcher.ViewFactory {

        @StyleRes
        final int styleId;
        final boolean center;

        TextViewFactory(@StyleRes int styleId, boolean center) {
            this.styleId = styleId;
            this.center = center;
        }

        @SuppressWarnings("deprecation")
        @Override
        public View makeView() {
            final TextView textView = new TextView(Season4Activity.this);

            if (center) {
                textView.setGravity(Gravity.CENTER);
            }

            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
                textView.setTextAppearance(Season4Activity.this, styleId);
            } else {
                textView.setTextAppearance(styleId);
            }

            return textView;
        }

    }

    private class ImageViewFactory implements ViewSwitcher.ViewFactory {
        @Override
        public View makeView() {
            final ImageView imageView = new ImageView(Season4Activity.this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            final ViewGroup.LayoutParams lp = new ImageSwitcher.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            imageView.setLayoutParams(lp);

            return imageView;
        }
    }

    private class OnCardClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            final CardSliderLayoutManager lm =  (CardSliderLayoutManager) recyclerView.getLayoutManager();

            if (lm.isSmoothScrolling()) {
                return;
            }

            final int activeCardPosition = lm.getActiveCardPosition();
            if (activeCardPosition == RecyclerView.NO_POSITION) {
                return;
            }

            final int clickedPosition = recyclerView.getChildAdapterPosition(view);
            if (clickedPosition == activeCardPosition) {
                final Intent intent = new Intent(Season4Activity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.BUNDLE_IMAGE_ID, pics[activeCardPosition % pics.length]);

                if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                    startActivity(intent);
                } else {
                    final CardView cardView = (CardView) view;
                    final View sharedView = cardView.getChildAt(cardView.getChildCount() - 1);
                    final ActivityOptions options = ActivityOptions
                            .makeSceneTransitionAnimation(Season4Activity.this, sharedView, "shared");
                    startActivity(intent, options.toBundle());
                }
            } else if (clickedPosition > activeCardPosition) {
                recyclerView.smoothScrollToPosition(clickedPosition);
                onActiveCardChange(clickedPosition);
            }
        }
    }



}
