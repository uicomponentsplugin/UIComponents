package com.daggar2;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.daggar2.models.Car;
import com.daggar2.models.CarComponent;
import com.daggar2.models.DaggerCarComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
   @Inject Car car;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CarComponent carComponent = DaggerCarComponent.create();
        //car = carComponent.getCar();
        carComponent.inject(this);
        car.drive();
    }
}