package com.example.binc.buoi6.intent_object;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.binc.buoi6.R;
import com.example.binc.buoi6.models.UserPacer;

public class MainActivity2 extends AppCompatActivity {
    private Button mBtnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mBtnTest = (Button) findViewById(R.id.btnTest);

        //set data
        Bundle bundle = getIntent().getExtras();
        UserPacer userPacer = bundle.getParcelable("pac");
        mBtnTest.setText(userPacer.getmName());

        /*UserSeriable userSeriable = (UserSeriable) bundle.getSerializable("ser");
        mBtnTest.setText(userSeriable.getmName());*/

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
