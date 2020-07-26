package com.example.coldchain.b_mine_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.coldchain.R;

public class Send_mail extends AppCompatActivity {
    Button sendmessage;
    EditText number,content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_mail);

        sendmessage=findViewById(R.id.send_message);
        number=findViewById(R.id.number);
        content=findViewById(R.id.content_message);
        sendmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.SENDTO");
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setData(Uri.parse("smsto:" + number.getText().toString())); //接收短信的电话号码
                intent.putExtra("sms_body", content.getText().toString());//短信内容
                startActivity(intent);
            }
        });

    }
}
