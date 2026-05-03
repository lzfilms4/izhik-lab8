package com.example.izhik_lab8;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        startAnimation(R.id.sun, R.anim.sun_rise);
        startAnimation(R.id.minute_hand, R.anim.minute_turn);
        startAnimation(R.id.hour_hand, R.anim.hour_turn);
    }

    private void startAnimation(int viewId, int animationId) {
        ImageView imageView = findViewById(viewId);
        Animation animation = AnimationUtils.loadAnimation(this, animationId);
        imageView.startAnimation(animation);
    }
}
