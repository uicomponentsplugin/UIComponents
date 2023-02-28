package ui.components.acivities;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import com.tags.popuplibrary.Util;

import ui.components.R;
import ui.components.databinding.ActivityViewComponentsBinding;
import ui.components.library.CircleDrawable;
import ui.components.library.EditText2;

public class ViewComponentsActivity extends AppCompatActivity {
    private ActivityViewComponentsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding =  ActivityViewComponentsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());


        CircleDrawable circleDrawable = new CircleDrawable(binding.imgCircleDrawable.getContext());
        circleDrawable.setText("120000");
        circleDrawable.setFilledColor(R.color.colorPrimary);
        circleDrawable.setStrokeColor(R.color.black);
        circleDrawable.setStrokeWidth(Util.dpToPx(1));
        circleDrawable.setTextColor(R.color.red);
        circleDrawable.setGravity(CircleDrawable.Gravity.TOP_RIGHT);
        circleDrawable.setSizePercent(CircleDrawable.Percent.THIRTY);
        binding.imgCircleDrawable.setImageDrawable(circleDrawable);
        binding.editQuery.setOnDrawableClickListener(new EditText2.onDrawableClickListener() {
            @Override
            public void onLeftClick() {
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
       /*  LoadingViewBinding binding = LoadingViewBinding.inflate(getLayoutInflater());
        binding.loadingProgressBar.show();*/

      /*  CardViewAdapter cardViewAdapter = new CardViewAdapter();
        binding.viewPager.setAdapter(cardViewAdapter);
        // binding.viewPager.setPageTransformer(new ui.components.transformers.ZoomOutPageTransformer());
        binding.viewPager.setOffscreenPageLimit(1);
        RecyclerView recyclerView = (RecyclerView) binding.viewPager.getChildAt(0);
        int padding = getResources().getDimensionPixelOffset(R.dimen.halfPageMargin) +
                getResources().getDimensionPixelOffset(R.dimen.peekOffset);
        recyclerView.setPadding(padding, 0, padding, 0);
        recyclerView.setClipToPadding(false);
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(update);
            }
        }, 3000, 3000);*/

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
}