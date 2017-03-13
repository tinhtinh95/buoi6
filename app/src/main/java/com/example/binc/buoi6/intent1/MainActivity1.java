package com.example.binc.buoi6.intent1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.binc.buoi6.R;

public class MainActivity1 extends AppCompatActivity {
    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);
        mBtnTest = (Button) findViewById(R.id.btnTest);
        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                startActivity(intent);
                //startActivityForResult(intent, 1000);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        mBtnTest.setText("result");
    }
}
