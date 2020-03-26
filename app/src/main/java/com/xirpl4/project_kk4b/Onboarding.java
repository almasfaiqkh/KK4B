package com.xirpl4.project_kk4b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import me.relex.circleindicator.CircleIndicator;

public class Onboarding extends AppCompatActivity {

    private ViewPager viewPager;
    private CircleIndicator circleIndicator;
    private MyPager myPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onboarding);

        myPager = new MyPager(this);
        viewPager = findViewById(R.id.viewPager);
        viewPager.setAdapter(myPager);

        circleIndicator = findViewById(R.id.indicator_onboard);
        circleIndicator.setViewPager(viewPager);

        View daftar = (View) findViewById(R.id.onboard_button);
        daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Onboarding.this, BottomActivity.class));
            }
        });
    }
}
