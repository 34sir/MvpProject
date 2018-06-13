package com.example.ckc.mvpproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.ckc.mvpproject.common.PublicUtils;
import com.example.ckc.mvpproject.demo.MvpTestFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublicUtils.startActivity(MainActivity.this, MvpTestFragment.class.getName());
            }
        });
    }
}
