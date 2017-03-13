package com.example.binc.buoi6.intent2;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.binc.buoi6.R;

public class MainActivity2 extends AppCompatActivity {
    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtnTest = (Button) findViewById(R.id.btnTest);

        //set data
        if (getIntent().getStringExtra("key1") != null) {
            mBtnTest.setText(getIntent().getStringExtra("key1"));
        }

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
