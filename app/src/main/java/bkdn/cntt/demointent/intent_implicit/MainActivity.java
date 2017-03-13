package bkdn.cntt.demointent.intent_implicit;

import android.Manifest;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import bkdn.cntt.demointent.R;

/**
 * Created by Administrator on 10/03/2017.
 */

public class MainActivity extends AppCompatActivity {
    private Button mBtnCall, mBtnMessage, mBtnEmail, mBtnCamera, mBtnGalery;
    private ImageView mImg;
    private final  int request=1888;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_implicit);
        mBtnCall = (Button) findViewById(R.id.btnCall);
        mBtnMessage = (Button) findViewById(R.id.btnMessage);
        mBtnEmail = (Button) findViewById(R.id.btnMail);
        mBtnCamera = (Button) findViewById(R.id.btnCamera);
        mBtnGalery = (Button) findViewById(R.id.btnGalery);
        mImg=(ImageView) findViewById(R.id.imgView);

        mBtnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: "+"01653908302"));
                if (ActivityCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                    return;
                }
                startActivity(intent);
            }
        });
        mBtnMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms","01653908302",null));
                intent.putExtra("sms_body","Ahihi đồ chó :v ");
                startActivity(intent);
            }
        });
        mBtnEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Danh sách người nhận
                String[] recipients=new String[]{"tinhchocopie087@gmail.com","kimnahee43@gmail.com"};
                // Tiêu đề email.
                String subject="Ahihi gửi";
                // Nội dung email.
                String content ="Ahihi đồ ngốc :v";
                // CC đến người khác
                String[]cc=new String[]{"luonghieu.t3@gmail.com","abc@gmail.com"};

                Intent intentEmail = new Intent(Intent.ACTION_SENDTO, Uri.parse("mailto:"));
                intentEmail.putExtra(Intent.EXTRA_EMAIL, recipients); // người nhận
                intentEmail.putExtra(Intent.EXTRA_SUBJECT, subject); // tiêu đề mail
                intentEmail.putExtra(Intent.EXTRA_TEXT, content);  // nội dung mail
                intentEmail.putExtra(Intent.EXTRA_CC,cc);

//                intentEmail.setType("text/plain");
                try {
                    startActivity(intentEmail);
//                startActivity(Intent.createChooser(intentEmail, "Choose an email client from..."));
                } catch (ActivityNotFoundException e) {
                    Toast.makeText(getApplicationContext(),"Không tìm thấy",Toast.LENGTH_SHORT).show();
                }
            }
        });

        mBtnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, request);
            }
        });
        mBtnGalery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK,
                        MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                intent.setType("image/*");
                intent.putExtra("crop", "true");
                intent.putExtra("scale", true);
                intent.putExtra("outputX", 256);
                intent.putExtra("outputY", 256);
                intent.putExtra("aspectX", 1);
                intent.putExtra("aspectY", 1);
                intent.putExtra("return-data", true);
                startActivityForResult(intent, 1);
            }
        });

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == request && resultCode==RESULT_OK) {
            Bitmap imageBitmap = (Bitmap) data.getExtras().get("data");
            mImg.setImageBitmap(imageBitmap);
        }else if (requestCode == 1 && resultCode==RESULT_OK) {
            final Bundle extras = data.getExtras();
            if (extras != null) {
                //Get image
                Bitmap newProfilePic = extras.getParcelable("data");
                mImg.setImageBitmap(newProfilePic);
            }
        }
    }
}
