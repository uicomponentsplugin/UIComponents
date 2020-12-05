package com.daggar2.models;

import com.daggar2.MainActivity;

import dagger.Component;

@Component
public interface CarComponent {
    void inject(MainActivity mainActivity);
}
