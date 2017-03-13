package com.example.binc.buoi6.intent_bundle;

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
        Bundle bundle = getIntent().getExtras();
        mBtnTest.setText(bundle.getString("key1"));

        mBtnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Intent intent=new Intent();
                intent.putExtra("key22","aaaaaaa");
                setResult(100,intent);*/
                finish();
            }
        });
    }
}
