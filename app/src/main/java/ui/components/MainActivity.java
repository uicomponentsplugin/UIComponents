package ui.components;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

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
        /*CircleDrawable circleDrawable = new CircleDrawable(this);
        circleDrawable.setSizePercent(NINETY);
        circleDrawable.setGravity(CENTER);
        circleDrawable.setText("3");
        circleDrawable.setStrokeWidth(Util.dpToPx(3));
        //circleDrawable.setFilledColor(getColor(R.color.colorPrimaryDark));
        imgCountDrawable.setImageDrawable(circleDrawable);*/

    }
}
