package ui.components;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.method.KeyListener;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import ui.components.databinding.ActivityMainBinding;

public class DemoActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        /*binding.viewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
        Handler handler = new Handler(Looper.getMainLooper());
        Runnable update = new Runnable() {
            @Override
            public void run() {
                int currentIndex = binding.viewPager.getCurrentItem();
                if (currentIndex == Objects.requireNonNull(binding.viewPager.getAdapter()).getCount() - 1) {
                    currentIndex = -1;
                }
                binding.viewPager.setCurrentItem(++currentIndex, true);

                handler.postDelayed(this, 3000);
            }
        };
        handler.postDelayed(update, 3000);
        binding.tabLayout.setupWithViewPager(binding.viewPager);*/

    }

    public void getBitmap(View view) {
        binding.imgDrawing.setImageBitmap(binding.drawingView.getBitmap());
//        binding.signature.setImageBitmap(binding.drawingView.getBitmap());
    }

    public void clearDrawing(View view) {
        binding.imgDrawing.setImageDrawable(null);
        binding.drawingView.clearDrawable();
    }

        /* LoadingViewBinding binding = LoadingViewBinding.inflate(getLayoutInflater());
        binding.loadingProgressBar.show();*/

       /* CardViewAdapter cardViewAdapter = new CardViewAdapter();
        binding.viewPager.setAdapter(cardViewAdapter);
        // binding.viewPager.setPageTransformer(new ui.components.transformers.ZoomOutPageTransformer());
        binding.viewPager.setOffscreenPageLimit(1);
        RecyclerView recyclerView = (RecyclerView) binding.viewPager.getChildAt(0);
        int padding = getResources().getDimensionPixelOffset(R.dimen.halfPageMargin) +
                getResources().getDimensionPixelOffset(R.dimen.peekOffset);
        recyclerView.setPadding(padding, 0, padding, 0);
        recyclerView.setClipToPadding(false);*/
       /* Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
    },3000,3000);

        CircleDrawable circleDrawable = new CircleDrawable(binding.imgCircleDrawable.getContext());
        circleDrawable.setText("Circle");
        circleDrawable.setFilledColor(

                getColor(R.color.colorPrimary));
        circleDrawable.setStrokeColor(

                getColor(R.color.black));
        circleDrawable.setStrokeWidth(Util.dpToPx(4));
        circleDrawable.setTextColor(R.color.red);
        circleDrawable.setGravity(CircleDrawable.Gravity.TOP_RIGHT);
        binding.imgCircleDrawable.setImageDrawable(circleDrawable);
        binding.editQuery.setOnDrawableClickListener(new EditText2.onDrawableClickListener() {
            @Override
            public void onLeftClick() {
                Log.d("TAG", "onLeftClick: ");
                Util.shortToast(binding.editQuery.getContext(), "onLeftDrawableClick");
                // binding.editQuery.setTextSilently("Changed");
            }

            @Override
            public void onRightClick() {
                Util.shortToast(binding.editQuery.getContext(), "onRightDrawableClick");
            }
        });
        binding.editQuery.addTextChangedListener2(new EditText2.TextWatcher2() {
            @Override
            public void afterTextChanged(String s) {
                Log.d("TAG", "onTextChanged: " + s);
            }
        });

        //binding.viewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.POSITION_NONE));
        /*final TextView textView = findViewById(R.id.text);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        ImageView imgCountDrawable = findViewById(R.id.imgCountDrawable);
        final CircleDrawable circleDrawable = new CircleDrawable(this);
        circleDrawable.setSizePercent(FIFTY);
        circleDrawable.setGravity(TOP_RIGHT);
        circleDrawable.setText("300");
        circleDrawable.setStrokeWidth(Util.dpToPx(3));
        //circleDrawable.setFilledColor(getColor(R.color.colorPrimaryDark));
        imgCountDrawable.setImageDrawable(circleDrawable);
        imgCountDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              //  circleDrawable.setText(String.valueOf(Integer.parseInt(circleDrawable.getText()) + 1));
            }
        });*/

}
