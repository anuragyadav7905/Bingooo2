package com.bingooo.game;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 1500; // 1.5 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash); // Splash screen layout with logo

        new Handler().postDelayed(() -> {
            Uri data = getIntent().getData();
            if (data != null && data.toString().contains("/dashboard")) {
                getSharedPreferences("bingooo", MODE_PRIVATE)
                        .edit()
                        .putBoolean("isLoggedIn", true)
                        .apply();
            }

            SharedPreferences prefs = getSharedPreferences("bingooo", MODE_PRIVATE);
            boolean isLoggedIn = prefs.getBoolean("isLoggedIn", false);

            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("isLoggedIn", isLoggedIn);
            startActivity(intent);
            finish();
        }, SPLASH_DELAY);
    }
}
