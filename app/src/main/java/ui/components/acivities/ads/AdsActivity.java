package ui.components.acivities.ads;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

import ui.components.adapters.ScreenSlidePagerAdapter;
import ui.components.databinding.ActivityAdsBinding;

public class AdsActivity extends AppCompatActivity {
    private ActivityAdsBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAdsBinding.inflate(LayoutInflater.from(this));
        setContentView(binding.getRoot());

        binding.viewPager.setAdapter(new ScreenSlidePagerAdapter(getSupportFragmentManager()));
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
        binding.tabLayout.setupWithViewPager(binding.viewPager);
    }
}