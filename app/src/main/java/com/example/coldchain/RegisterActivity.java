package com.example.coldchain;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.coldchain.database_Test.MyDatabaseHelper;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    MyDatabaseHelper databaseHelper;

    EditText register_username_ed, register_password_ed;

    Button register_button;

    RadioButton r_buy_register, r_sell_register;

    RadioGroup r_radio_group_register;

    Toolbar toolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        initView();
        r_radio_group_register.setOnCheckedChangeListener(new MyRadioButtonListener());
        databaseHelper = new MyDatabaseHelper(this, "coldchain.db", null, 1);

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


    }

    private void initView() {
        register_button = findViewById(R.id.register_button);

        register_username_ed = findViewById(R.id.register_username_ed);
        register_password_ed = findViewById(R.id.register_password_ed);

        r_buy_register = findViewById(R.id.radio_button_buy_register);
        r_sell_register = findViewById(R.id.radio_button_sell_register);

        r_radio_group_register = findViewById(R.id.r_radio_group_register);

        toolbar=findViewById(R.id.toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        }

    }

    class MyRadioButtonListener implements RadioGroup.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId) {
                case R.id.radio_button_buy_register:
                    register_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            String name = register_username_ed.getText().toString();
                            String password = register_password_ed.getText().toString();

                            if (name.length() == 0 || password.length() == 0) {
                                Toast.makeText(RegisterActivity.this, "账号或密码不能为空！" + "buy", Toast.LENGTH_SHORT).show();
                            } else {
                                if (CheckIsDataAlreadyInDBorNot_buy(name)) {
                                    Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                                } else {
                                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    //开始组装数据
                                    values.put("name", name);
                                    values.put("password", password);
                                    db.insert("transport_user", null, values);
                                    values.clear();
                                    Toast.makeText(RegisterActivity.this, "运输用户注册成功!", Toast.LENGTH_SHORT).show();
                                    Intent Login_test = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(Login_test);
                                    finish();
                                }
                            }
                        }
                    });
                    break;

                case R.id.radio_button_sell_register:
                    register_button.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Toast.makeText(RegisterActivity.this, "r_sell_register", Toast.LENGTH_SHORT).show();
                            String name = register_username_ed.getText().toString();
                            String password = register_password_ed.getText().toString();

                            if (name.length() == 0 || password.length() == 0) {
                                Toast.makeText(RegisterActivity.this, "账号或密码不能为空！" + name, Toast.LENGTH_SHORT).show();
                            } else {
                                if (CheckIsDataAlreadyInDBorNot_sell(name)) {
                                    Toast.makeText(RegisterActivity.this, "用户已存在", Toast.LENGTH_SHORT).show();
                                } else {
                                    SQLiteDatabase db = databaseHelper.getWritableDatabase();
                                    ContentValues values = new ContentValues();
                                    //开始组装数据
                                    values.put("name", name);
                                    values.put("password", password);
                                    db.insert("domestic_user", null, values);
                                    values.clear();
                                    Toast.makeText(RegisterActivity.this, "普通用户注册成功!", Toast.LENGTH_SHORT).show();
                                    Intent Login_test = new Intent(RegisterActivity.this, MainActivity.class);
                                    startActivity(Login_test);
                                    finish();
                                }
                            }
                        }
                    });
                    break;
            }
        }

        //检查用户是否存在
        public boolean CheckIsDataAlreadyInDBorNot_buy(String username) {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            Cursor cursor = db.query("transport_user", null, "name=?", new String[]{username},
                    null, null, null);
            while (cursor.moveToNext()) {
                String user = cursor.getString(1);
                if (!user.isEmpty()) {
                    return true;
                }
            }
            return false;
        }

        public boolean CheckIsDataAlreadyInDBorNot_sell(String username) {
            SQLiteDatabase db = databaseHelper.getWritableDatabase();
            Cursor cursor = db.query("domestic_user", null, "name=?", new String[]{username},
                    null, null, null);
            while (cursor.moveToNext()) {
                String user = cursor.getString(1);
                if (!user.isEmpty()) {
                    return true;
                }
            }
            return false;
        }
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
