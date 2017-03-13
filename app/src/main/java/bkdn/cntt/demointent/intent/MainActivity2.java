package bkdn.cntt.demointent.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import bkdn.cntt.demointent.R;

/**
 * Created by Administrator on 08/03/2017.
 */

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnCong,mBtnTru,mBtnNhan,mBtnChia;
    private float a,b;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tinhtoan);

        mBtnCong=(Button)findViewById(R.id.btnCong);
        mBtnTru=(Button)findViewById(R.id.btnTru);
        mBtnNhan=(Button)findViewById(R.id.btnNhan);
        mBtnChia=(Button)findViewById(R.id.btnChia);

//        Bundle bundle=getIntent().getExtras();
//        a=bundle.getFloat("a");
//        b=bundle.getFloat("b");
        a=getIntent().getFloatExtra("a",0);
        b=getIntent().getFloatExtra("b",0);

        mBtnCong.setOnClickListener(this);
        mBtnTru.setOnClickListener(this);
        mBtnNhan.setOnClickListener(this);
        mBtnChia.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v==mBtnCong){
            resultForMain(a+b,1);
        }
        if(v==mBtnTru){
            resultForMain(a-b,2);
        }
        if(v==mBtnNhan){
            resultForMain(a*b,3);
        }
        if(v==mBtnChia){
            resultForMain(a/b,4);
        }
    }
    public void resultForMain(float result, int resultcode){
        Intent intent=new Intent();
        intent.putExtra("result",result);
        setResult(resultcode,intent);
        finish();
    }
}
