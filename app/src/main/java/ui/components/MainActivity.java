package ui.components;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import ui.components.library.CircleDrawable;
import ui.components.library.utilities.Util;

import static ui.components.library.CircleDrawable.Gravity.TOP_RIGHT;
import static ui.components.library.CircleDrawable.Percent.FIFTY;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.text);
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
        });

    }
}
