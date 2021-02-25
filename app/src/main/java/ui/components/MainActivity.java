package ui.components;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import ui.components.databinding.ActivityMainBinding;
import ui.components.library.EditText2;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       /* LoadingViewBinding binding = LoadingViewBinding.inflate(getLayoutInflater());
        binding.loadingProgressBar.show();*/
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        binding.editQuery.setOnDrawableClickListener(new EditText2.onDrawableClickListener() {
            @Override
            public void onLeftClick() {
                Log.d("TAG", "onLeftClick: ");
                binding.editQuery.setTextSilently("Changed");
            }

            @Override
            public void onRightClick() {
                binding.editQuery.removeTextChangedListener();
                Log.d("TAG", "onRightClick: ");
            }
        });
        binding.editQuery.addTextChangedListener2(new EditText2.TextWatcher2() {
            @Override
            public void afterTextChanged(String s) {
                Log.d("TAG", "onTextChanged: " + s);
            }
        });
        setContentView(binding.getRoot());
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
