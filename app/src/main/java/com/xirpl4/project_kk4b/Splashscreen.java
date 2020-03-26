package com.xirpl4.project_kk4b;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.xirpl4.project_kk4b.ui.home.HomeFragment;

import me.relex.circleindicator.CircleIndicator;

public class Splashscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(getApplicationContext(), Onboarding.class));
                finish();
            }
        }, 3000L); //3000 L = 3 detik
    }
}
