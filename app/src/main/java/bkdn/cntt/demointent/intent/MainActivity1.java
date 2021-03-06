package bkdn.cntt.demointent.intent;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import bkdn.cntt.demointent.R;

/**
 * Created by Administrator on 08/03/2017.
 */

public class MainActivity1 extends AppCompatActivity {
    private Button mBtnChon;
    private EditText mEdtA,mEdtB;
    private TextView mTxtKq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnChon=(Button) findViewById(R.id.btnChon);
        mEdtA=(EditText)findViewById(R.id.edtA);
        mEdtB=(EditText)findViewById(R.id.edtB);
        mTxtKq=(TextView)findViewById(R.id.txtKq);

        mBtnChon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float a = 0f, b = 0f;
                Intent intent = new Intent(MainActivity1.this, MainActivity2.class);
                try {
                    a = Float.parseFloat(mEdtA.getText().toString());
                    b = Float.parseFloat(mEdtB.getText().toString());
                    intent.putExtra("a",a);
                    intent.putExtra("b",b);
                    startActivityForResult(intent,1000);
                } catch (NumberFormatException e) {
                    Toast.makeText(getApplicationContext(),"Nhập số",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data==null){
            return;
        }
        // nhận cách 1
//        float kq=data.getFloatExtra("result",0);
//        mTxtKq.setText(kq+"");

        // nhận cách 2
        Bundle b=data.getExtras();
        float kq= b.getFloat("result");
        mTxtKq.setText(kq+"");
    }

}
