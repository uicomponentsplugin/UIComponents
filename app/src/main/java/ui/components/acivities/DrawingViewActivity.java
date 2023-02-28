package ui.components.acivities;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import ui.components.acivities.ads.ViewPager;
import ui.components.databinding.ActivityDrawingViewBinding;

public class DrawingViewActivity extends AppCompatActivity {
    private ActivityDrawingViewBinding binding;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDrawingViewBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        binding.drawingView.addScrollView(binding.scrollView);

    }

    public void getBitmap(View view) {
        binding.imgDrawing.setImageBitmap(binding.drawingView.getBitmap());
//        binding.signature.setImageBitmap(binding.drawingView.getBitmap());
    }

    public void clearDrawing(View view) {
        binding.imgDrawing.setImageDrawable(null);
        binding.drawingView.clearDrawable();
    }

}
